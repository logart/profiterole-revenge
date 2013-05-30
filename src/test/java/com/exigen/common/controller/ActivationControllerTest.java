package com.exigen.common.controller;

import com.exigen.common.domain.Account;
import com.exigen.common.service.AccountService;
import com.exigen.common.service.CustomUserDetailsService;
import com.exigen.common.web.ActivationController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Map;
import java.util.TreeMap;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: lena
 * Date: 29.05.13
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
public class ActivationControllerTest {
    @Mock
    private AccountService accountService;
    @Mock
    private CustomUserDetailsService customUserDetailsService;
    private  ActivationController activationController;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkHashAndActivateTest1(){
        activationController = new ActivationController();
        ReflectionTestUtils.setField(activationController,"accountService", accountService);
        ReflectionTestUtils.setField(activationController,"customUserDetailsService",customUserDetailsService);
        Account account = new Account();
        Map model = new TreeMap();
        String hash = "";
        when(accountService.activationOfAccount(hash)).thenReturn(account);
        activationController.checkHashAndActivate(model,hash);
        verify(customUserDetailsService, times(1)).login(anyString(), anyString());
        Assert.assertEquals(activationController.checkHashAndActivate(model, hash), "redirect:activation/success?user=" + account.getLogin());

    }

    @Test
    public void checkHashAndActivateTest2(){
        activationController = new ActivationController();
        ReflectionTestUtils.setField(activationController,"accountService", accountService);
        ReflectionTestUtils.setField(activationController,"customUserDetailsService",customUserDetailsService);
        Account account = new Account();
        Map model = new TreeMap();
        String hash = "12345";
        when(accountService.activationOfAccount(hash)).thenThrow();
        Assert.assertEquals(activationController.checkHashAndActivate(model, hash), "redirect:activation/fail");
    }

    @Test
    public void activationSuccessTest(){
        activationController = new ActivationController();
        Map model = new TreeMap();
        String user ="user";
        Assert.assertEquals(activationController.activationSuccess(model, user), "activationSuccess");
    }

    @Test
    public void activationFailTest(){
        activationController = new ActivationController();
        Map model = new TreeMap();
        Assert.assertEquals(activationController.activationFail(model), "activationFail");
    }
}