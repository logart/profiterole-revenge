package com.exigen.common.domain;

import junit.framework.Assert;
import org.junit.Test;

public class CuisineTest {
    Cuisine cuisine;

    @Test
    public void testGetSetId() throws Exception {
        cuisine = new Cuisine();
        Assert.assertNull(cuisine.getCuisineId());
        Integer test = 2;
        cuisine.setCuisineId(test);
        Assert.assertEquals(test, cuisine.getCuisineId());
    }

    @Test
    public void testGetSetCusine() throws Exception {
        cuisine = new Cuisine();
        Assert.assertNull(cuisine.getCuisin());
        String cuis = "Cuisine";
        cuisine.setCuisin(cuis);
        Assert.assertEquals(cuis, cuisine.getCuisin());
    }

}
