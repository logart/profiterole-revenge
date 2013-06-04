package com.exigen.common.service;

import com.exigen.common.domain.*;
import com.exigen.common.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


/**
 * Class {@code AccountService} used for push object from and in DAO for get and
 * add objects into DB with helps SpringTransaction and JPA
 *
 * @author Oleg Kalinichenko
 * @date February 5,2013
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private NotificationService notificationService;



    public static final int HASH_SIZE = 32;

    public AccountServiceImpl() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account findByUsername(String username) {
        try {
            return accountDao.getAccountByLogin(username);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account findByEmail(String email){
        try {
            return accountDao.getAccountByEmail(email);
        }  catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Account> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addAccount(RegistrationData data) throws NotificationException{
        Account account = new Account();
        account.setLogin(data.getLogin());
        account.setPassword(data.getPassword());
        account.setEmail(data.getEmail());
        if (data.getMaleOrFemale() != null) {
            account.setMaleOrFemale(Gender.valueOf(data.getMaleOrFemale()));
        }
        account.setDateOfBirth(getCalendar(data.getDateOfBirth()));
        account.setCountry(data.getCountry());
        accountDao.addAccount(account);

        activationHashSendMail(account.getEmail());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateAccount(AccountData data) {
        Account account = findByUsername(data.getLogin());
        if(data.getChangePassword()!=null){
            account.setPassword(data.getChangePassword());
        }
        account.setEmail(data.getEmail());
        if (data.getMaleOrFemale() != null) {
            account.setMaleOrFemale(Gender.valueOf(data.getMaleOrFemale()));
        }
        account.setDateOfBirth(getCalendar(data.getDateOfBirth()));
        account.setCountry(data.getCountry());
        accountDao.updateAccount(account);
    }

    /**
     * {@method getCalendar(String date)}
     *
     * @param date (date in String type in format dd.mm.yyyy)
     * @return return Calendar with inserted date from variable date.
     *  if variable con
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when userId is null, or id has no results in the database)
     */
    private Calendar getCalendar(String date) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            return null;
        }
        return cal;

    }

    /**
     * {@inheritDoc}
     */
    public AccountData accountDataFromAccount(Account account){
        AccountData data = new AccountData();
        data.setLogin(account.getLogin());
        data.setEmail(account.getEmail());
        data.setPassword(account.getPassword());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        data.setDateOfBirth((account.getDateOfBirth()!=null)?sdf.format(account.getDateOfBirth().getTime()):null);
        data.setMaleOrFemale((account.getMaleOrFemale()!=null)?account.getMaleOrFemale().name():null) ;
        data.setCountry(account.getCountry());
        return data;
    }

    /**
     *  generate Hash code
     * @return   hash
     */
    public String generateHash(int size){
        SecureRandom r = new SecureRandom();
        byte[] randomBytes = new byte[size];
        r.nextBytes(randomBytes);
        return String.valueOf(Hex.encode(randomBytes));
    }

    /**
     * {@method createHashForHashOfAccount()}
     *
     * @return unique hash for  AbstractHashOfAccount
     *
     */
    public String createHashForHashOfAccount(Class<? extends AbstractHashOfAccount> hashClass){
        AbstractHashOfAccount abstractHashOfAccount;
        String hash;
        do {
            hash = generateHash(HASH_SIZE);
            abstractHashOfAccount = accountDao.getHashesOfAccountByHash(hash, hashClass);
        }
        while (abstractHashOfAccount != null);
        return hash;
    }

    /**
     * {@method activationHashSendMail(String email)} using for create entity ActivationHash
     * with unique hash code and account, then call NotificationService (create message),
     * and call SendMailService (send message)
     * @param email (unique identificator of some particular user)
     * @throws NotificationException (when file.ftl delete from freemarker)
     *
     */
    public void activationHashSendMail(String email)throws NotificationException{
        ActivationHash activationHash = new ActivationHash();
        String hash = createHashForHashOfAccount(ActivationHash.class);
        Account account = accountDao.getAccountByEmail(email);
        activationHash.setHash(hash);
        activationHash.setAccount(account);
        accountDao.addHashesOfAccount(activationHash);
        String message = notificationService.createActivationMessage(activationHash.getHash(),account.getLogin());
        sendMailService.sendMail(message, account.getEmail());

    }

    /**
     * {@method resetPasswordHashSendMail(String email)} using for create entity ResetPasswordHash
     * with unique hash code and account, then call NotificationService (create message),
     * and call SendMailService (send message)
     * @param email (unique identificator of some particular user)
     * @throws NotificationException (when file.ftl delete from freemarker)
     */
    public void resetPasswordHashSendMail(String email) throws  NotificationException {
        ResetPasswordHash resetPasswordHash = new ResetPasswordHash();
        String hash = createHashForHashOfAccount(ResetPasswordHash.class);
        Account account = accountDao.getAccountByEmail(email);
        resetPasswordHash.setHash(hash);
        resetPasswordHash.setAccount(account);
        accountDao.addHashesOfAccount(resetPasswordHash);
        String message = notificationService.createResetPasswordMessage(resetPasswordHash.getHash(),account.getLogin());
        sendMailService.sendMail(message, email);

    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void changeForgottenUserPassword(String hash, String newPassword) {
        ResetPasswordHash resetPasswordHash = accountDao.getHashesOfAccountByHash(hash, ResetPasswordHash.class);
        Account account = resetPasswordHash.getAccount();
        account.setPassword(newPassword);
        accountDao.updateAccount(account);
        accountDao.removeHashOfAccount(hash,ResetPasswordHash.class);
    }


    /**
     * {@method activationOfAccount(String hash)}
     * for activation of account for user
     *
     * @param hash (string of hash)
     *
     */
    @Transactional
    public Account  activationOfAccount(String hash){
        ActivationHash activationHash = accountDao.getHashesOfAccountByHash(hash, ActivationHash.class);
        Account account;

        if(activationHash!=null){
            account = activationHash.getAccount();
          if (account.getRole().equals(Account.ROLE_INACTIVE_USER)){
               account.setRole(Account.ROLE_USER);
               accountDao.updateAccount(account);
               accountDao.removeHashOfAccount(hash, ActivationHash.class);
           } else {
               accountDao.removeHashOfAccount(hash, ActivationHash.class);
           }
        }

        else {
            account = null;
        }
        return account;
    }
}
