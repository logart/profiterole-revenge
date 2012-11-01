package com.exigen.common.service;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * {@method getRecipeCuisineList(Cuisine cuisine)}
     *
     * @param cuisine(object of some particular recipe)
     * @return the list of recipes, where cuisine in Recipe entity =@param).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null, or id has no results in the database)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getRecipeCuisineList(Cuisine cuisine) {
        return recipeDao.getRecipeCuisineList(cuisine);
    }

    /**
     * {@method getOneRecipeList(Integer recipeId)}
     *
     * @param recipeId(unique identificator of some particular recipe)
     * @return the list of recipes, where Recipe field recipeId equals parameter recipeId( return complete description
     *         of the recipe with the steps, ingredients, Pictures.).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipeId is null, or id has no results in the database)
     */

    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getOneRecipeList(Integer recipeId) {

        return recipeDao.getOneRecipeList(recipeId);

    }

    /**
     * {@method addRecipe(Recipe recipe)}
     * for adding information about some particular recipe into DB
     *
     * @param recipe(object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null)
     */
    @Transactional
    public void addRecipe(Recipe recipe) {
        recipeDao.addRecipe(recipe);
    }

    /**
     * {@method removeRecipe(Recipe recipe)}
     * for remove some particular recipe from DB
     *
     * @param recipe(object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null)
     */

    @Transactional
    public void removeRecipe(Recipe recipe) {
        recipeDao.removeRecipe(recipe);
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}
