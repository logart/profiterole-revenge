package com.exigen.common.dao;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.AccountPasswordReset;
import com.exigen.common.domain.Gender;
import com.exigen.common.repository.AccountDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testInMemory.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class AccountDaoImplTest {

    @Autowired
    AccountDao accountDao;
    Account account;
    AccountPasswordReset accountPasswordReset;

    @Before
    public void setup() {
        account = new Account("login", "password", "vasya-pupkin@gmail.com", Gender.Male, new GregorianCalendar(2012, 12, 21), "Ukraine");
        accountPasswordReset = new AccountPasswordReset();
        accountPasswordReset.setAccount(account);
        accountPasswordReset.setHash("1234567890");
    }


    @Test
    public void addAccount() {
        accountDao.addAccount(account);
        Assert.assertEquals(account, accountDao.getOneAccount(account.getId()));
    }

    @Test
    public void addAccountPasswordReset(){
        accountDao.addAccount(account);
        accountDao.addAccountPasswordReset(accountPasswordReset);
        Assert.assertEquals(accountPasswordReset,accountDao.getAccountPasswordResetByHash(accountPasswordReset.getHash()));
    }

    @Test
    public void getOneAccountById() {
        accountDao.addAccount(account);
        Assert.assertEquals(account, accountDao.getOneAccount(account.getId()));
    }

    @Test
    public void getOneAccountByLogin() {
        accountDao.addAccount(account);
        Assert.assertEquals(account, accountDao.getAccountByLogin(account.getLogin()));
    }

    @Test
    public void getOneAccountByEmail(){
        accountDao.addAccount(account);
        Assert.assertEquals(account, accountDao.getAccountByEmail(account.getEmail()));
    }

    @Test
    public void getOneAccountPasswordResetByHash(){
        accountDao.addAccount(account);
        accountDao.addAccountPasswordReset(accountPasswordReset);
        Assert.assertEquals(accountPasswordReset,accountDao.getAccountPasswordResetByHash(accountPasswordReset.getHash()));
    }

    @Test
    public void getAllUsers() {
        Assert.assertNotNull(accountDao.getAllAccounts());
    }

    @Test
    public void updateAccount() {
        accountDao.addAccount(account);
        account.setLogin("newName");
        accountDao.updateAccount(account);
        Assert.assertEquals("newName",accountDao.getOneAccount(account.getId()).getLogin());
    }

    @Test
    public void removeAccount() {
        accountDao.addAccount(account);
        accountDao.removeAccount(account);
        Assert.assertNull(accountDao.getOneAccount(account.getId()));
    }

    @Test
    public void removeAccountPasswordReset() {
        accountDao.addAccount(account);
        accountDao.addAccountPasswordReset(accountPasswordReset);
        accountDao.removeAccountPasswordReset(accountPasswordReset);
        Assert.assertNull(accountDao.getAccountPasswordResetByHash(accountPasswordReset.getHash()));

    }
}
