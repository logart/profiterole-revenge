package com.exigen.common.domain;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;


public class CategoriesTest {
    private Categories categories;

    @Test
    public void testGetSetCateg() throws Exception {
        categories = new Categories();

        String testCat = "category";
        assertNull(categories.getCateg());
        categories.setCateg(testCat);
        assertEquals(testCat, categories.getCateg());

    }

    @Test
    public void testGetSetId() throws Exception {
        categories = new Categories();
        assertNull(categories.getCategoriesId());
        categories.getCategoriesId();
        Integer test = 1;
        categories.setCategoriesId(test);
        assertEquals(test, categories.getCategoriesId());

    }
}


