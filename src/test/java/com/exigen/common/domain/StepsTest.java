package com.exigen.common.domain;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StepsTest {
    private Steps steps=new Steps();


    @Test
    public void testGetSetNameOfStep(){
       assertNull(steps.getNameOfStep());
        steps.setNameOfStep("step");
        assertEquals("step",steps.getNameOfStep());
    }

    @Test
    public void testGetSetRecipe(){
        Recipe recipe=new Recipe();
        assertNull(steps.getNameOfStep());
        steps.setRecipe(recipe);
        assertEquals(recipe, steps.getRecipe());
    }

}
