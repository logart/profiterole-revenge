package com.exigen.common.controller;


import com.exigen.common.web.RulesController;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

/**
 *  Class  {@code RulesControllerTest} creates test for RulesController
 * @author Elena
 * Date: 04.02.13
 *
 */
public class RulesControllerTest {
    /**
     * {@method testRules()} using for testing RulesController.rules()
     */

    @Test
    public void testRules() throws Exception {
        RulesController rulesController=new RulesController();

        ModelAndView modelAndView= rulesController.rules();

        Assert.assertEquals("rules", modelAndView.getViewName());
    }
}
