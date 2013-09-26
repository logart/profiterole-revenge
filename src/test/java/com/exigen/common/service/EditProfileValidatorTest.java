package com.exigen.common.service;

import com.exigen.common.domain.AccountData;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class EditProfileValidatorTest {
    private AccountData accountData = new AccountData();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSupports() throws Exception {
        EditProfileValidator editProfileValidator = new EditProfileValidator();
        Assert.assertEquals(true, editProfileValidator.supports(accountData.getClass()));
    }

    @Test
    public void testValidateConfirmPassword() throws Exception {

        EditProfileValidator editProfileValidator = new EditProfileValidator();
        BindingResult result = mock(BindingResult.class);
        accountData.setChangePassword("");
        accountData.setConfirmPassword("");
        editProfileValidator.validate(accountData , result );

        accountData.setConfirmPassword("1");
        editProfileValidator.validate(accountData , result );
        verify(result).rejectValue(anyString(),anyString(),anyString()) ;
    }
}
