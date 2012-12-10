package com.exigen.common.service;

import com.exigen.common.domain.*;
import com.exigen.common.repository.IngridientDao;
import com.exigen.common.repository.RecipeDao;
import com.exigen.common.repository.StepDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class {@code RecipeService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Sergey
 * @date July 17,2012
 */
@Service("recipeService")
@Transactional(readOnly = true)
public class RecipeServiceImpl implements RecipeService {

    /**
     * {@code recipeDao} describes the RecipeDao work with DB and Recipe entity
     */
    @Autowired
    private RecipeDao recipeDao;
    /**
     * {@code ingridientDao} describes the IngridientDao work with DB and Ingridient entity
     */
    @Autowired
    private IngridientDao ingridientDao;

    @Autowired
    private StepDao stepDao;//TODO
    /**
     * {@method getRecipeCuisineList(Cuisine cuisine)}
     *
     * @param cuisine (object of some particular recipe)
     * @return the list of recipes, where cuisine in Recipe entity =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when cuisine is null, or id has no results in the database)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getRecipeCuisineList(Cuisine cuisine) {
        return recipeDao.getRecipeCuisineList(cuisine);
    }

    /**
     * {@method getOneRecipeList(Integer recipeId)}
     *
     * @param recipeId (unique identificator of some particular recipe)
     * @return the recipe, where Recipe field recipeId equals parameter recipeId( return complete description
     *         of the recipe with the steps, ingredients, Pictures.).
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipeId is null, or id has no results in the database)
     */

    @Override
    @Transactional(readOnly = true)
    public Recipe getOneRecipe(Integer recipeId) {

        return recipeDao.getOneRecipe(recipeId);

    }

    /**
     * {@method addRecipe(Recipe recipe)}
     * for adding information about some particular recipe into DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipe is null)
     */
    @Transactional
    public void addRecipe(Recipe recipe) {
        recipeDao.addRecipe(recipe);
    }

    /**
     * {@method removeRecipe(Recipe recipe)}
     * for remove some particular recipe from DB
     *
     * @param data (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipe is null)
     */

    @Transactional
    public void addRecipe(AddRecipeData data) {
        List<Ingridient> ingridienstList = new ArrayList<Ingridient>();
        Recipe recipe = new Recipe();
        recipe.setTitle(data.getTitle());
        recipe.setDescription(data.getDescription());
        recipe.setCuisine(data.getCuisine());
        recipe.setCategories(data.getCategory());
        recipe.setSmallImg("http://25.media.tumblr.com/tumblr_m9p3n1vJmZ1rexr16o1_400.jpg");
        recipe.setBigImg("http://25.media.tumblr.com/tumblr_m9p3n1vJmZ1rexr16o1_400.jpg");
        recipe.setTime(Integer.parseInt(data.getCookingTime()));
        recipe.setCalories(1000);
        recipeDao.addRecipe(recipe);
//        ingridienstList = new AddRecipeDataService().getIngridientsFromData(data.getIngredientsNameList(), data.getIngredientsCountList(), data.getIngredientsTypeList());
//        Ingridient ingr_g1 = new Ingridient("Растительное масло", 32, 40, "мл.", recipe);
//        Ingridient ingr_g2 = new Ingridient("Томатное пюре", 23, 5000, "г", recipe);
//        Ingridient ingr_g3 = new Ingridient("Соль морская", 2, 30, "г", recipe);
//        Ingridient ingr_g4 = new Ingridient("Бульон говяжий", 20, 500, "мл.", recipe);
//        Ingridient ingr_g5 = new Ingridient("Лук репчатый", 2, 2, "шт", recipe);
//        Ingridient ingr_g6 = new Ingridient("Фасоль красная в собственном соку", 20, 500, "мл.", recipe);
//        List<Ingridient> list1 = new ArrayList<Ingridient>(Arrays.asList(ingr_g1, ingr_g2, ingr_g3, ingr_g4, ingr_g5, ingr_g6));
        for (Ingridient ingridient : ingridienstList) {
            ingridientDao.addIngridient(ingridient);
        }
        for (int i = 0; i < data.getStepsList().length; i++){
            stepDao.addStep(new Step(i+1, data.getStepsList()[i], recipe));
        }
    }

    /**
     * {@method removeRecipe(Recipe recipe)}
     * for remove some particular recipe from DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipe is null)
     */
    @Transactional
    public void removeRecipe(Recipe recipe) {
        recipeDao.removeRecipe(recipe);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public Integer caloriesCalculation(List<Integer> recipesId) {
        Integer counterOfCalories = 0;
        for (int i = 0; i < recipesId.size(); i++) {
            counterOfCalories = +(recipeDao.getOneRecipe(recipesId.get(i))).getCalories();
        }
        return counterOfCalories;
    }

    /**
     * {@method setRecipeDao(RecipeDao recipeDao)}
     * for tests services. Inject in this class
     */

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}