package com.exigen.common.domain;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;


public class AccountPasswordResetTest {

     ResetPasswordHash resetPasswordHash = new ResetPasswordHash();


    @Test
    public void getSetHash(){
        assertNull(resetPasswordHash.getHash());
        resetPasswordHash.setHash("2345535245");
        assertEquals("2345535245", resetPasswordHash.getHash());
    }

    @Test
    public void getSetAccount(){
        assertNull(resetPasswordHash.getAccount());
        Account account = new Account();
        resetPasswordHash.setAccount(account);
        assertEquals(account, resetPasswordHash.getAccount());
    }

}
