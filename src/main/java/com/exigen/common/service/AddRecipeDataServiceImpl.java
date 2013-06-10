package com.exigen.common.service;

import com.exigen.common.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code AddRecipeDataServiceImpl} used for add new recipe to DB, and for
 * editing input data
 *
 * @author Oleg Kalinichenko
 * @date December 30,2012
 */
@Service("addRecipeDataService")
public class AddRecipeDataServiceImpl implements AddRecipeDataService {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private IngredientBucketService ingredientBucketService;
    @Autowired
    private StepService stepService;
    @Autowired
    private MeasureBucketService measureBucketService;
    private byte marker=0;
    /**
     * {@method getCategoryFromListByID(Integer id, List<Category> list)}
     *
     * @param id   (Id of category what should be founded)
     * @param list (list of category where should be founded category by id)
     * @return If the list includes a category with a specified id return that category,
     *         else return null
     */
    public Category getCategoryFromListByID(int  id, List<Category> list) {
        for (Category c : list) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /**
     * {@method getCuisineFromListByID(Integer id, List<Cuisine> list)}
     *
     * @param id   (Id of cuisine what should be founded)
     * @param list (list of cuisines where should be founded cuisine by id)
     * @return If the list includes a cuisine with a specified id return that cuisine,
     *         else return null
     */
    public Cuisine getCuisineFromListByID(int id, List<Cuisine> list) {
        for (Cuisine c : list) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /**
     * {@method addRecipe(AddRecipeData data)}
     * for make recipe, steps and ingredients from AddRecipeData,
     * and add it do DB
     *
     * @param data (object with data what user input)
     */
    public void addRecipe(AddRecipeData data) {
        marker = makeMarkers(data.getMarkersNames());
        Recipe recipe = makeRecipe(data);
        List<IngredientBucket> ingredientBuckets = makeIngredients(data, recipe);
        List<Step> stepList = makeSteps(data, recipe);
        recipeService.addRecipe(recipe);
        for (IngredientBucket ingredientBucket : ingredientBuckets) {
            ingredientBucketService.addIngredientBucket(ingredientBucket);
        }
        for (Step step : stepList) {
            stepService.addStep(step);
        }

    }

    /**
     * {@method makeRecipe(AddRecipeData data)}
     * for make recipe from AddRecipeData
     *
     * @param data (object with data what user input)
     * @return returns Recipe with data inputted by the user
     */
    private Recipe makeRecipe(AddRecipeData data) {
        Recipe recipe = new Recipe();
        recipe.setTitle(data.getTitle());
        recipe.setDescription(data.getDescription());
        recipe.setCuisine(data.getCuisine());
        recipe.setCategory(data.getCategory());
        recipe.setSmallImage(data.getImageForRecipeHead());
        recipe.setBigImage(data.getImageForRecipeHead());
        data.setCookingTime(data.getCookingTimeHours(), data.getCookingTimeMinutes());
        recipe.setTimeOfCooking(data.getCookingTime());
        recipe.setMarkers(marker);
        return recipe;

    }

    /**
     * {@method makeSteps(AddRecipeData data, Recipe recipe)}
     * for make steps from AddRecipeData
     *
     * @param data   (object with data what user input)
     * @param recipe (recipe whose steps are created)
     * @return list of steps
     */
    private List<Step> makeSteps(AddRecipeData data, Recipe recipe) {
        List<String> descriptionsOfSteps = data.getStepsList();
        List<Step> steps = new ArrayList<Step>();
        List<String> imagesOfSteps = data.getImagesForStepsList();
        for (int i = 0; i < descriptionsOfSteps.size(); i++) {
            Step step = new Step();
            step.setDescription(descriptionsOfSteps.get(i));
            step.setImage(imagesOfSteps.get(i));
            step.setNumber(i + 1);
            step.setRecipe(recipe);
            steps.add(step);
        }
        return steps;
    }

    /**
     * {@method makeIngredients(AddRecipeData data, Recipe recipe)}
     * for make ingredientBuckets from AddRecipeData
     *
     * @param data   (object with data what user input)
     * @param recipe (recipe whose ingredients are created)
     * @return list of IngredientBuckets
     */
    private List<IngredientBucket> makeIngredients(AddRecipeData data, Recipe recipe) {
        List<String> ingredientsId = data.getIngredientsNameList();
        List<String> ingredientsCount = data.getIngredientsCountList();
        List<String> ingredientsMeasureId = data.getIngredientsTypeList();
        List<IngredientBucket> result = new ArrayList<IngredientBucket>();
        for (int i = 0; i < ingredientsId.size(); i++) {
            IngredientBucket ingredientBucket = new IngredientBucket();
            MeasuresBucket measuresBucket = measureBucketService.getMeasuresBucketListById(
                    Integer.parseInt(ingredientsMeasureId.get(i))
            );
            Ingredient ingredient = measuresBucket.getIngredient();
            ingredientBucket.setCountOfIngredient(Integer.parseInt(ingredientsCount.get(i)));
            ingredientBucket.setIngredient(ingredient);
            ingredientBucket.setMeasuresBucket(measuresBucket);
            ingredientBucket.setRecipe(recipe);
            result.add(ingredientBucket);
        }
        return result;
    }

    /**
     * {@method makeMarkers(List<String> markersNames)}
     * for make field of marker from list of marker's names
     *
     * @param markersNames  (the list of marker's names)
     *
     * @return markers
     */
    private byte makeMarkers(List<String> markersNames){
        int markers = 0;
        int a=1;
        if (markersNames!=null){
             for (int i =0; i < markersNames.size(); i++ ){
                  int j=(markersNames.get(i)==null?0:1);
                  markers = markers + a * j;
                  a=a*2;
             }
        }
        return (byte)markers;
    }

}
