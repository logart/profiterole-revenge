package com.exigen.common.service;

import com.exigen.common.domain.Account;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * author Ganzha Victoria
 * date 04.04.2013
 */
public class ForgotPasswordValidatorTest {

    @Mock
    private AccountService accountService;

    @Mock
    private Account account;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testSupports() {
        ForgotPasswordValidator passwordValidator = new ForgotPasswordValidator();
        Assert.assertFalse(passwordValidator.supports(Object.class));
        Assert.assertTrue(passwordValidator.supports(String.class));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testValidateEmailNotNull() throws Exception {
        ForgotPasswordValidator passwordValidator = new ForgotPasswordValidator() ;
        BindingResult result = mock(BindingResult.class);
        String email = null;
        passwordValidator.validate(email, result);
        Assert.assertFalse(result.hasErrors());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testValidateEmailExists() throws Exception {
        ForgotPasswordValidator passwordValidator = new ForgotPasswordValidator() ;
        ReflectionTestUtils.setField(passwordValidator, "accountService", this.accountService);
        BindingResult result = mock(BindingResult.class);

        when(accountService.findByEmail(anyString())).thenReturn(new Account());
        String email = "ggg@g.com";
        passwordValidator.validate(email, result );

        when(accountService.findByEmail(anyString())).thenReturn(null);
        passwordValidator.validate(email, result );

        verify(result).reject(anyString(), anyString()) ;
    }
}
