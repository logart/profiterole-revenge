package com.exigen.common.controller;

import com.exigen.common.web.HelloController;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


public class HelloControllerTest {


    @Test
    public void testIndex() throws Exception {
        HelloController helloController=new HelloController();

        ModelAndView modelAndView=helloController.index();

        Assert.assertEquals("MainPage",modelAndView.getViewName());
    }
}
