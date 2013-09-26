package com.exigen.common.controller;

import com.exigen.common.service.AccountService;
import com.exigen.common.service.ForgotPasswordValidator;
import com.exigen.common.service.NotificationException;
import com.exigen.common.web.ForgotPasswordController;
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
 * author Ganzha Victoria
 * date 04.04.2013
 */
public class ForgotPasswordControllerTest {

    @Mock
    private AccountService accountService;

    @Mock
    private ForgotPasswordValidator forgotPasswordValidator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testForgotPassword() throws Exception {
        Map map = new TreeMap();
        ForgotPasswordController forgotPasswordController = new ForgotPasswordController();
        String email = forgotPasswordController.forgotPassword(map);
        Assert.assertEquals("forgotPassword", email);

    }

    @Test
    public void testForgotPasswordValidatedOk(){
        ForgotPasswordController forgotPasswordController = new ForgotPasswordController();
        ReflectionTestUtils.setField(forgotPasswordController, "accountService", this.accountService);
        ReflectionTestUtils.setField(forgotPasswordController, "forgotPasswordValidator", this.forgotPasswordValidator);

        Map model = new TreeMap();
        String email = "ggg@g.com";
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);
        when(forgotPasswordValidator.supports(String.class)).thenReturn(true);

        Assert.assertEquals("successSendMail", forgotPasswordController.forgotPassword(model, email, result));
    }

    @Test
    public void testForgotPasswordException(){
        ForgotPasswordController forgotPasswordController = new ForgotPasswordController();
        ReflectionTestUtils.setField(forgotPasswordController, "accountService", this.accountService);
        ReflectionTestUtils.setField(forgotPasswordController, "forgotPasswordValidator", this.forgotPasswordValidator);
        Map model = new TreeMap();
        String email = "ggg@g.com";
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);
        when(forgotPasswordValidator.supports(String.class)).thenReturn(true);

        try {
            doThrow(new NotificationException()).when(this.accountService).resetPasswordHashSendMail(anyString());
            Assert.assertEquals("redirect:/login", forgotPasswordController.forgotPassword(model, email, result));
        } catch (NotificationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testForgotPasswordValidatedNotOk(){
        ForgotPasswordController forgotPasswordController = new ForgotPasswordController();
        ReflectionTestUtils.setField(forgotPasswordController, "accountService", this.accountService);
        ReflectionTestUtils.setField(forgotPasswordController, "forgotPasswordValidator", this.forgotPasswordValidator);

        Map model = new TreeMap();
        String email = "ggg@g.com";
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);
        when(forgotPasswordValidator.supports(String.class)).thenReturn(true);

        Assert.assertNotNull(forgotPasswordController.forgotPassword(model, email, result));
        Assert.assertEquals("forgotPassword", forgotPasswordController.forgotPassword(model, email, result));

    }


}





