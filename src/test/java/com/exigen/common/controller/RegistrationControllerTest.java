package com.exigen.common.controller;

import com.exigen.common.domain.RegistrationData;
import com.exigen.common.service.AccountService;
import com.exigen.common.service.RegistrationValidator;
import com.exigen.common.web.RegistrationController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;

import java.util.Map;
import java.util.TreeMap;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 30.01.13
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationControllerTest {
    @Mock
    private AccountService accountService ;

    @Mock
    private RegistrationValidator  registrationValidator  ;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegistration() throws Exception {
        Map map=new TreeMap();
        RegistrationController registrationController=new RegistrationController();
        String test=registrationController.registration(map);

        Assert.assertEquals("registration",test);

    }

    @Test
    public void testProcessAddingUserValidatedOk(){
        RegistrationController profile = new  RegistrationController();
        ReflectionTestUtils.setField(profile, "accountService", this.accountService);
        ReflectionTestUtils.setField(profile, "registrationValidator", this.registrationValidator);

        Map model = new TreeMap();
        RegistrationData registrationData = new RegistrationData() ;
        registrationData.setLogin("test");
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);
        when(registrationValidator.supports(registrationData.getClass())).thenReturn(true);

        Assert.assertEquals("redirect:registrationSuccess?user=test", profile.processAddingUser(model, registrationData, result));
        verify(this.accountService).addAccount((RegistrationData) anyObject());
    }

    @Test
    public void testProcessEditingProfileValidatedNotOk(){
        RegistrationController profile = new  RegistrationController();
        ReflectionTestUtils.setField(profile, "accountService", this.accountService);
        ReflectionTestUtils.setField(profile, "registrationValidator", this.registrationValidator);

        Map model = new TreeMap();
        RegistrationData registrationData= new RegistrationData() ;
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);
        when(registrationValidator.supports(registrationData.getClass())).thenReturn(true);

        Assert.assertNotNull(profile.processAddingUser(model, registrationData, result));
        Assert.assertEquals("registration", profile.processAddingUser(model, registrationData, result));

    }
}
