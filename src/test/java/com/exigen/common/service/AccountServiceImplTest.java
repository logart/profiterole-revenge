package com.exigen.common.service;

import com.exigen.common.domain.*;
import com.exigen.common.repository.AccountDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.mockito.Mockito.*;



public class AccountServiceImplTest {
    @Mock
    private AccountDao accountDao;
    private Calendar calendar = new GregorianCalendar(2010, 11, 03);
    private Account  account = new Account("log", "pwd", "ololo@gmailcom", Gender.Female, calendar, "Ukraine");
    private AccountServiceImpl accountService;
    private List<Account> list = new ArrayList<Account>();
    private AccountPasswordReset accountPasswordReset;

    private static final int HASH_SIZE = 32;

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
    public void testAddAccountByRegistrationData() {
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        RegistrationData registrationData = new RegistrationData();
        registrationData.setDateOfBirth("01.01.2010");
        accountService.addAccount(registrationData);
        verify(accountDao, times(1)).addAccount((Account) anyObject());
        }

    @Test
    public void testUpdateAccount() {
         accountService = new AccountServiceImpl();
         ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
         when(accountDao.getAccountByLogin(anyString())).thenReturn(account);
         AccountData accountData = new AccountData();
         accountData.setDateOfBirth("01.01.2010");
         accountService.updateAccount(accountData);
         verify(accountDao, times(1)).updateAccount((Account)anyObject());
         }

    @Test
    public void test2UpdateAccount() {
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        when(accountDao.getAccountByLogin(anyString())).thenReturn(account);
        AccountData accountData = new AccountData();
        accountData.setDateOfBirth("01.01.2010");
        accountData.setChangePassword("password");
        accountData.setMaleOrFemale("Male");
        ArgumentCaptor<Account> argument = ArgumentCaptor.forClass(Account.class);
        accountService.updateAccount(accountData);
        verify(accountDao).updateAccount(argument.capture());
        Assert.assertEquals("password",argument.getValue().getPassword());
        Assert.assertEquals(Gender.Male,argument.getValue().getMaleOrFemale());

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

   @Test
    public void generateHashTest(){
        accountService = new AccountServiceImpl();
        Assert.assertTrue(accountService.generateHash(AccountServiceImpl.HASH_SIZE).length() >= AccountServiceImpl.HASH_SIZE);
   }


    @Test (expected = ServiceException.class)
    public void resetUserPasswordServiceExceptionTest()throws ServiceException{
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", this.accountDao);
        when(accountDao.getAccountPasswordResetByHash(anyString())).thenReturn(new AccountPasswordReset());
        accountService.resetUserPassword("");

    }

    @Test
    public void resetUserPasswordServiceNullTest()throws Exception{
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", this.accountDao);
        when(accountDao.getAccountPasswordResetByHash(anyString())).thenReturn(null);
        Assert.assertNull(accountDao.getAccountPasswordResetByHash(anyString()));
        accountPasswordReset = new AccountPasswordReset();
        accountPasswordReset.setHash("2343535645");
        account = accountDao.getAccountByEmail("ololo@gmailcom");
        accountPasswordReset.setAccount(account);
        accountDao.addAccountPasswordReset(accountPasswordReset);
        verify(accountDao, times(1)).addAccountPasswordReset((AccountPasswordReset)anyObject());
    }


}
