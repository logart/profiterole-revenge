package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.AccountData;
import com.exigen.common.domain.RegistrationData;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Interface {@code AccountService} used for get, add and remove objects
 * from Account
 *
 * @author Oleg Kalinichenko
 * @date February 15,2013
 */
public interface AccountService {
    /**
     * {@method findByUsername(String username)}
     *
     * @param username (unique identificator of some particular user)
     * @return the user, where Account field login equals parameter login( return complete description
     *         of with all entity's fields). If user wasn't found, return null.
     * @throws org.springframework.dao.DataAccessException
     *          (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    Account findByUsername(String username);

    /**
     * {@method findByEmail(String email)}
     * @param email (unique identificator of some particular user)
     * @return the user, where Account field email equals parameter email (return complete description
     *         of with all entity's fields). If user wasn't found, return null.
     */
    Account findByEmail(String email);

    /**
     * {@method addAccount(Account account)}
     * for adding information about some particular user into DB
     *
     * @param account (object of some particular user)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when user is null)
     */
    void addAccount(Account account);

    /**
     * {@method getAllAccounts()}
     *
     * @return list of all users, who registered on site
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when search has no results in the database)
     */
    List<Account> getAllAccounts();

    /**
     * {@method addAccount(RegistrationData data)}
     * for adding information about some particular user into DB
     *
     * @param data (object of some particular user)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when user is null)
     */
    void addAccount(RegistrationData data);

    /**
     * {@method updateAccount(AccountData data)}
     * for updating information about some particular user in DB
     *
     * @param data (object of AccountData)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when user is null)
     */
    void updateAccount(AccountData data);

    /**
     * {@method accountDataFromAccount(Account account)}
     * for getting accountData object from account
     *
     * @param account (object of Account)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when account is null)
     */
    AccountData accountDataFromAccount(Account account);

    /**
     * {@method resetUserPassword(String email)}
     * @param email (unique identificator of some particular user)
     */
    void resetUserPassword(String email) throws ServiceException;

}
