package com.exigen.common.repository;


import com.exigen.common.domain.AbstractAccount;
import com.exigen.common.domain.AbstractHashOfAccount;
import com.exigen.common.domain.AccountUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
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
    public List<AccountUser> getAllAccounts() {
        List<AccountUser> users = this.entityManager.createNamedQuery("AccountUser.findAllUsers")
                .getResultList();
        return users;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountUser getOneAccount(Integer userId) {
        return entityManager.find(AccountUser.class, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountUser getAccountUserByLogin(String login) {
        AccountUser user = this.entityManager.createNamedQuery("AccountUser.findUserByLogin", AccountUser.class).setParameter("login",
                login).getSingleResult();
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractAccount getAccountByLogin(String login){
        AbstractAccount abstractAccount = this.entityManager.createNamedQuery("AbstractAccount.findUserByLogin", AbstractAccount.class).setParameter("login",
                login).getSingleResult();
        return abstractAccount;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountUser getAccountByEmail(String email) {
        return this.entityManager.createNamedQuery("AccountUser.findUserByEmail", AccountUser.class).setParameter("email",
                email).getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addAccount(AccountUser accountUser) {
        entityManager.persist(accountUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateAccount(AccountUser accountUser) {
        entityManager.merge(accountUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAccount(AccountUser accountUser) {
        entityManager.remove(accountUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends AbstractHashOfAccount> T getHashesOfAccountByHash(String hash, Class<T> hashClass) {
        return this.entityManager.find(hashClass, hash);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addHashesOfAccount(AbstractHashOfAccount abstractHashOfAccount){
        entityManager.persist(abstractHashOfAccount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void removeHashOfAccount(String hash,Class<? extends AbstractHashOfAccount> hashClass){
        AbstractHashOfAccount abstractHashOfAccount = this.entityManager.find(hashClass, hash);
        entityManager.remove(abstractHashOfAccount);
    }

}
