package com.exigen.common.controller;

import com.exigen.common.web.AllOfRecipesController;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


public class AllOfRecipesControllerTest {
    @Test
    public void testAllOfRecipes() throws Exception {

        AllOfRecipesController allOfRecipesController=new AllOfRecipesController();

        ModelAndView modelAndView=allOfRecipesController.allOfRecipes();

        Assert.assertEquals("allOfRecipes",modelAndView.getViewName());

    }
}
