package com.exigen.common.controller;

import com.exigen.common.web.SuccessController;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


public class SuccessControllerTest {
    
    @Test
    public void testShowSuccess() throws Exception {

        SuccessController successController=new SuccessController();

        String test=successController.showSuccess();

        Assert.assertEquals("successAddedRecipe",test);
    }
}
