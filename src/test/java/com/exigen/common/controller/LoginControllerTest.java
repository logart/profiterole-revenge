package com.exigen.common.controller;

import com.exigen.common.web.LoginController;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 30.01.13
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
public class LoginControllerTest {
    @Test
    public void testLogin() throws Exception {

        LoginController loginController=new LoginController();

        ModelAndView modelAndView=loginController.login();

        Assert.assertEquals("loginForm",modelAndView.getViewName());

    }
}
