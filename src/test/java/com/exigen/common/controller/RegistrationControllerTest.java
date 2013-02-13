package com.exigen.common.controller;

import com.exigen.common.web.RegistrationController;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 30.01.13
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationControllerTest {
    @Test
    public void testRegistration() throws Exception {
        RegistrationController registrationController=new RegistrationController();
        String test=registrationController.registration(null);

        Assert.assertEquals("registration",test);

    }
}
