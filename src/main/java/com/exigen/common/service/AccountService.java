package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.RegistrationData;

import java.util.Calendar;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: TonySoprano
 * Date: 18.02.13
 * Time: 1:06
 * To change this template use File | Settings | File Templates.
 */
public interface AccountService {
    /**
     * {@method findByUsername(String username)}
     *
     * @param username (unique identificator of some particular user)
     * @return the user, where Account field login equals parameter login( return complete description
     *         of with all entity's fields). If user wasn't found, return null.
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     */
    Account findByUsername(String username);
    /**
     * {@method addAccount(Account account)}
     * for adding information about some particular user into DB
     *
     * @param account (object of some particular user)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when user is null)
     */
    void addAccount(Account account);
    /**
     * {@method getAllAccounts()}
     *
     * @return list of all users, who registered on site
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when search has no results in the database)
     */
    List<Account> getAllAccounts();
    /**
     * {@method addAccount(RegistrationData data)}
     * for adding information about some particular user into DB
     *
     * @param data (object of some particular user)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when user is null)
     */
    void addAccount(RegistrationData data);
}
