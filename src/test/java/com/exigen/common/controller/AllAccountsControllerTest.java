package com.exigen.common.controller;

import com.exigen.common.web.AllAccountsController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;


public class AllAccountsControllerTest {
    @Mock
    AllAccountsController allAccountsController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAllAccounts() throws Exception {
     when(allAccountsController.allAccounts()).thenReturn(null);
        Assert.assertNull(allAccountsController.allAccounts());
    }
}
