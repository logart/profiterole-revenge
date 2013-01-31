package com.exigen.common.controller;

import com.exigen.common.service.IngridientService;
import com.exigen.common.service.RecipeService;
import com.exigen.common.service.StepService;
import com.exigen.common.web.ModalRecipeDescriptionController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.xml.MarshallingView;

import static org.mockito.Mockito.when;


public class ModalRecipeDescriptionControllerTest {

    @Mock
    ModelAndView returnModel;

    @Mock
    RecipeService recipeService;

    @Mock
    IngridientService ingridientService;

    @Mock
    StepService stepService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    View view=new MarshallingView();

    @Test
    public void testModalRecipeDescription() throws Exception {


      ModalRecipeDescriptionController modalRecipeDescriptionController=new ModalRecipeDescriptionController();

        ReflectionTestUtils.setField(modalRecipeDescriptionController, "returnModel", this.returnModel);

        ReflectionTestUtils.setField(modalRecipeDescriptionController, "recipeService", this.recipeService);

        ReflectionTestUtils.setField(modalRecipeDescriptionController, "ingridientService", this.ingridientService);

        ReflectionTestUtils.setField(modalRecipeDescriptionController, "stepService", this.stepService);




        Assert.assertNull(modalRecipeDescriptionController.modalRecipeDescription(23).getView());
    }
}
