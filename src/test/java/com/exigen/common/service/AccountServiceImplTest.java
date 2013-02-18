package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.Gender;
import com.exigen.common.repository.AccountDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.mockito.Mockito.when;


public class AccountServiceImplTest {
    @Mock
    private AccountDao accountDao;

    Calendar calendar=new GregorianCalendar(2010, 11, 03);

    Account account=new Account("log","pwd","ololo@gmailcom", Gender.Female,calendar);

    AccountServiceImpl accountService;
    List<Account> list=new ArrayList<Account>();
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByUsername() throws Exception {
       accountService=new AccountServiceImpl();
        String username="user";
      when(accountDao.getAccountByLogin(username)).thenReturn(account);
        ReflectionTestUtils.setField(accountService,"accountDao",this.accountDao);
        Assert.assertEquals(account,accountService.findByUsername(username));

    }

    @Test
    public void testGetAllAccounts() throws Exception {
        accountService=new AccountServiceImpl();
        list.add(account);
        when(accountDao.getAllAccounts()).thenReturn(list);
        ReflectionTestUtils.setField(accountService,"accountDao",this.accountDao);
        Assert.assertEquals(account,accountService.getAllAccounts().get(0));
    }
}
