package com.exigen.common.service;

import com.exigen.common.domain.Account;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;

import java.util.Collection;

import static org.mockito.Mockito.when;


public class RegistrationValidatorTest {

    @Mock
    RegistrationValidator registrationValidator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    Account account=new Account();





    @Test
    public void testSupports() throws Exception {

     when(registrationValidator.supports(account.getClass())).thenReturn(true);
        Assert.assertEquals(true,registrationValidator.supports(account.getClass()));
    }
}
