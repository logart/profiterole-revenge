package com.exigen.common.service;


import com.exigen.common.domain.AddRecipeData;
import com.exigen.common.domain.Category;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

public class AddRecipeDataValidatorTest {

    AddRecipeDataValidator addRecipeDataValidator=new AddRecipeDataValidator();

    @Test
    public void testTrimList(){
        List<String> test=new ArrayList<String>();
        test.add("test");
        Assert.assertNotNull(addRecipeDataValidator.trimList(test));
    }

    @Test
    public void testCheckIngredientsName(){
        List<String> namesList = new ArrayList<String>();
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTime("7");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(0,"капуста");
        data.setIngredientsNameList(ingredientsNameList);

        List<String> ingredientsCountList = new ArrayList<String>();
        ingredientsCountList.add(0,"500");
        ingredientsCountList.add(1,"450");
        data.setIngredientsCountList(ingredientsCountList);

        List<String> ingredientsTypeList = new ArrayList<String>();
        ingredientsTypeList.add(0,"г");
        ingredientsTypeList.add(1,"г");
        data.setIngredientsTypeList(ingredientsTypeList);

        List<String> imagesForStepsList = new ArrayList<String>();
        imagesForStepsList.add(0,"");
        data.setImagesForStepsList(imagesForStepsList);

        Errors errors = new DirectFieldBindingResult(data,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(false,errors.hasErrors());
    }
}
