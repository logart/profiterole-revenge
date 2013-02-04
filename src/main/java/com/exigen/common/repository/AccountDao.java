package com.exigen.common.repository;

import com.exigen.common.domain.Account;

import java.util.List;

/**
 * Interface {@code AccountDao} used for get, add and remove objects
 * from Account entity with helps JPA
 *
 * @author Ivan
 * @date Jan 30,2013
 */
public interface AccountDao {

    /**
     * {@method getAllUsers()}
     *
     * @return list of all users, who registered on site
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when search has no results in the database)
     */
    List<Account> getAllUsers();

    /**
     * {@method getOneRecipeList(Integer recipeId)}
     *
     * @param userId (unique identificator of some particular user)
     * @return the users, where Account field userId equals parameter userId( return complete description
     *         of with all entity's fields).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when userId is null, or id has no results in the database)
     */
    Account getOneAccount(Integer userId);

    /**
     * {@method addAccount(Account account)}
     * for adding information about some particular user into DB
     *
     * @param account (object of some particular user)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when user is null)
     */
    void addAccount(Account account);

    /**
     * {@method removeAccount(Account account)}
     * for remove some particular account from DB
     *
     * @param account (object of some particular user)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when account is null)
     */
    void removeAccount(Account account);

}