package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.Gender;
import com.exigen.common.domain.RegistrationData;
import com.exigen.common.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    AccountDao accountDao;

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
        accountDao.addAccount(account);
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            return null;
        }
        return cal;

    }
}
