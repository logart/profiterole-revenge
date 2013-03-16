package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.Gender;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.ReflectPermission;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.when;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 18.02.13
 * Time: 2:14
 * To change this template use File | Settings | File Templates.
 */
public class CustomUserDetailsServiceTest {
    @Mock
    private AccountService accountService;
    
    Calendar calendar=new GregorianCalendar(2010, 11, 03);
    
    Account account=new Account("log","pwd","ololo@gmailcom", Gender.Female,calendar);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testLoadUserByUsername() throws Exception {
        CustomUserDetailsService customUserDetailsService=new CustomUserDetailsService();
    when(accountService.findByUsername("log")).thenReturn(account);
        ReflectionTestUtils.setField(customUserDetailsService, "accountService", this.accountService);
        Assert.assertNotNull(customUserDetailsService.loadUserByUsername("log"));

    }
}
