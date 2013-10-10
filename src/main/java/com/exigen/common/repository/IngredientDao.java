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
     * {@method getIngredientById(Integer ingredientId)}
     *
     * @param ingredientId (ID of the ingredient)
     * @return the ingredient).
     */
    Ingredient getIngredientById(Integer ingredientId);
    /**
     * {@method getIngredientByName(String ingredientName)}
     *
     * @param ingredientName (Name of the ingredient)
     * @return the ingredient).
     */
    Ingredient getIngredientByName(String ingredientName);
    /**
     * {@method getAllIngredients()}
     *
     * @return the list of ingredients.
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


    List<Ingredient> getIngredientsListByLetter(String term) ;
}