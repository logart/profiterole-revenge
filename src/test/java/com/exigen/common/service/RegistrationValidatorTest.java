package com.exigen.common.service;

import com.exigen.common.domain.AccountUser;
import com.exigen.common.domain.RegistrationData;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class RegistrationValidatorTest {
    @Mock
    private AccountService accountService ;

    private  RegistrationData registrationData = new RegistrationData() ;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSupports() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        Assert.assertEquals(true, registrationValidator.supports(registrationData.getClass()));
    }

    @Test
    public void test1ValidateUserExists() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        ReflectionTestUtils.setField(registrationValidator, "accountService", this.accountService);
        BindingResult result = mock(BindingResult.class);
        when(accountService.findByUsername(anyString())).thenReturn(new AccountUser(registrationData.getLogin(),registrationData.getPassword(),registrationData.getEmail()));

        RegistrationData registrationData = new RegistrationData() ;
        registrationData.setPassword("");
        registrationData.setConfirmPassword("");
        registrationValidator.validate(registrationData , result );

        verify(result).rejectValue(anyString(),anyString(),anyString()) ;
    }

    @Test
    public void test2ValidateUserExists() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        ReflectionTestUtils.setField(registrationValidator, "accountService", this.accountService);
        BindingResult result = mock(BindingResult.class);
        RegistrationData registrationData = new RegistrationData() ;
        registrationData.setPassword("");
        registrationData.setConfirmPassword("");
        when(accountService.findByUsername(anyString())).thenReturn(null);
        registrationValidator.validate(registrationData , result );

        verify(result,never()).rejectValue(anyString(),anyString(),anyString()) ;
    }

    @Test
    public void test1ValidateEmailExists() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        ReflectionTestUtils.setField(registrationValidator, "accountService", this.accountService);
        BindingResult result = mock(BindingResult.class);
        when(accountService.findByEmail(anyString())).thenReturn(new AccountUser(registrationData.getLogin(),registrationData.getPassword(),registrationData.getEmail()));
        RegistrationData registrationData = new RegistrationData() ;
        registrationData.setPassword("");
        registrationData.setConfirmPassword("");
        registrationValidator.validate(registrationData , result );
        verify(result,times(1)).rejectValue(anyString(),anyString(),anyString()) ;
    }

    @Test
    public void test2ValidateEmailExists() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        ReflectionTestUtils.setField(registrationValidator, "accountService", this.accountService);
        BindingResult result = mock(BindingResult.class);
        RegistrationData registrationData = new RegistrationData() ;
        registrationData.setPassword("");
        registrationData.setConfirmPassword("");
        when(accountService.findByEmail(anyString())).thenReturn(null);
        registrationValidator.validate(registrationData , result );
        verify(result,never()).rejectValue(anyString(),anyString(),anyString()) ;
    }

    @Test
    public void test1ValidateConfirmPassword() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        ReflectionTestUtils.setField(registrationValidator, "accountService", this.accountService);
        BindingResult result = mock(BindingResult.class);
        RegistrationData registrationData = new RegistrationData() ;
        registrationData.setPassword("");
        registrationData.setConfirmPassword("");
        registrationValidator.validate(registrationData , result );
        verify(result,never()).rejectValue(anyString(),anyString(),anyString()) ;
    }

    @Test
    public void test2ValidateConfirmPassword() throws Exception {
        RegistrationValidator registrationValidator = new RegistrationValidator() ;
        ReflectionTestUtils.setField(registrationValidator, "accountService", this.accountService);
        BindingResult result = mock(BindingResult.class);
        RegistrationData registrationData = new RegistrationData() ;
        registrationData.setPassword("");
        registrationData.setConfirmPassword("1");
        registrationValidator.validate(registrationData , result );
        verify(result,times(1)).rejectValue(anyString(),anyString(),anyString()) ;
    }
}
