package com.exigen.common.service;


import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AddRecipeDataValidatorTest {

    AddRecipeDataValidator addRecipeDataValidator=new AddRecipeDataValidator();

    @Test
    public void testTrimList(){
        List<String> test=new ArrayList<String>();
        test.add("test");
        Assert.assertNotNull(addRecipeDataValidator.trimList(test));
    }
}
