package com.exigen.common.controller;

import com.exigen.common.web.MenuPageController;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 30.01.13
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class MenuPageControllerTest {
    @Test
    public void testMenuPage() throws Exception {

        MenuPageController menuPageController=new MenuPageController();

        String test=menuPageController.menuPage();

        Assert.assertEquals("Menu",test);


    }
}
