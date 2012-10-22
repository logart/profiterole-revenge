package com.exigen.common.service;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Meal;
import com.exigen.common.domain.Recipe;

import java.util.List;

/**
 * Interface {@code RecipeService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Sergey
 * @date July 17,2012
 */
public interface RecipeService {

    /**
     * {@method getRecipeList(Meal meal)}
     *
     * @param meal(category for Breakfast,Dinner or Supper)
     * @return the list of recipes, when field "meal" in Recipe Entity equals meal.
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when meal is null, or meal is not exist in Meal Enum)
     */
    List<Recipe> getRecipeList(Meal meal);

    List<Recipe> getRecipeCuisineList(Cuisine cuisine);

    /**
     * {@method addRecipe(Recipe recipe)}
     * for adding information about some particular recipe into DB
     *
     * @param recipe(object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null)
     */
    void addRecipe(Recipe recipe);

    /**
     * {@method removeRecipe(Recipe recipe)}
     * for remove some particular recipe from DB
     *
     * @param recipe(object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null)
     */
    void removeRecipe(Recipe recipe);
}
