package com.exigen.common.repository;


import com.exigen.common.domain.AbstractAccount;
import com.exigen.common.domain.AbstractHashOfAccount;
import com.exigen.common.domain.AccountUser;

import java.util.List;

/**
 * Interface {@code AccountDao} used for get, add and remove objects
 * from AccountUser entity with helps JPA
 *
 * @author Ivan
 * date Jan 30,2013
 */
public interface AccountDao {

    /**
     * {method getAllAccounts()}
     *
     * @return list of all users, who registered on site
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when search has no results in the database)
     */
    List<AccountUser> getAllAccounts();

    /**
     * {method getAccountUserByLogin(String login)}
     *
     * @param login (unique identificator of some particular user)
     * @return the user, where AccountUser field login equals parameter login( return complete description
     *         of with all entity's fields).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when userId is null, or id has no results in the database)
     */
    AccountUser getAccountUserByLogin(String login);

    /**
     * {method getAccountByLogin(String login)}
     *
     * @param login (unique identificator of some particular user)
     * @return the user, where AbstractAccount field login equals parameter login( return complete description
     *         of with all entity's fields).
     */

    AbstractAccount getAccountByLogin(String login);


    /**
     *
     * @param email  (unique identificator of some particular user)
     * @return the user, where AccountUser field email equals parameter email( return complete description
     *         of with all entity's fields).
     */

    AccountUser getAccountByEmail(String email);

    /**
     * {method getOneRecipeList(Integer recipeId)}
     *
     * @param userId (unique identificator of some particular user)
     * @return the users, where AccountUser field id equals parameter userId( return complete description
     *         of with all entity's fields).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when userId is null, or id has no results in the database)
     */
    AccountUser getOneAccount(Integer userId);

    /**
     * {method addAccount(AccountUser accountUser)}
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
     * {method updateAccount(AccountUser accountUser)}
     * for updating information about some particular user in DB
     *
     * @param accountUser (object of some particular user)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when user is null)
     */
    void updateAccount(AccountUser accountUser);

    /**
     * {method removeAccount(AccountUser accountUser)}
     * for remove some particular accountUser from DB
     *
     * @param accountUser (object of some particular user)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when accountUser is null)
     */
    void removeAccount(AccountUser accountUser);

    /**
     *
     * @param hash, hashClass
     * @return  hashClass, where hash equals parameter hash( return complete description
     *          of with all entity's fields).
     */
    <T extends AbstractHashOfAccount> T getHashesOfAccountByHash(String hash, Class<T> hashClass);

    /**
     * addHashesOfAccount(AbstractHashOfAccount abstractHashOfAccount)
     * for adding information about some particular user into DB
     *
     * @param abstractHashOfAccount (object of some particular user)
     */
    void addHashesOfAccount(AbstractHashOfAccount abstractHashOfAccount);

     /**
     * removeHashOfAccount(String hash, Class<? extends AbstractHashOfAccount> hashClass)
     * for remove information about hash and some particular user from DB
     * after use it in changing forgotten password
     * and activation  process
     *
     */

     void removeHashOfAccount(String hash, Class<? extends AbstractHashOfAccount> hashClass);

}
