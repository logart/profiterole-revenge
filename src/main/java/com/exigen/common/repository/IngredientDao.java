package com.exigen.common.repository;


import com.exigen.common.domain.Ingredient;

import java.util.List;

/**
 * Interface {@code IngredientDao} used for get, add and remove objects
 * from Ingredient entity with helps JPA
 *
 * @author Ivan Guravel
 * @date November 6,2012
 */

public interface IngredientDao {

    /**
     * {@method getIngredientsRecipeList(Integer recipeId)}
     *
     * @param ingridientId (ID of some particular recipe)
     * @return the list of ingridients, where recipe in Ingredient entity =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipe is null, or has no results in the database)
     */
    Ingredient getIngredientById(Integer ingridientId);
    /**
     * {@method getAllIngredients()}
     *
     * @return the list of ingridients.
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when search has no results in the database)
     */
    List<Ingredient> getAllIngredients();

    /**
     * {@method addIngredient(Ingredient ingredient)}
     * for adding information about some particular ingredient into DB
     *
     * @param ingredient (object of some particular ingredient)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when ingridient is null)
     */
    void addIngredient(Ingredient ingredient);

    /**
     * {@method removeIngredient(Ingredient ingredient)}
     * for remove some particular ingredient from DB
     *
     * @param ingredient (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when ingridient is null)
     */
    void removeIngredient(Ingredient ingredient);
}