package com.exigen.common.domain;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AddRecipeDataTest {

    AddRecipeData addRecipeData=new AddRecipeData();

    @Test
    public void testGetCuisineId() throws Exception {
      addRecipeData.setCuisineId("id");
      Assert.assertEquals("id",addRecipeData.getCuisineId());
    }

    @Test
    public void testGetCategoryId() throws Exception {
      addRecipeData.setCategoryId("id");
        Assert.assertEquals("id",addRecipeData.getCategoryId());

    }

    @Test
    public void testGetTitle() throws Exception {
      addRecipeData.setTitle("title");
        Assert.assertEquals("title", addRecipeData.getTitle());
    }

    @Test
    public void testGetDescription() throws Exception {
        addRecipeData.setDescription("desc");
        Assert.assertEquals("desc",addRecipeData.getDescription());
    }

    @Test
    public void testGetCookingTime() throws Exception {
        String test="234";
        addRecipeData.setCookingTime(test);
        Assert.assertEquals(test, addRecipeData.getCookingTime());
    }

    @Test
    public void testGetCuisine() throws Exception {
       Cuisine cuisine=new Cuisine();
        addRecipeData.setCuisine(cuisine);
        Assert.assertEquals(cuisine,addRecipeData.getCuisine());
    }

    @Test
    public void testGetCategory() throws Exception {
        Categories category=new Categories();
        addRecipeData.setCategory(category);
        Assert.assertEquals(category,addRecipeData.getCategory());
    }

    @Test
    public void testGetIngredientsNameList() throws Exception {
        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add("ingr");
        addRecipeData.setIngredientsNameList(ingredientsNameList);
        Assert.assertEquals(ingredientsNameList,addRecipeData.getIngredientsNameList());
    }

    @Test
    public void testGetIngredientsCountList() throws Exception {
        List<String> ingredientsCountList = new ArrayList<String>();
        ingredientsCountList.add("count");
        addRecipeData.setIngredientsCountList(ingredientsCountList);
        Assert.assertEquals(ingredientsCountList,addRecipeData.getIngredientsCountList());
    }

    @Test
    public void testGetIngredientsTypeList() throws Exception {
        List<String> ingredientsTypeList = new ArrayList<String>();
        ingredientsTypeList.add("type");
        addRecipeData.setIngredientsTypeList(ingredientsTypeList);
        Assert.assertEquals(ingredientsTypeList,addRecipeData.getIngredientsTypeList());
    }

    @Test
    public void testGetStepsList() throws Exception {
        List<String> stepsList = new ArrayList<String>();
        stepsList.add("step");
        addRecipeData.setStepsList(stepsList);
        Assert.assertEquals(stepsList,addRecipeData.getStepsList());
    }

    @Test
    public void testGetImagesForStepsList() throws Exception {
        List<String> imagesForStepsList = new ArrayList<String>();
        imagesForStepsList.add("image");
        addRecipeData.setImagesForStepsList(imagesForStepsList);
        Assert.assertEquals(imagesForStepsList,addRecipeData.getImagesForStepsList());
    }

    @Test
    public void testGetImageForRecipeHead() throws Exception {
       addRecipeData.setImageForRecipeHead("image");
        Assert.assertEquals("image", addRecipeData.getImageForRecipeHead());
    }
}