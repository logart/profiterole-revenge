package com.exigen.common.domain;

import junit.framework.Assert;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;


public class AccountPasswordResetTest {
     AccountPasswordReset accountPasswordReset = new AccountPasswordReset();


    @Test
    public void getSetHash(){
        assertNull(accountPasswordReset.getHash());
        accountPasswordReset.setHash("2345535245");
        assertEquals("2345535245",accountPasswordReset.getHash());
    }

    @Test
    public void getSetAccount(){
        assertNull(accountPasswordReset.getAccount());
        Account account = new Account();
        accountPasswordReset.setAccount(account);
        assertEquals(account, accountPasswordReset.getAccount());
    }

    @Test
    public  void  getSetId(){
        assertNull(accountPasswordReset.getId());
        Integer test = 1;
        accountPasswordReset.setId(test);
        Assert.assertEquals(test,accountPasswordReset.getId());
    }
}
