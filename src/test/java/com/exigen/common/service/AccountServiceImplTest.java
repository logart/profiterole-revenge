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
    @Mock
    private NotificationService notificationService;
    @Mock
    private SendMailService sendMailService;
    private Calendar calendar = new GregorianCalendar(2010, 11, 03);
    private Account  account = new Account("log", "pwd", "ololo@gmailcom", Gender.Female, calendar, "Ukraine");
    private AccountServiceImpl accountService;
    private List<Account> list = new ArrayList<Account>();
    private HashesOfAccount hashesOfAccount;

    private static final int HASH_SIZE = 32;

    public final static String ROLE_USER ="ROLE_USER";

    public final static String ROLE_INACTIVE_USER = "ROLE_INACTIVE_USER";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByUsernameTest() {
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
    public void findByEmailTest() {
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
    public void getAllAccountsTest() {
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
    public void testAddAccountByRegistrationData() throws Exception{
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        ReflectionTestUtils.setField(accountService, "notificationService", notificationService);
        ReflectionTestUtils.setField(accountService, "sendMailService", sendMailService);

        RegistrationData registrationData = new RegistrationData();
        registrationData.setDateOfBirth("01.01.2010");
        registrationData.setLogin("user");
        registrationData.setEmail("ethe@fdb.com");
        String message = "message";
        when(notificationService.createActivationMessage(anyString(),anyString())).thenReturn(message);
        when(accountDao.getAccountByLogin(anyString())).thenReturn(account);
        when(accountDao.getAccountByEmail(anyString())).thenReturn(account);

        accountService.addAccount(registrationData);

        verify(accountDao, times(1)).addAccount((Account) anyObject());
        accountService.activationHashSendMail("ethe@fdb.com");
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

    @Test
    public void resetUserPasswordServiceNullTest()throws Exception{
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", this.accountDao);
        when(accountDao.getHashesOfAccountByHash(anyString())).thenReturn(null);
        Assert.assertNull(accountDao.getHashesOfAccountByHash(anyString()));
        hashesOfAccount = new AccountPasswordReset();
        hashesOfAccount.setHash("2343535645");
        account = accountDao.getAccountByEmail("ololo@gmailcom");
        hashesOfAccount.setAccount(account);
        accountDao.addHashesOfAccount(hashesOfAccount);
        verify(accountDao, times(1)).addHashesOfAccount((HashesOfAccount) anyObject());
    }

    @Test
    public void activationOfAccountTest1(){
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        ActivationHash hashesOfAccount = new ActivationHash();
        hashesOfAccount.setAccount(account);
        String hash ="1234567";
        account.setRole(Account.ROLE_USER);
        when(accountDao.getActivationHashByHash(hash)).thenReturn(hashesOfAccount);
        accountService.activationOfAccount(hash);
        verify(accountDao, never()).updateAccount(account);
    }

    @Test
    public void activationOfAccountTest2(){
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        ActivationHash hashesOfAccount = new ActivationHash();
        hashesOfAccount.setAccount(account);
        String hash ="1234567";
        account.setRole(Account.ROLE_INACTIVE_USER);
        when(accountDao.getActivationHashByHash(hash)).thenReturn(hashesOfAccount);
        accountService.activationOfAccount(hash);
        verify(accountDao,times(1)).updateAccount(account);
    }

    @Test
    public void checkAccountPasswordResetHashTest1(){
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        AccountPasswordReset hashesOfAccount =null;
        String hash = "1234567";
        when(accountDao.getAccountPasswordResetByHash(hash)).thenReturn(hashesOfAccount);
        Assert.assertFalse(accountService.checkAccountPasswordResetHash(hash));
    }


    @Test
    public void checkAccountPasswordResetHashTest2(){
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        AccountPasswordReset hashesOfAccount =new AccountPasswordReset();
        String hash = "1234567";
        when(accountDao.getAccountPasswordResetByHash(hash)).thenReturn(hashesOfAccount);
        Assert.assertNotNull(accountService.checkAccountPasswordResetHash(hash));
    }

    @Test
    public void changeForgottenUserPasswordTest(){
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        AccountPasswordReset hashesOfAccount = new AccountPasswordReset();
        hashesOfAccount.setAccount(account);
        String hash = "1234567";
        when(accountDao.getAccountPasswordResetByHash(hash)).thenReturn(hashesOfAccount);
        accountService.changeForgottenUserPassword(hash,"1111");
        verify(accountDao,times(1)).removeHashesOfAccount(hashesOfAccount);
    }
}