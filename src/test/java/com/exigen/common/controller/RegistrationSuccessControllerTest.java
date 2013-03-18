package com.exigen.common.controller;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.Gender;
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

    Account account=new Account("log","pwd","ololo@gmailcom", Gender.Female,calendar, "Ukraine");

    List<Account> list=new ArrayList<Account>(){};
    @Test
    public void testRegistrationSuccess() throws Exception {
     RegistrationSuccessController registrationSuccessController=new RegistrationSuccessController();
        when(accountService.findByUsername("user")).thenReturn(account);
        ReflectionTestUtils.setField(registrationSuccessController, "accountService", this.accountService);
        Map map=new TreeMap();
        String u="user";
        Assert.assertNotNull(registrationSuccessController.registrationSuccess(map,u));
        }
}
