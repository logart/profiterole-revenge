package com.exigen.common.service;

import com.exigen.common.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface {@code AddRecipeDataServiceImpl} used for add new recipe to DB, and for
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
    private IngridientService ingridientService;
    @Autowired
    private StepService stepService;

    /**
     * {@method getCategoryFromListByID(Integer id, List<Categories> list)}
     *
     * @param id   (Id of category what should be founded)
     * @param list (list of categories where should be founded category by id)
     * @return If the list includes a category with a specified id return that category,
     *         else return null
     */
    public Categories getCategoryFromListByID(Integer id, List<Categories> list) {
        for (Categories c : list) {
            if (c.getCategoriesId() == id) {
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
    public Cuisine getCuisineFromListByID(Integer id, List<Cuisine> list) {
        for (Cuisine c : list) {
            if (c.getCuisineId() == id) {
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
        Recipe recipe = makeRecipe(data);
        List<Ingridient> ingridienstList = makeIngredients(data, recipe);
        List<Step> stepList = makeSteps(data, recipe);
        recipeService.addRecipe(recipe);
        for (Ingridient ingridient : ingridienstList) {
            ingridientService.addIngridient(ingridient);
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
        recipe.setCategories(data.getCategory());
        recipe.setSmallImg("http://25.media.tumblr.com/tumblr_m9p3n1vJmZ1rexr16o1_400.jpg");
        recipe.setBigImg("http://25.media.tumblr.com/tumblr_m9p3n1vJmZ1rexr16o1_400.jpg");
        recipe.setTime(Integer.parseInt(data.getCookingTime()));
        recipe.setCalories(getCalories(data.getIngredientsNameList()).intValue());
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
        List<String> stepsList = data.getStepsList();
        List<Step> result = new ArrayList<Step>();
        for (int i = 0; i < stepsList.size(); i++) {
            Step step = new Step();
            step.setStepDescription(stepsList.get(i));
            step.setStepImg("");
            step.setStepNumber(i + 1);
            step.setRecipe(recipe);
            result.add(step);
        }
        return result;
    }

    /**
     * {@method makeIngredients(AddRecipeData data, Recipe recipe)}
     * for make ingredients from AddRecipeData
     *
     * @param data   (object with data what user input)
     * @param recipe (recipe whose ingredients are created)
     * @return list of ingredients
     */
    private List<Ingridient> makeIngredients(AddRecipeData data, Recipe recipe) {
        List<String> idList = data.getIngredientsNameList();
        List<String> countsList = data.getIngredientsCountList();
        List<String> typesList = data.getIngredientsTypeList();
        List<Ingridient> result = new ArrayList<Ingridient>();
        for (int i = 0; i < idList.size(); i++) {
            Ingridient temp = ingridientService.getIngridientById(Integer.parseInt(idList.get(i)));
            Ingridient ingredient = new Ingridient();

            ingredient.setCountOfIngridient(Integer.parseInt(countsList.get(i)));
            ingredient.setNameOfIngridient(temp.getNameOfIngridient());
            ingredient.setUnitOfMeasure(typesList.get(i));
            ingredient.setCalories(temp.getCalories());
            ingredient.setRecipe(recipe);
            result.add(ingredient);
        }
        return result;
    }

    /**
     * {@method makeIngredients(AddRecipeData data, Recipe recipe)}
     * for make ingredients from AddRecipeData
     *
     * @param idList (list with id of selected ingredients)
     * @return summary calories of selected ingredients
     */
    private Float getCalories(List<String> idList) {
        float calories = 0;
        for (int i = 0; i < idList.size(); i++) {
            Ingridient temp = ingridientService.getIngridientById(Integer.parseInt(idList.get(i)));
            calories += temp.getCalories();
        }
        return calories;
    }
}
