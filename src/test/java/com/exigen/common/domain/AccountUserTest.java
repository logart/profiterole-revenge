package com.exigen.common.domain;


import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class AccountUserTest {
    private AccountUser accountUser =new AccountUser("log", "psw","profiterole@gmail.com");

    @Test
    public void getSetId(){
        assertNull(accountUser.getId());
        Integer test = 1;
        accountUser.setId(test);
        assertEquals(test, accountUser.getId());
    }

    @Test
    public void getSetLogin(){
        assertEquals("log", accountUser.getLogin());
    }

    @Test
    public void getSetDateOfBirth(){

        Calendar calendar=new GregorianCalendar(2012,12,21);
        assertNull(accountUser.getDateOfBirth());
        accountUser.setDateOfBirth(calendar);
        assertEquals(calendar, accountUser.getDateOfBirth());

    }

    @Test
    public void getSetPasswd(){
        assertEquals("psw", accountUser.getPassword());

    }

    @Test
    public void getSetEmail(){
        assertEquals("profiterole@gmail.com", accountUser.getEmail());
    }

    @Test
    public void getSetGender(){
        assertNull(accountUser.getMaleOrFemale());
        accountUser.setMaleOrFemale(Gender.Female);
        assertEquals(Gender.Female, accountUser.getMaleOrFemale());
    }

    @Test
    public void getSetCountry(){
        assertNull(accountUser.getCountry());
        accountUser.setCountry("Болгария");
        assertEquals("Болгария", accountUser.getCountry());
    }

    @Test
    public void getSetRole(){
        assertEquals("ROLE_INACTIVE_USER", accountUser.getRole());
    }
}
