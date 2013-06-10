package com.exigen.common.service;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.domain.RecipeWithMarkers;

import java.util.List;
import java.util.Map;

/**
 * Interface {@code RecipeService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Sergey
 * @date July 17,2012
 */
public interface RecipeService {

    /**
     * {@method getRecipeCuisineList(Cuisine cuisine)}
     *
     * @param cuisine (object of some particular recipe)
     * @return the list of recipes, where cuisine in Recipe entity =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when cuisine is null, or id has no results in the database)
     */

    List<Recipe> getRecipeCuisineList(Cuisine cuisine);

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

    Recipe getOneRecipe(Integer recipeId);

    /**
     * {@method addRecipe(Recipe recipe)}
     * for adding information about some particular recipe into DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipe is null)
     */
    void addRecipe(Recipe recipe);

    /**
     * {@method removeRecipe(Recipe recipe)}
     * for remove some particular recipe from DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipe is null)
     */

    void removeRecipe(Recipe recipe);

    /**
     * {@method getMarkersOfRecipe(Recipe recipe)}
     * for adding information about markers of recipe
     *
     * @param recipe (object of some particular recipe)
     *
     * @return the map of markers
     *
     */
    Map<String,String> getMarkersOfRecipe(Recipe recipe);

    /**
     * {@method getListRecipesWithMarkers(List<Recipe> recipeList)}
     * for adding information about markers of list of recipe
     *
     * @param recipeList (object list of some particular recipe)
     *
     * @return the list of the object of RecipeWithMarkers
     *
     */
    List<RecipeWithMarkers> getListRecipesWithMarkers(List<Recipe> recipeList);

    /**
     * {@method getListOfMarkersNames()}
     * for get information about names of markers
     *
     * @return the list of names of markers
     *
     */
    List<String> getListOfMarkersNames();
}