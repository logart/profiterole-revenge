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
import org.springframework.mock.web.MockMultipartFile;
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
    public void processAddingRecipeValidatedOkWithImages() throws Exception {
        when(cuisineService.getCuisine()).thenReturn(null);
        when(categoriesService.getCategories()).thenReturn(null);
        when(ingredientService.getAllIngredientsSortedList()).thenReturn(null);
        when(addRecipeDataService.getCategoryFromListByID(anyInt(), anyList())).thenReturn(null);
        when(addRecipeDataService.getCuisineFromListByID(anyInt(), anyList())).thenReturn(null);

        ReflectionTestUtils.setField(addRecipesController, "ingredientService", this.ingredientService);
        ReflectionTestUtils.setField(addRecipesController, "cuisineService", this.cuisineService);
        ReflectionTestUtils.setField(addRecipesController, "categoriesService", this.categoriesService);
        ReflectionTestUtils.setField(addRecipesController, "addRecipeDataValidator", this.addRecipeDataValidator);
        ReflectionTestUtils.setField(addRecipesController, "addRecipeDataService", this.addRecipeDataService);
        ReflectionTestUtils.setField(addRecipesController, "imageService", this.imageService);

        Map model = new TreeMap();
        AddRecipeData addRecipeData = new AddRecipeData();
        List<MultipartFile> multipartFiles = new ArrayList<MultipartFile>();
        MultipartFile fileStepImg1 = new MockMultipartFile("fileStepImg1", "originalFileStepImgName1", "application/oct-stream",
                new byte[] { 1, 2 });
        MultipartFile fileStepImg2 = new MockMultipartFile("fileStepImg2", "originalFileStepImgName2", "application/oct-stream",
                new byte[] { 3, 4 });
        multipartFiles.add(fileStepImg1);
        multipartFiles.add(fileStepImg2);
        addRecipeData.setFiles(multipartFiles);
        addRecipeData.setCategoryId("1");
        addRecipeData.setCuisineId("1");
        MultipartFile fileRecipeImg = new MockMultipartFile("fileRecipeImg", "originalFileRecipeImg", "application/oct-stream",
                new byte[] { 5, 6 });
        addRecipeData.setImages(fileRecipeImg);

        when(addRecipeDataValidator.supports(addRecipeData.getClass())).thenReturn(true);

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        Assert.assertEquals("redirect:success", addRecipesController.processAddingRecipe(model, addRecipeData, result));
        verify(this.imageService, times(1)).postImage(new byte[]{1, 2}, "originalFileStepImgName1");
        verify(this.imageService, times(1)).postImage(new byte[]{3, 4}, "originalFileStepImgName2");
        verify(this.imageService, times(1)).postImage(new byte[]{5, 6}, "originalFileRecipeImg");
        verify(this.addRecipeDataService, times(1)).getCategoryFromListByID(anyInt(), anyList());
        verify(this.addRecipeDataService, times(1)).getCuisineFromListByID(anyInt(), anyList());
        verify(this.addRecipeDataService, times(1)).addRecipe(addRecipeData);
    }

    @Test
    public void processAddingRecipeValidatedOkDefaultImages() throws Exception {
        when(cuisineService.getCuisine()).thenReturn(null);
        when(categoriesService.getCategories()).thenReturn(null);
        when(ingredientService.getAllIngredientsSortedList()).thenReturn(null);
        when(addRecipeDataService.getCategoryFromListByID(anyInt(),anyList())).thenReturn(null);
        when(addRecipeDataService.getCuisineFromListByID(anyInt(),anyList())).thenReturn(null);

        ReflectionTestUtils.setField(addRecipesController, "ingredientService", this.ingredientService);
        ReflectionTestUtils.setField(addRecipesController, "cuisineService", this.cuisineService);
        ReflectionTestUtils.setField(addRecipesController, "categoriesService", this.categoriesService);
        ReflectionTestUtils.setField(addRecipesController, "addRecipeDataValidator", this.addRecipeDataValidator);
        ReflectionTestUtils.setField(addRecipesController, "addRecipeDataService", this.addRecipeDataService);
        ReflectionTestUtils.setField(addRecipesController, "imageService", this.imageService);

        Map model = new TreeMap();
        AddRecipeData addRecipeData = new AddRecipeData();
        List<MultipartFile> multipartFiles = new ArrayList<MultipartFile>();
        multipartFiles.add(new MockMultipartFile("haha",new byte[] {}));
        multipartFiles.add(new MockMultipartFile("haha",new byte[] {}));
        addRecipeData.setFiles(multipartFiles);
        addRecipeData.setCategoryId("1");
        addRecipeData.setCuisineId("2");
        MultipartFile fileRecipeImg = new MockMultipartFile("haha3", new byte[] {});
        addRecipeData.setImages(fileRecipeImg);

        when(addRecipeDataValidator.supports(addRecipeData.getClass())).thenReturn(true);

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        Assert.assertEquals("redirect:success", addRecipesController.processAddingRecipe(model, addRecipeData, result));
        verify(this.imageService, times(0)).postImage(any(byte[].class),anyString());
        verify(this.addRecipeDataService, times(1)).getCategoryFromListByID(anyInt(),anyList());
        verify(this.addRecipeDataService, times(1)).getCuisineFromListByID(anyInt(),anyList());
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
