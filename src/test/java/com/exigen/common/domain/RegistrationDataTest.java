package com.exigen.common.domain;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 15.02.13
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationDataTest {

    RegistrationData registrationData=new RegistrationData();

    @Test
    public void testGetEmail() throws Exception {
      registrationData.setEmail("user@gmail.com");
      Assert.assertEquals("user@gmail.com",registrationData.getEmail());
    }

    @Test
    public void testSetLogin() throws Exception {
       registrationData.setLogin("Login");
       Assert.assertEquals("Login",registrationData.getLogin());
    }

    @Test
    public void testSetPassword() throws Exception {
      registrationData.setPassword("passw0rd");
      Assert.assertEquals("passw0rd",registrationData.getPassword());
    }

    @Test
    public void testSetMaleOrFemale() throws Exception {
      registrationData.setMaleOrFemale("Male");
        Assert.assertEquals("Male",registrationData.getMaleOrFemale());
    }

    @Test
    public void testSetDateOfBirth() throws Exception {
      registrationData.setDateOfBirth("25.3.2011");
      Assert.assertEquals("25.3.2011", registrationData.getDateOfBirth());
    }

    @Test
    public void testSetCountry() throws Exception {
      registrationData.setCountry("country");
        Assert.assertEquals("country",registrationData.getCountry());
    }

    @Test
    public void testSetIamAgree() throws Exception {
       registrationData.setIamAgree("agree");
        Assert.assertEquals("agree",registrationData.getIamAgree());
    }
}
