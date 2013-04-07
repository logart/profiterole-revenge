package com.exigen.common.service;

import com.exigen.common.domain.Account;
import com.exigen.common.domain.ChangeForgottenPasswordData;
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
 * author Anatolii Kondratiev
 * date 04.04.2013
 */
public class ForgotPasswordChangingValidatorTest {

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
    public void testSupports() throws Exception {
        ForgotPasswordChangingValidator passwordChangingValidator = new ForgotPasswordChangingValidator();
        Assert.assertFalse(passwordChangingValidator.supports(Object.class));
        Assert.assertTrue(passwordChangingValidator.supports(ChangeForgottenPasswordData.class));
    }

    @Test
    public void testValidate() throws Exception {
        ForgotPasswordChangingValidator passwordChangingValidator = new ForgotPasswordChangingValidator();
        BindingResult result = mock(BindingResult.class);
        ChangeForgottenPasswordData changeForgottenPasswordData = new ChangeForgottenPasswordData();
        changeForgottenPasswordData.setPassword("1234");
        changeForgottenPasswordData.setPasswordConfirm("543");
        passwordChangingValidator.validate(changeForgottenPasswordData, result);
        verify(result).rejectValue(anyString(), anyString(), anyString());
        changeForgottenPasswordData.setPassword("1234");
        changeForgottenPasswordData.setPasswordConfirm("1234");
        passwordChangingValidator.validate(changeForgottenPasswordData, result);
        verify(result).rejectValue(anyString(), anyString(), anyString());
    }
}
