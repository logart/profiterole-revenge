package com.exigen.common.domain;

import org.junit.Test;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;


public class MeasuresBucketTest {
    MeasuresBucket measuresBucket = new MeasuresBucket();

    @Test
    public void testGetSetId() throws Exception {
        assertNull(measuresBucket.getId());
        Integer test = 2;
        measuresBucket.setId(test);
        assertEquals(test, measuresBucket.getId());
    }

    @Test
    public void testGetSetMeasure() throws Exception {
        Measure measure = new Measure();
        assertNull(measuresBucket.getMeasure());
        measuresBucket.setMeasure(measure);
        assertEquals(measure, measuresBucket.getMeasure());
    }

    @Test
    public void testGetSetIngredient() throws Exception {
        Ingredient ingredient = new Ingredient();
        assertNull(measuresBucket.getIngredient());
        measuresBucket.setIngredient(ingredient);
        assertEquals(ingredient, measuresBucket.getIngredient());
    }

    @Test
    public void testGetSetGramEquals() throws Exception {
        assertNull(measuresBucket.getGramEquals());
        Integer test = 1;
        measuresBucket.setGramEquals(test);
        assertEquals(test, measuresBucket.getGramEquals());
    }
}
