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
    public AccountUser findByUsername(String username) {
        try {
            return accountDao.getAccountUserByLogin(username);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractAccount findAccountByUserName(String username){
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
    public AccountUser findByEmail(String email){
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
    public void addAccount(AccountUser accountUser) {
        accountDao.addAccount(accountUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AccountUser> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addAccount(RegistrationData data) throws NotificationException{
        AccountUser accountUser = new AccountUser(data.getLogin(), data.getPassword(), data.getEmail());
        if (data.getMaleOrFemale() != null) {
            accountUser.setMaleOrFemale(Gender.valueOf(data.getMaleOrFemale()));
        }
        accountUser.setDateOfBirth(getCalendar(data.getDateOfBirth()));
        accountUser.setCountry(data.getCountry());
        accountUser.setRole(RoleConstants.ROLE_INACTIVE_USER);
        accountDao.addAccount(accountUser);

        activationHashSendMail(accountUser.getEmail());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateAccount(AccountData data) {
        AccountUser accountUser = findByUsername(data.getLogin());
        if(data.getChangePassword()!=null){
            accountUser.setPassword(data.getChangePassword());
        }
        accountUser.setEmail(data.getEmail());
        if (data.getMaleOrFemale() != null) {
            accountUser.setMaleOrFemale(Gender.valueOf(data.getMaleOrFemale()));
        }
        accountUser.setDateOfBirth(getCalendar(data.getDateOfBirth()));
        accountUser.setCountry(data.getCountry());
        accountDao.updateAccount(accountUser);
    }

    /**
     * {@method getCalendar(String date)}
     *
     * @param date (date in String type in format dd.mm.yyyy)
     * @return return Calendar with inserted date from variable date.
     *  if variable con
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
    public AccountData accountDataFromAccount(AccountUser accountUser){
        AccountData data = new AccountData();
        data.setLogin(accountUser.getLogin());
        data.setEmail(accountUser.getEmail());
        data.setPassword(accountUser.getPassword());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        data.setDateOfBirth((accountUser.getDateOfBirth()!=null)?sdf.format(accountUser.getDateOfBirth().getTime()):null);
        data.setMaleOrFemale((accountUser.getMaleOrFemale()!=null)? accountUser.getMaleOrFemale().name():null) ;
        data.setCountry(accountUser.getCountry());
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
        AccountUser accountUser = accountDao.getAccountByEmail(email);
        activationHash.setHash(hash);
        activationHash.setAccountUser(accountUser);
        accountDao.addHashesOfAccount(activationHash);
        String message = notificationService.createActivationMessage(activationHash.getHash(), accountUser.getLogin());
        sendMailService.sendMail(message, accountUser.getEmail());

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
        AccountUser accountUser = accountDao.getAccountByEmail(email);
        resetPasswordHash.setHash(hash);
        resetPasswordHash.setAccountUser(accountUser);
        accountDao.addHashesOfAccount(resetPasswordHash);
        String message = notificationService.createResetPasswordMessage(resetPasswordHash.getHash(), accountUser.getLogin());
        sendMailService.sendMail(message, email);

    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void changeForgottenUserPassword(String hash, String newPassword) {
        ResetPasswordHash resetPasswordHash = accountDao.getHashesOfAccountByHash(hash, ResetPasswordHash.class);
        AccountUser accountUser = resetPasswordHash.getAccountUser();
        accountUser.setPassword(newPassword);
        accountDao.updateAccount(accountUser);
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
    public AccountUser activationOfAccount(String hash){
        ActivationHash activationHash = accountDao.getHashesOfAccountByHash(hash, ActivationHash.class);
        AccountUser accountUser;

        if(activationHash!=null){
            accountUser = activationHash.getAccountUser();
          if (accountUser.getRole().equals(RoleConstants.ROLE_INACTIVE_USER)){
               accountUser.setRole(RoleConstants.ROLE_USER);
               accountDao.updateAccount(accountUser);
               accountDao.removeHashOfAccount(hash, ActivationHash.class);
           } else {
               accountDao.removeHashOfAccount(hash, ActivationHash.class);
           }
        }

        else {
            accountUser = null;
        }
        return accountUser;
    }
}
