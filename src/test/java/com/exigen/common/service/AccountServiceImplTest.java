package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.AccountData;
import com.exigen.common.domain.Gender;
import com.exigen.common.repository.AccountDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class AccountServiceImplTest {
    @Mock
    private AccountDao accountDao;
    private Calendar calendar = new GregorianCalendar(2010, 11, 03);
    private Account account = new Account("log", "pwd", "ololo@gmailcom", Gender.Female, calendar, "Ukraine");
    private AccountServiceImpl accountService;
    private List<Account> list = new ArrayList<Account>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void FindByUsernameTest() {
        accountService = new AccountServiceImpl();
        String correctUsername = "log";
        String wrongUsername = "username";
        when(accountDao.getAccountByLogin(account.getLogin())).thenReturn(account);
        when(accountDao.getAccountByLogin(wrongUsername)).thenThrow(new EmptyResultDataAccessException(1));
        ReflectionTestUtils.setField(accountService, "accountDao", this.accountDao);
        Assert.assertEquals(account, accountService.findByUsername(correctUsername));
        Assert.assertNull(accountService.findByUsername(wrongUsername));
    }

    @Test
    public void FindByEmailTest() {
        accountService = new AccountServiceImpl();
        String correctEmail = "ololo@gmailcom";
        String wrongEmail = "o@gmailcom";
        when(accountDao.getAccountByEmail(account.getEmail())).thenReturn(account);
        when(accountDao.getAccountByEmail(wrongEmail)).thenThrow(new EmptyResultDataAccessException(1));
        ReflectionTestUtils.setField(accountService, "accountDao", this.accountDao);
        Assert.assertEquals(account, accountService.findByEmail(correctEmail));
        Assert.assertNull(accountService.findByEmail(wrongEmail));
    }

    @Test
    public void GetAllAccountsTest() {
        accountService = new AccountServiceImpl();
        list.add(account);
        when(accountDao.getAllAccounts()).thenReturn(list);
        ReflectionTestUtils.setField(accountService, "accountDao", this.accountDao);
        Assert.assertEquals(account, accountService.getAllAccounts().get(0));
    }

    @Test
    public void addAccountTest() {
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        accountService.addAccount(account);
        verify(accountDao, times(1)).addAccount(account);
    }

    @Test
    public void accountDataFromAccountTest() {
        accountService = new AccountServiceImpl();
        Assert.assertEquals(account.getLogin(), accountService.accountDataFromAccount(account).getLogin());
        account.setMaleOrFemale(null);
        account.setDateOfBirth(null);
        Assert.assertNull(accountService.accountDataFromAccount(account).getMaleOrFemale());
        Assert.assertNull(accountService.accountDataFromAccount(account).getDateOfBirth());
    }

}
