package com.exigen.common.repository;


import com.exigen.common.domain.Account;
import com.exigen.common.domain.AccountPasswordReset;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Account> getAllAccounts() {
        List<Account> users = this.entityManager.createNamedQuery("Account.findAllUsers")
                .getResultList();
        return users;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account getOneAccount(Integer userId) {
        return entityManager.find(Account.class, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account getAccountByLogin(String login) {
        Account user = this.entityManager.createNamedQuery("Account.findUserByLogin", Account.class).setParameter("login",
                login).getSingleResult();
        return user;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Account getAccountByEmail(String email) {
        return this.entityManager.createNamedQuery("Account.findUserByEmail", Account.class).setParameter("email",
                email).getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountPasswordReset getAccountPasswordResetByHash(String hash) {
        try{
        return this.entityManager.createNamedQuery("AccountPasswordReset.findByHash",AccountPasswordReset.class).setParameter("hash",
                 hash).getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addAccount(Account account) {
        entityManager.persist(account);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAccount(Account account) {
        entityManager.remove(account);
    }

    /**
     *
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public void addAccountPasswordReset(AccountPasswordReset accountPasswordReset){
        entityManager.persist(accountPasswordReset);
    }

    /**
     *
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public void removeAccountPasswordReset(AccountPasswordReset accountPasswordReset){
        AccountPasswordReset managedAccountPasswordReset = entityManager.merge(accountPasswordReset);
        entityManager.remove(managedAccountPasswordReset);
    }
}
