package com.exigen.common.controller;

import junit.framework.Assert;
import org.junit.Test;
import com.exigen.common.web.ProfileController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Victoria Ganzha
 * Date: 21.03.13
 * Using for testing Profile Controller
 */
public class ProfileControllerTest {
    @Test
    public void viewProfileController(){
        ProfileController profile = new  ProfileController();
        Map model = new HashMap<String,String>();
        Assert.assertEquals("redirect:", profile.viewProfile(model));
    }



}
