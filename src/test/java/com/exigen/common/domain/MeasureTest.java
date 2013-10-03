package com.exigen.common.domain;

import org.junit.Test;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;


public class MeasureTest {
    Measure measure = new Measure();

    @Test
    public void testGetSetId() throws Exception {
        assertNull(measure.getId());
        Integer test = 2;
        measure.setId(test);
        assertEquals(test, measure.getId());

    }

    @Test
    public void testGetSetTitle() throws Exception {
        assertNull(measure.getTitle());
        String test = "г";
        measure.setTitle(test);
        assertEquals(test, measure.getTitle());
    }
}
