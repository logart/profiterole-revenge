package com.exigen.common.service;


import com.exigen.common.domain.AddRecipeData;
import com.exigen.common.domain.Category;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddRecipeDataValidatorTest {

    AddRecipeDataValidator addRecipeDataValidator=new AddRecipeDataValidator();

    @Test
    public void testTrimList(){
        List<String> test=new ArrayList<String>();
        test.add("test");
        Assert.assertNotNull(addRecipeDataValidator.trimList(test));
    }

    @Test
    public void testValidate1(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
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

    @Test
    public void testValidate2(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"ша{г1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
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
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testValidate3(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
//        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
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
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testValidate4(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"");
        ingredientsNameList.add(1,"капуста");
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
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testValidate5(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
        data.setIngredientsNameList(ingredientsNameList);

        List<String> ingredientsCountList = new ArrayList<String>();
        ingredientsCountList.add(0,"");
        ingredientsCountList.add(1,"450");
        data.setIngredientsCountList(ingredientsCountList);

        List<String> ingredientsTypeList = new ArrayList<String>();
        ingredientsTypeList.add(0,"г");
        ingredientsTypeList.add(1,"г");
        data.setIngredientsTypeList(ingredientsTypeList);

        List<String> imagesForStepsList = new ArrayList<String>();
        imagesForStepsList.add(0,"");
        data.setImagesForStepsList(imagesForStepsList);
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testValidate6(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
        data.setIngredientsNameList(ingredientsNameList);

        List<String> ingredientsCountList = new ArrayList<String>();
        ingredientsCountList.add(0,"5mt00");
        ingredientsCountList.add(1,"450");
        data.setIngredientsCountList(ingredientsCountList);

        List<String> ingredientsTypeList = new ArrayList<String>();
        ingredientsTypeList.add(0,"г");
        ingredientsTypeList.add(1,"г");
        data.setIngredientsTypeList(ingredientsTypeList);

        List<String> imagesForStepsList = new ArrayList<String>();
        imagesForStepsList.add(0,"");
        data.setImagesForStepsList(imagesForStepsList);
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testValidate7(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
        data.setIngredientsNameList(ingredientsNameList);

        List<String> ingredientsCountList = new ArrayList<String>();
        ingredientsCountList.add(0,"500");
        ingredientsCountList.add(1,"450");
        data.setIngredientsCountList(ingredientsCountList);

        List<String> ingredientsTypeList = new ArrayList<String>();
        ingredientsTypeList.add(0,"");
        ingredientsTypeList.add(1,"г");
        data.setIngredientsTypeList(ingredientsTypeList);

        List<String> imagesForStepsList = new ArrayList<String>();
        imagesForStepsList.add(0,"");
        data.setImagesForStepsList(imagesForStepsList);
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testValidate8(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
        data.setIngredientsNameList(ingredientsNameList);

        List<String> ingredientsCountList = new ArrayList<String>();
        ingredientsCountList.add(0,"500");
        ingredientsCountList.add(1,"450");
        data.setIngredientsCountList(ingredientsCountList);

        List<String> ingredientsTypeList = new ArrayList<String>();
        ingredientsTypeList.add(0,"");
        ingredientsTypeList.add(1,"г");
        data.setIngredientsTypeList(ingredientsTypeList);

        List<String> imagesForStepsList = new ArrayList<String>();
        imagesForStepsList.add(0,"");
        data.setImagesForStepsList(imagesForStepsList);
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testValidate9(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
        data.setIngredientsNameList(ingredientsNameList);

        List<String> ingredientsCountList = new ArrayList<String>();
        ingredientsCountList.add(0,"500");
        ingredientsCountList.add(1,"450");
        data.setIngredientsCountList(ingredientsCountList);

        List<String> ingredientsTypeList = new ArrayList<String>();
        ingredientsTypeList.add(0,"");
        ingredientsTypeList.add(1,"г");
        data.setIngredientsTypeList(ingredientsTypeList);

        List<String> imagesForStepsList = new ArrayList<String>();
        imagesForStepsList.add(0,"");
        data.setImagesForStepsList(imagesForStepsList);
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testValidate10(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"step1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
        data.setIngredientsNameList(ingredientsNameList);

        List<String> ingredientsCountList = new ArrayList<String>();
        ingredientsCountList.add(0,"0.05");
        ingredientsCountList.add(1,"450");
        data.setIngredientsCountList(ingredientsCountList);

        List<String> ingredientsTypeList = new ArrayList<String>();
        ingredientsTypeList.add(0,"г");
        ingredientsTypeList.add(1,"г");
        data.setIngredientsTypeList(ingredientsTypeList);

        List<String> imagesForStepsList = new ArrayList<String>();
        imagesForStepsList.add(0,"");
        data.setImagesForStepsList(imagesForStepsList);
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testValidate11(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"step1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
        data.setIngredientsNameList(ingredientsNameList);

        List<String> ingredientsCountList = new ArrayList<String>();
        ingredientsCountList.add(0,"500");
        ingredientsCountList.add(1,"450");
        data.setIngredientsCountList(ingredientsCountList);

        List<String> ingredientsTypeList = new ArrayList<String>();
        data.setIngredientsTypeList(ingredientsTypeList);

        List<String> imagesForStepsList = new ArrayList<String>();
        imagesForStepsList.add(0,"");
        data.setImagesForStepsList(imagesForStepsList);
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void  supportsTest(){
        AddRecipeData addRecipeData = new AddRecipeData();
        Assert.assertEquals(true,addRecipeDataValidator.supports(addRecipeData.getClass()));
    }

    @Test
    public void testcheckCookingTime1(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("10");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
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
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testcheckCookingTime2(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("1");
        data.setCookingTimeMinutes("20");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
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
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(false,errors.hasErrors());
    }

    @Test
    public void testcheckCookingTime3(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("0");
        data.setCookingTimeMinutes("5");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
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
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }
    @Test
    public void testcheckCookingTime4(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("0");
        data.setCookingTimeMinutes("60");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
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
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());
    }

    @Test
    public void testcheckCookingTime5(){
        AddRecipeData data = new AddRecipeData();
        data.setTitle("борщ");
        data.setCategory(new Category("первое"));
        data.setCategoryId("0");
        data.setCookingTimeHours("");
        data.setCookingTimeMinutes("");
        data.setDescription("описание");

        List<String> stepsList = new ArrayList<String>();
        stepsList.add(0,"шаг1");
        data.setStepsList(stepsList);

        List<String> ingredientsNameList = new ArrayList<String>();
        ingredientsNameList.add(0,"картошка");
        ingredientsNameList.add(1,"капуста");
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
        Map map = new HashMap();
        Errors errors = new MapBindingResult(map,"");
        addRecipeDataValidator.validate(data,errors);
        Assert.assertEquals(true,errors.hasErrors());

    }
}
