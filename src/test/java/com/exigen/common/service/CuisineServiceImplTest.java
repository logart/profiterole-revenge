package com.exigen.common.service;

import com.exigen.common.repository.CuisineDao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class CuisineServiceImplTest {
    @Mock
    CuisineDao cuisineDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCuisine() throws Exception {
        CuisineServiceImpl cuisineService = new CuisineServiceImpl();
        cuisineService.setCuisineDao(cuisineDao);
        when(cuisineDao.getCuisine()).thenReturn(null);
        Assert.assertNull(cuisineService.getCuisine());

    }
}