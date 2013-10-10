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
    private AccountUser  accountUser = new AccountUser("log", "pwd", "ololo@gmail.com");
    private AccountServiceImpl accountService;
    private List<AccountUser> list = new ArrayList<AccountUser>();
    private ActivationHash activationHash;
    private ResetPasswordHash resetPasswordHash;

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
        when(accountDao.getAccountUserByLogin(accountUser.getLogin())).thenReturn(accountUser);
        when(accountDao.getAccountUserByLogin(wrongUsername)).thenThrow(new EmptyResultDataAccessException(1));
        ReflectionTestUtils.setField(accountService, "accountDao", this.accountDao);
        Assert.assertEquals(accountUser, accountService.findByUsername(correctUsername));
        Assert.assertNull(accountService.findByUsername(wrongUsername));
    }

    @Test
    public void findByEmailTest() {
        accountService = new AccountServiceImpl();
        String correctEmail = "ololo@gmail.com";
        String wrongEmail = "o@gmail.com";
        when(accountDao.getAccountByEmail(accountUser.getEmail())).thenReturn(accountUser);
        when(accountDao.getAccountByEmail(wrongEmail)).thenThrow(new EmptyResultDataAccessException(1));
        ReflectionTestUtils.setField(accountService, "accountDao", this.accountDao);
        Assert.assertEquals(accountUser, accountService.findByEmail(correctEmail));
        Assert.assertNull(accountService.findByEmail(wrongEmail));
    }

    @Test
    public void getAllAccountsTest() {
        accountService = new AccountServiceImpl();
        list.add(accountUser);
        when(accountDao.getAllAccounts()).thenReturn(list);
        ReflectionTestUtils.setField(accountService, "accountDao", this.accountDao);
        Assert.assertEquals(accountUser, accountService.getAllAccounts().get(0));
    }

    @Test
    public void addAccountTest() {
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        accountService.addAccount(accountUser);
        verify(accountDao, times(1)).addAccount(accountUser);
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
        when(accountDao.getAccountByLogin(anyString())).thenReturn(accountUser);
        when(accountDao.getAccountByEmail(anyString())).thenReturn(accountUser);

        accountService.addAccount(registrationData);

        verify(accountDao, times(1)).addAccount((AccountUser) anyObject());
        accountService.activationHashSendMail("ethe@fdb.com");
        }

    @Test
    public void testUpdateAccount() {
         accountService = new AccountServiceImpl();
         ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
         when(accountDao.getAccountUserByLogin(anyString())).thenReturn(accountUser);
         AccountData accountData = new AccountData();
         accountData.setDateOfBirth("01.01.2010");
         accountService.updateAccount(accountData);
         verify(accountDao, times(1)).updateAccount((AccountUser)anyObject());
         }

    @Test
    public void test2UpdateAccount() {
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        when(accountDao.getAccountUserByLogin(anyString())).thenReturn(accountUser);
        AccountData accountData = new AccountData();
        accountData.setDateOfBirth("01.01.2010");
        accountData.setChangePassword("password");
        accountData.setMaleOrFemale("Male");
        ArgumentCaptor<AccountUser> argument = ArgumentCaptor.forClass(AccountUser.class);
        accountService.updateAccount(accountData);
        verify(accountDao).updateAccount(argument.capture());
        Assert.assertEquals("password",argument.getValue().getPassword());
        Assert.assertEquals(Gender.Male,argument.getValue().getMaleOrFemale());

    }
    @Test
    public void accountDataFromAccountTest() {
        accountService = new AccountServiceImpl();
        Assert.assertEquals(accountUser.getLogin(), accountService.accountDataFromAccount(accountUser).getLogin());
        accountUser.setMaleOrFemale(null);
        accountUser.setDateOfBirth(null);
        Assert.assertNull(accountService.accountDataFromAccount(accountUser).getMaleOrFemale());
        Assert.assertNull(accountService.accountDataFromAccount(accountUser).getDateOfBirth());
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
        when(accountDao.getHashesOfAccountByHash("2343535645", ResetPasswordHash.class)).thenReturn(null);
        Assert.assertNull(accountDao.getHashesOfAccountByHash("2343535645", ResetPasswordHash.class));
        resetPasswordHash = new ResetPasswordHash();
        resetPasswordHash.setHash("2343535645");
        accountUser = accountDao.getAccountByEmail("ololo@gmailcom");
        resetPasswordHash.setAccountUser(accountUser);
        accountDao.addHashesOfAccount(resetPasswordHash);
        verify(accountDao, times(1)).addHashesOfAccount((ResetPasswordHash) anyObject());
    }

    @Test
    public void activationOfAccountTest1(){
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        activationHash = new ActivationHash();
        activationHash.setAccountUser(accountUser);
        String hash ="1234567";
        accountUser.setRole(RoleConstants.ROLE_USER);
        when(accountDao.getHashesOfAccountByHash(hash, ActivationHash.class)).thenReturn(activationHash);
        accountService.activationOfAccount(hash);
        verify(accountDao, never()).updateAccount(accountUser);
    }

    @Test
    public void activationOfAccountTest2(){
        accountService = new AccountServiceImpl();
        ReflectionTestUtils.setField(accountService, "accountDao", accountDao);
        activationHash = new ActivationHash();
        activationHash.setAccountUser(accountUser);
        String hash ="1234567";
        accountUser.setRole(RoleConstants.ROLE_INACTIVE_USER);
        when(accountDao.getHashesOfAccountByHash(hash, ActivationHash.class)).thenReturn(activationHash);
        accountService.activationOfAccount(hash);
        verify(accountDao,times(1)).updateAccount(accountUser);
    }
}
