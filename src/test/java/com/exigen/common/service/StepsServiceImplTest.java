package com.exigen.common.service;


import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.StepsDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class StepsServiceImplTest {

    private StepsServiceImpl stepsService = new StepsServiceImpl();

    Recipe recipe = new Recipe();

    @Mock
    StepsDao stepsDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getStepsService() {
        stepsService.setStepsDao(stepsDao);
        when(stepsDao.getStepsRecipeList(recipe.getRecipeId())).thenReturn(null);
        assertNull(stepsDao.getStepsRecipeList(recipe.getRecipeId()));
    }
}
