package com.exigen.common.domain;


import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class AccountTest {
    private Account account=new Account();;

    @Test
    public void getSetLogin(){


        assertNull(account.getLogin());
        account.setLogin("login");
        assertEquals("login", account.getLogin());
    }

    @Test
    public void getSetDateOfBirth(){

        Calendar calendar=new GregorianCalendar(2012,12,21);
        assertNull(account.getDateOfBirth());
        account.setDateOfBirth(calendar);
        assertEquals(calendar,account.getDateOfBirth());

    }

    @Test
    public void getSetPasswd(){
        assertNull(account.getPassword());
        account.setPassword("qwerty");
        assertEquals("qwerty",account.getPassword());

    }

    @Test
    public void getSetEmail(){
        assertNull(account.getEmail());
        account.setEmail("vasya-pupkin@gmail.com");
        assertEquals("vasya-pupkin@gmail.com",account.getEmail());
    }

    @Test
    public void getSetGender(){
        assertNull(account.getMaleOrFemale());
        account.setMaleOrFemale(Gender.Female);
        assertEquals(Gender.Female,account.getMaleOrFemale());
    }
}
