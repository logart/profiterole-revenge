package com.exigen.common.service;


import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.IngridientDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.when;

public class IngridientServiceImplTest {

    IngridientServiceImpl ingridient = new IngridientServiceImpl();

    Recipe recipe = new Recipe();

    @Mock
    private IngridientDao ingridientDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getIngridientService() {
        ingridient.setIngridientDao(ingridientDao);
        when(ingridientDao.getIngridientsRecipeList(recipe)).thenReturn(null);
        assertNull(ingridient.getIngridientsRecipeList(recipe));
    }

}