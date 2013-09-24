package com.exigen.common.controller;

import com.exigen.common.domain.AccountUser;
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

    AccountUser accountUser =new AccountUser("log","pwd","ololo@gmailcom");
    List<AccountUser> list=new ArrayList<AccountUser>(){};
    @Test
    public void testAllAccounts() throws Exception {
        AllAccountsController allAccountsController=new AllAccountsController();
        AccountUser accountUser =new AccountUser("log","pwd","ololo@gmailcom");
        list.add(accountUser);
        when(accountService.getAllAccounts()).thenReturn(list);
        ReflectionTestUtils.setField(allAccountsController, "accountService", this.accountService);
        Assert.assertEquals("allAccounts",allAccountsController.allAccounts().getViewName());

    }
}
