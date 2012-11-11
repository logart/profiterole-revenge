package com.exigen.common.domain;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StepsTest {
    private Steps steps=new Steps();


    @Test
    public void testGetSetNameOfStep(){
       assertNull(steps.getStepDescription());
        steps.setStepDescription("step");
        assertEquals("step",steps.getStepDescription());
    }

    @Test
    public void testGetSetRecipe(){
        Recipe recipe=new Recipe();
        assertNull(steps.getRecipe());
        steps.setRecipe(recipe);
        assertEquals(recipe, steps.getRecipe());
    }

    @Test
    public void testGetSetStepNumber(){
        assertEquals(null,steps.getStepNumber());
        Integer n=12;
        steps.setStepNumber(n);
        assertEquals(n,steps.getStepNumber());
    }

    @Test
    public void testGetSetStepImg(){
        assertNull(steps.getStepImg());
        steps.setStepImg("/img/ukr.jpg");
        assertEquals("/img/ukr.jpg", steps.getStepImg());
    }

}
