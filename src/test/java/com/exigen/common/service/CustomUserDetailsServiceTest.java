package com.exigen.common.service;

import com.exigen.common.domain.AccountUser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 18.02.13
 * Time: 2:14
 * To change this template use File | Settings | File Templates.
 */
public class CustomUserDetailsServiceTest {
    @Mock
    private AccountServiceImpl accountService;
    
    Calendar calendar=new GregorianCalendar(2010, 11, 03);
    
    AccountUser accountUser =new AccountUser("log","pwd","ololo@gmailcom");

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testLoadUserByUsername() throws Exception {
//        CustomUserDetailsService customUserDetailsService=new CustomUserDetailsService();
//        when(accountService.findByUsername("log")).thenReturn(accountUser);
//        ReflectionTestUtils.setField(customUserDetailsService, "accountService", this.accountService);
//        Assert.assertNotNull(customUserDetailsService.loadUserByUsername("log"));
//
    }
}
