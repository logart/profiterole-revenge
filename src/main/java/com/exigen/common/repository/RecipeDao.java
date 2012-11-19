package com.exigen.common.repository;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;

import java.util.List;

/**
 * Interface {@code CategoriesDao} used for get, add and remove objects
 * from Categories entity with helps JPA
 *
 * @author Ulyana Kucheryavaya
 * @date June 21,2012
 */
public interface RecipeDao {

    /**
     * {@method getOneRecipeList(Integer recipeId)}
     *
     * @param recipeId (unique identificator of some particular recipe)
     * @return the recipes, where Recipe field recipeId equals parameter recipeId( return complete description
     *         of the recipe with the steps, ingredients, Pictures.).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipeId is null, or id has no results in the database)
     */
    Recipe getOneRecipe(Integer recipeId);

    /**
     * {@method getRecipeCuisineList(Cuisine cuisine)}
     *
     * @param cuisine (object of some particular recipe)
     * @return the list of recipes, where cuisine in Recipe entity =@param).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null, or id has no results in the database)
     */

    List<Recipe> getRecipeCuisineList(Cuisine cuisine);

    /**
     * {@method addRecipe(Recipe recipe)}
     * for adding information about some particular recipe into DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null)
     */
    void addRecipe(Recipe recipe);

    /**
     * {@method removeRecipe(Recipe recipe)}
     * for remove some particular recipe from DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null)
     */
    void removeRecipe(Recipe recipe);
}