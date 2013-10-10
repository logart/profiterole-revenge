package com.exigen.common.service;

import com.exigen.common.domain.AbstractAccount;
import com.exigen.common.domain.AccountData;
import com.exigen.common.domain.AccountUser;
import com.exigen.common.domain.RegistrationData;

import java.util.List;

/**
 * Interface {@code AccountService} used for get, add and remove objects
 * from AccountUser
 *
 * @author Oleg Kalinichenko
 * @date February 15,2013
 */
public interface AccountService {
    /**
     * {@method findByUsername(String username)}
     *
     * @param username (unique identificator of some particular user)
     * @return the user, where AccountUser field login equals parameter login( return complete description
     *         of with all entity's fields). If user wasn't found, return null.
     * @throws org.springframework.dao.DataAccessException
     *          (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    AccountUser findByUsername(String username);

    /**
     * {@method findAccountByUsername(String username)}
     *
     * @param username (unique identificator of some particular user)
     * @return the user, where AbstractAccount field login equals parameter login( return complete description
     *         of with all entity's fields). If user wasn't found, return null.
     */

    AbstractAccount findAccountByUserName(String username);

    /**
     * {@method findByEmail(String email)}
     * @param email (unique identificator of some particular user)
     * @return the user, where AccountUser field email equals parameter email (return complete description
     *         of with all entity's fields). If user wasn't found, return null.
     */
    AccountUser findByEmail(String email);

    /**
     * {@method addAccount(AccountUser accountUser)}
     * for adding information about some particular user into DB
     *
     * @param accountUser (object of some particular user)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when user is null)
     */
    void addAccount(AccountUser accountUser);

    /**
     * {@method getAllAccounts()}
     *
     * @return list of all users, who registered on site
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when search has no results in the database)
     */
    List<AccountUser> getAllAccounts();

    /**
     * {@method addAccount(RegistrationData data)}
     * for adding information about some particular user into DB
     *
     * @param data (object of some particular user)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when user is null)
     * @throws NotificationException (when there are errors of notification service)
     */
    void addAccount(RegistrationData data) throws NotificationException;

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
     * {@method accountDataFromAccount(AccountUser accountUser)}
     * for getting accountData object from accountUser
     *
     * @param accountUser (object of AccountUser)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when accountUser is null)
     */
    AccountData accountDataFromAccount(AccountUser accountUser);

    /**
     * {@method changeForgottenUserPassword(String hash, String newPassword)}
     * for changing password in account, that given by hash from ResetPasswordHash
     *
     * @param hash (string with hash)
     * @param newPassword (string with newPassword)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when AbstractHashOfAccount is null)
     */
    void changeForgottenUserPassword(String hash, String newPassword) ;

    /**
     * {@method activationHashSendMail(String email)} using for create entity ActivationHash
     * with unique hash code and account, then call NotificationService (create message),
     * and call SendMailService (send message)
     * @param email (unique identificator of some particular user)
     * @throws NotificationException (when file.ftl delete from freemarker)
     */
    void activationHashSendMail(String email)throws NotificationException;

    /**
     * {@method resetPasswordHashSendMail(String email)} using for create entity ResetPasswordHash
     * with unique hash code and account, then call NotificationService (create message),
     * and call SendMailService (send message)
     * @param email (unique identificator of some particular user)
     * @throws NotificationException (when file.ftl delete from freemarker)
     */
    void resetPasswordHashSendMail(String email) throws  NotificationException;

    /**
     * {@method activationOfAccount(String hash)}
     * for activation of account for user
     *
     * @param hash (string of hash)
     *
     */
    AccountUser activationOfAccount(String hash);

}
