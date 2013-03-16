package com.exigen.common.controller;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.Gender;
import com.exigen.common.service.AccountService;
import com.exigen.common.web.AllAccountsController;
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


public class AllAccountsControllerTest {
    @Mock
    private AccountService accountService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    Calendar calendar=new GregorianCalendar(2010, 11, 03);

    Account account=new Account("log","pwd","ololo@gmailcom", Gender.Female,calendar);
    List<Account> list=new ArrayList<Account>(){};
    @Test
    public void testAllAccounts() throws Exception {
        AllAccountsController allAccountsController=new AllAccountsController();
        Account account=new Account();
        list.add(account);
        when(accountService.getAllAccounts()).thenReturn(list);
        ReflectionTestUtils.setField(allAccountsController, "accountService", this.accountService);
        Assert.assertEquals("allAccounts",allAccountsController.allAccounts().getViewName());

    }
}
