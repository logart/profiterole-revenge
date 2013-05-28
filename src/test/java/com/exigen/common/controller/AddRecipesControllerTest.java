package com.exigen.common.controller;

import com.exigen.common.domain.AddRecipeData;
import com.exigen.common.domain.ChangeForgottenPasswordData;
import com.exigen.common.service.*;
import com.exigen.common.web.AddRecipesController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class AddRecipesControllerTest {
    @Mock
    private CuisineService cuisineService;
    @Mock
    private CategoriesService categoriesService;
    @Mock
    private ImageService imageService;
    @Mock
    private AddRecipeDataValidator addRecipeDataValidator;
    @Mock
    private AddRecipeDataService addRecipeDataService;
    @Mock
    private IngredientService ingredientService;
    private AddRecipesController addRecipesController = new AddRecipesController();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testShowAddingRecipe() throws Exception {
        when(cuisineService.getCuisine()).thenReturn(null);
        when(categoriesService.getCategories()).thenReturn(null);
        when(ingredientService.getAllIngredientsSortedList()).thenReturn(null);


        ReflectionTestUtils.setField(addRecipesController, "ingredientService", this.ingredientService);
        ReflectionTestUtils.setField(addRecipesController, "cuisineService", this.cuisineService);
        ReflectionTestUtils.setField(addRecipesController, "categoriesService", this.categoriesService);
        String test = addRecipesController.showAddingRecipe(new TreeMap());
        Assert.assertEquals("addRecipes", test);
    }

    @Test
    public void processAddingRecipeValidatedOkDefaultImages() throws Exception {
        when(cuisineService.getCuisine()).thenReturn(null);
        when(categoriesService.getCategories()).thenReturn(null);
        when(ingredientService.getAllIngredientsSortedList()).thenReturn(null);

        ReflectionTestUtils.setField(addRecipesController, "ingredientService", this.ingredientService);
        ReflectionTestUtils.setField(addRecipesController, "cuisineService", this.cuisineService);
        ReflectionTestUtils.setField(addRecipesController, "categoriesService", this.categoriesService);
        ReflectionTestUtils.setField(addRecipesController, "addRecipeDataValidator", this.addRecipeDataValidator);
        ReflectionTestUtils.setField(addRecipesController, "addRecipeDataService", this.addRecipeDataService);
        ReflectionTestUtils.setField(addRecipesController, "imageService", this.imageService);

        Map model = new TreeMap();
        AddRecipeData addRecipeData = new AddRecipeData();
        addRecipeData.setFiles(new ArrayList<MultipartFile>());
        addRecipeData.setCategoryId("1");
        addRecipeData.setCuisineId("1");
        addRecipeData.setImages(new MultipartFile() {
            @Override
            public String getName() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getOriginalFilename() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getContentType() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isEmpty() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public long getSize() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void transferTo(File file) throws IOException, IllegalStateException {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        } );
        when(addRecipeDataValidator.supports(addRecipeData.getClass())).thenReturn(true);

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        Assert.assertEquals("redirect:success", addRecipesController.processAddingRecipe(model, addRecipeData, result));
        verify(this.addRecipeDataService, times(1)).addRecipe(addRecipeData);
    }

    @Test
    public void processAddingRecipeValidatedNotOk() throws Exception {
        when(cuisineService.getCuisine()).thenReturn(null);
        when(categoriesService.getCategories()).thenReturn(null);
        when(ingredientService.getAllIngredientsSortedList()).thenReturn(null);

        ReflectionTestUtils.setField(addRecipesController, "ingredientService", this.ingredientService);
        ReflectionTestUtils.setField(addRecipesController, "cuisineService", this.cuisineService);
        ReflectionTestUtils.setField(addRecipesController, "categoriesService", this.categoriesService);
        ReflectionTestUtils.setField(addRecipesController, "addRecipeDataValidator", this.addRecipeDataValidator);
        ReflectionTestUtils.setField(addRecipesController, "addRecipeDataService", this.addRecipeDataService);

        Map model = new TreeMap();
        AddRecipeData addRecipeData = new AddRecipeData();
        when(addRecipeDataValidator.supports(addRecipeData.getClass())).thenReturn(true);

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        Assert.assertEquals("addRecipes", addRecipesController.processAddingRecipe(model, addRecipeData, result));
        verify(this.addRecipeDataService, never()).addRecipe(addRecipeData);
    }

}
