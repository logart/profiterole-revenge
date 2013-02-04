package com.exigen.common.repository;


import com.exigen.common.domain.Account;
import org.springframework.stereotype.Repository;

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
    public List<Account> getAllUsers() {
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
    public void addAccount(Account account) {
        entityManager.persist(account);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAccount(Account account) {
        entityManager.remove(account);
    }
}