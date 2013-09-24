package com.exigen.common.dao;

import com.exigen.common.domain.AccountUser;
import com.exigen.common.domain.ActivationHash;
import com.exigen.common.domain.ResetPasswordHash;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testInMemory.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class AccountDaoImplTest {

    @Autowired
    AccountDao accountDao;
    AccountUser accountUser;
    ActivationHash activationHash;
    ResetPasswordHash resetPasswordHash;

    @Before
    public void setup() {
        accountUser = new AccountUser("login", "password", "vasya-pupkin@gmail.com");
        activationHash = new ActivationHash();
        activationHash.setAccountUser(accountUser);
        activationHash.setHash("12345");

        resetPasswordHash = new ResetPasswordHash();
        resetPasswordHash.setHash("123456789");
        resetPasswordHash.setAccountUser(accountUser);

    }


    @Test
    public void addAccount() {
        accountDao.addAccount(accountUser);
        Assert.assertEquals(accountUser, accountDao.getOneAccount(accountUser.getId()));
    }



    @Test
    public void getOneAccountById() {
        accountDao.addAccount(accountUser);
        Assert.assertEquals(accountUser, accountDao.getOneAccount(accountUser.getId()));
    }

    @Test
    public void getOneAccountByLogin() {
        accountDao.addAccount(accountUser);
        Assert.assertEquals(accountUser, accountDao.getAccountByLogin(accountUser.getLogin()));
    }

    @Test
    public void getOneAccountByEmail(){
        accountDao.addAccount(accountUser);
        Assert.assertEquals(accountUser, accountDao.getAccountByEmail(accountUser.getEmail()));
    }

    @Test
    public void getAllUsers() {
        Assert.assertNotNull(accountDao.getAllAccounts());
    }

    @Test
    public void updateAccount() {
        accountDao.addAccount(accountUser);
        accountUser.setLogin("newName");
        accountDao.updateAccount(accountUser);
        Assert.assertEquals("newName",accountDao.getOneAccount(accountUser.getId()).getLogin());
    }

    @Test
    public void removeAccount() {
        accountDao.addAccount(accountUser);
        accountDao.removeAccount(accountUser);
        Assert.assertNull(accountDao.getOneAccount(accountUser.getId()));
    }

    @Test
    public void addHashesOfAccount1(){
        String hash = "1111111";
        accountDao.addAccount(accountUser);
        activationHash.setAccountUser(accountUser);
        activationHash.setHash("1111111");
        accountDao.addHashesOfAccount(activationHash);
        Assert.assertEquals(activationHash,accountDao.getHashesOfAccountByHash(hash, ActivationHash.class ));
    }

    @Test
    public void addHashesOfAccount2(){
        String hash = "2222222";
        accountDao.addAccount(accountUser);
        resetPasswordHash.setAccountUser(accountUser);
        resetPasswordHash.setHash("2222222");
        accountDao.addHashesOfAccount(resetPasswordHash);
        Assert.assertEquals(resetPasswordHash,accountDao.getHashesOfAccountByHash(hash, ResetPasswordHash.class));
    }

    @Test
    public void getOneHashesOfAccountByHash1(){
        String hash = "1111111";
        activationHash.setAccountUser(accountUser);
        activationHash.setHash("1111111");
        accountDao.addHashesOfAccount(activationHash);
        Assert.assertEquals(activationHash,accountDao.getHashesOfAccountByHash(hash, ActivationHash.class));

    }

    @Test
    public void getOneHashesOfAccountByHash2(){
        String hash = "2222222";
        resetPasswordHash.setAccountUser(accountUser);
        resetPasswordHash.setHash("2222222");
        accountDao.addHashesOfAccount(resetPasswordHash);
        Assert.assertEquals(resetPasswordHash, accountDao.getHashesOfAccountByHash(hash, ResetPasswordHash.class));
    }

}
