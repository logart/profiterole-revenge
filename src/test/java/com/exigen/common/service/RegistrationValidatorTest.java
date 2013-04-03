package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.RegistrationData;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;

import javax.swing.*;

import java.util.Collection;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class RegistrationValidatorTest {
    @Mock
    private AccountService accountService ;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    private  RegistrationData registrationData = new RegistrationData() ;

    @Test
    public void testSupports() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        Assert.assertEquals(true, registrationValidator.supports(registrationData.getClass()));
    }

    @Test
    public void testValidateUserExists() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        ReflectionTestUtils.setField(registrationValidator, "accountService", this.accountService);
        BindingResult result = mock(BindingResult.class);
        when(accountService.findByUsername(anyString())).thenReturn(new Account());

        RegistrationData registrationData = new RegistrationData() ;
        registrationValidator.validate(registrationData , result );

        when(accountService.findByUsername(anyString())).thenReturn(null);
        registrationValidator.validate(registrationData , result );

        verify(result).rejectValue(anyString(),anyString(),anyString()) ;
    }

    @Test
    public void testValidateEmailExists() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        ReflectionTestUtils.setField(registrationValidator, "accountService", this.accountService);
        BindingResult result = mock(BindingResult.class);

        when(accountService.findByEmail(anyString())).thenReturn(new Account());
        RegistrationData registrationData = new RegistrationData() ;
        registrationValidator.validate(registrationData , result );

        when(accountService.findByEmail(anyString())).thenReturn(null);
        registrationValidator.validate(registrationData , result );

        verify(result).rejectValue(anyString(),anyString(),anyString()) ;
    }

}
