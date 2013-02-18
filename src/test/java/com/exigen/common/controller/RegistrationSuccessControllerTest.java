package com.exigen.common.controller;

import com.exigen.common.web.RegistrationSuccessController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;
import java.util.TreeMap;

import static org.mockito.Mockito.when;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 18.02.13
 * Time: 1:45
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationSuccessControllerTest {
    @Mock
    RegistrationSuccessController registrationSuccessController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegistrationSuccess() throws Exception {
        Map map=new TreeMap();
     when(registrationSuccessController.registrationSuccess(map,new String("user"))).thenReturn(null);
        Assert.assertNull(registrationSuccessController.registrationSuccess(map,new String("user")));
    }
}
