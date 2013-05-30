package com.exigen.common.repository;


import com.exigen.common.domain.Account;
import com.exigen.common.domain.HashesOfAccount;

import java.util.List;

/**
 * Interface {@code AccountDao} used for get, add and remove objects
 * from Account entity with helps JPA
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
    List<Account> getAllAccounts();

    /**
     * {method getAccountByLogin(String login)}
     *
     * @param login (unique identificator of some particular user)
     * @return the user, where Account field login equals parameter login( return complete description
     *         of with all entity's fields).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when userId is null, or id has no results in the database)
     */
    Account getAccountByLogin(String login);

    /**
     *
     * @param email  (unique identificator of some particular user)
     * @return the user, where Account field email equals parameter email( return complete description
     *         of with all entity's fields).
     */

    Account getAccountByEmail(String email);

    /**
     *
     * @param hash (unique identificator of some particular user)
     * @return  the user, where hash equals parameter hash( return complete description
     *         of with all entity's fields).
     */
    HashesOfAccount getHashesOfAccountByHash(String hash);

    /**
     * {method getOneRecipeList(Integer recipeId)}
     *
     * @param userId (unique identificator of some particular user)
     * @return the users, where Account field id equals parameter userId( return complete description
     *         of with all entity's fields).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when userId is null, or id has no results in the database)
     */
    Account getOneAccount(Integer userId);

    /**
     * {method addAccount(Account account)}
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
     * {method updateAccount(Account account)}
     * for updating information about some particular user in DB
     *
     * @param account (object of some particular user)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when user is null)
     */
    void updateAccount(Account account);

    /**
     * {method removeAccount(Account account)}
     * for remove some particular account from DB
     *
     * @param account (object of some particular user)
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when account is null)
     */
    void removeAccount(Account account);

    /**
     * addHashesOfAccount(HashesOfAccount hashesOfAccount)
     * for adding information about some particular user into DB
     *
     * @param hashesOfAccount (object of some particular user)
     */
    void addHashesOfAccount(HashesOfAccount hashesOfAccount);

    /**
     * removeHashesOfAccount(HashesOfAccount hashesOfAccount)
     * for remove information about hash and some particular user from DB
     * after use it in changing forgotten password process
     *
     * @param hashesOfAccount (object of HashesOfAccount)
     */
    void removeHashesOfAccount(HashesOfAccount hashesOfAccount);


}
