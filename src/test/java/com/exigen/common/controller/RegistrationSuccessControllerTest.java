package com.exigen.common.controller;

import com.exigen.common.domain.AccountUser;
import com.exigen.common.service.AccountService;
import com.exigen.common.web.RegistrationSuccessController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

import static org.mockito.Mockito.when;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 18.02.13
 * Time: 1:45
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationSuccessControllerTest {
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
         public void testRegistrationSuccess() throws Exception {
        RegistrationSuccessController registrationSuccessController=new RegistrationSuccessController();
        when(accountService.findByUsername("user")).thenReturn(accountUser);
        ReflectionTestUtils.setField(registrationSuccessController, "accountService", this.accountService);
        Map map=new TreeMap();
        String u="user";
        Assert.assertNotNull(registrationSuccessController.registrationSuccess(map,u));
    }

    @Test
    public void testRegistrationSuccessAccountNull() throws Exception {
        RegistrationSuccessController registrationSuccessController=new RegistrationSuccessController();
        when(accountService.findByUsername("user")).thenReturn(null);
        ReflectionTestUtils.setField(registrationSuccessController, "accountService", this.accountService);
        Map map=new TreeMap();
        String u="user";
        Assert.assertEquals("redirect:", registrationSuccessController.registrationSuccess(map,u));
    }
}
