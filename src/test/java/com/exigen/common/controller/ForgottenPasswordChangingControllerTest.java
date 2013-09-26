package com.exigen.common.controller;

import com.exigen.common.domain.ChangeForgottenPasswordData;
import com.exigen.common.service.AccountService;
import com.exigen.common.service.ForgotPasswordChangingValidator;
import com.exigen.common.web.ForgottenPasswordChangingController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;

import java.util.Map;
import java.util.TreeMap;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: A. Kondratiev
 * Date: 22.03.13
 * Using for testing ForgottenPasswordChangingController
 */
public class ForgottenPasswordChangingControllerTest {
    @Mock
    private AccountService accountService;

    @Mock
    private ForgotPasswordChangingValidator forgotPasswordChangingValidator;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testProcessEditingProfileValidatedOk() {
        ForgottenPasswordChangingController controller = new ForgottenPasswordChangingController();
        ReflectionTestUtils.setField(controller, "accountService", this.accountService);
        ReflectionTestUtils.setField(controller, "forgotPasswordChangingValidator", this.forgotPasswordChangingValidator);

        Map model = new TreeMap();
        ChangeForgottenPasswordData passwordData = new ChangeForgottenPasswordData();
        when(forgotPasswordChangingValidator.supports(passwordData.getClass())).thenReturn(true);

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        Assert.assertEquals("redirect:changeForgottenPassword/success", controller.processEditingProfile(model, passwordData, result));
        verify(this.accountService).changeForgottenUserPassword(anyString(), anyString());
    }

    @Test
    public void testProcessEditingProfileValidatedOkButAccountServiceException() {
        ForgottenPasswordChangingController controller = new ForgottenPasswordChangingController();
        ReflectionTestUtils.setField(controller, "accountService", this.accountService);
        ReflectionTestUtils.setField(controller, "forgotPasswordChangingValidator", this.forgotPasswordChangingValidator);

        doThrow(new RuntimeException()).when(accountService).changeForgottenUserPassword(anyString(), anyString());


        Map model = new TreeMap();
        ChangeForgottenPasswordData passwordData = new ChangeForgottenPasswordData();
        when(forgotPasswordChangingValidator.supports(passwordData.getClass())).thenReturn(true);

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        Assert.assertEquals("redirect:changeForgottenPassword/fail", controller.processEditingProfile(model, passwordData, result));
    }

    @Test
    public void testProcessEditingProfileValidatedNotOk() {
        ForgottenPasswordChangingController controller = new ForgottenPasswordChangingController();
        ReflectionTestUtils.setField(controller, "accountService", this.accountService);
        ReflectionTestUtils.setField(controller, "forgotPasswordChangingValidator", this.forgotPasswordChangingValidator);

        Map model = new TreeMap();
        ChangeForgottenPasswordData passwordData = new ChangeForgottenPasswordData();
        when(forgotPasswordChangingValidator.supports(passwordData.getClass())).thenReturn(true);

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        Assert.assertEquals("changeForgottenPassword", controller.processEditingProfile(model, passwordData, result));
        verify(this.accountService, never()).changeForgottenUserPassword(anyString(), anyString());
    }

    @Test
    public void testChangeForgottenPasswordSuccess (){
        ForgottenPasswordChangingController controller = new ForgottenPasswordChangingController();
        Map model = new TreeMap();
        Assert.assertEquals("changeForgottenPasswordSuccess", controller.changeForgottenPasswordSuccess(model));
    }

    @Test
    public void testChangeForgottenPasswordFail (){
        ForgottenPasswordChangingController controller = new ForgottenPasswordChangingController();
        Map model = new TreeMap();
        Assert.assertEquals("changeForgottenPasswordFail", controller.changeForgottenPasswordFail(model));
    }
}
