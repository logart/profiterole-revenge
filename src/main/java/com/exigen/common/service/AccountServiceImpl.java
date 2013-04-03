package com.exigen.common.service;

import com.exigen.common.domain.*;
import com.exigen.common.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
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
    public void addAccount(RegistrationData data) {
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
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateAccount(AccountData data) {
        Account account = findByUsername(data.getLogin());
        account.setPassword(data.getPassword());
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
    private String generateHash(int size){
        SecureRandom r = new SecureRandom();
        byte[] randomBytes = new byte[size];
        r.nextBytes(randomBytes);
        return String.valueOf(Hex.encode(randomBytes));
    }

    /**
     * {@inheritDoc}
     */

    public void resetUserPassword(String email) throws ServiceException{
        AccountPasswordReset accountPasswordReset = null;
        try{
            accountPasswordReset = accountDao.getAccountPasswordResetByHash(generateHash(HASH_SIZE));
        }  catch (EmptyResultDataAccessException ex){
            // No record found. proceeding with registration of pass reset
        }
        if (accountPasswordReset != null){
            throw new ServiceException();
        }  else {
            accountPasswordReset = new AccountPasswordReset();
            accountPasswordReset.setHash(generateHash(HASH_SIZE));
            accountPasswordReset.setAccount(accountDao.getAccountByEmail(email));
            accountDao.addAccountPasswordReset(accountPasswordReset);
        }
    }
}
