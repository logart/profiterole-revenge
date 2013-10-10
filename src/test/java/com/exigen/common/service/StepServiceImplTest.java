package com.exigen.common.service;


import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.StepDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class StepServiceImplTest {

    private StepServiceImpl stepsService = new StepServiceImpl();

    Recipe recipe = new Recipe();

    @Mock
    StepDao stepDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getStepsService() {
        stepsService.setStepDao(stepDao);
        when(stepDao.getListOfRecipeSteps(recipe.getId())).thenReturn(null);
        assertNull(stepDao.getListOfRecipeSteps(recipe.getId()));
    }
}