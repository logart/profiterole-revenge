package com.exigen.common.controller;

import com.exigen.common.web.AboutController;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class  {@code AboutControllerTest} creates test for AboutController
 * @author Elena
 *
 * Date: 04.02.13
 *
 */
public class AboutControllerTest {

    /**
     * {@method testAbout()} using for testing AboutController.about()
     */

    @Test
    public void testAbout() throws Exception {
        AboutController aboutController=new AboutController();

        ModelAndView modelAndView= aboutController.about();

        Assert.assertEquals("about", modelAndView.getViewName());
    }
}

