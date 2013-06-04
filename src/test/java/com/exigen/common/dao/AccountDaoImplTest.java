package com.exigen.common.dao;

import com.exigen.common.domain.*;
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
    ActivationHash activationHash;
    ResetPasswordHash resetPasswordHash;

    @Before
    public void setup() {
        account = new Account("login", "password", "vasya-pupkin@gmail.com", Gender.Male, new GregorianCalendar(2012, 12, 21), "Ukraine");
        activationHash = new ActivationHash();
        activationHash.setAccount(account);
        activationHash.setHash("12345");

        resetPasswordHash = new ResetPasswordHash();
        resetPasswordHash.setHash("123456789");
        resetPasswordHash.setAccount(account);

    }


    @Test
    public void addAccount() {
        accountDao.addAccount(account);
        Assert.assertEquals(account, accountDao.getOneAccount(account.getId()));
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
    public void addHashesOfAccount1(){
        String hash = "1111111";
        accountDao.addAccount(account);
        activationHash.setAccount(account);
        activationHash.setHash("1111111");
        accountDao.addHashesOfAccount(activationHash);
        Assert.assertEquals(activationHash,accountDao.getHashesOfAccountByHash(hash, ActivationHash.class ));
    }

    @Test
    public void addHashesOfAccount2(){
        String hash = "2222222";
        accountDao.addAccount(account);
        resetPasswordHash.setAccount(account);
        resetPasswordHash.setHash("2222222");
        accountDao.addHashesOfAccount(resetPasswordHash);
        Assert.assertEquals(resetPasswordHash,accountDao.getHashesOfAccountByHash(hash, ResetPasswordHash.class));
    }

    @Test
    public void getOneHashesOfAccountByHash1(){
        String hash = "1111111";
        activationHash.setAccount(account);
        activationHash.setHash("1111111");
        accountDao.addHashesOfAccount(activationHash);
        Assert.assertEquals(activationHash,accountDao.getHashesOfAccountByHash(hash, ActivationHash.class));

    }

    @Test
    public void getOneHashesOfAccountByHash2(){
        String hash = "2222222";
        resetPasswordHash.setAccount(account);
        resetPasswordHash.setHash("2222222");
        accountDao.addHashesOfAccount(resetPasswordHash);
        Assert.assertEquals(resetPasswordHash, accountDao.getHashesOfAccountByHash(hash, ResetPasswordHash.class));
    }

}
