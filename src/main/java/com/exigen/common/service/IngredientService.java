package com.exigen.common.service;

import com.exigen.common.domain.Ingredient;

import java.util.List;

/**
 * Interface {@code IngredientDao} used for get, add and remove objects
 * from Ingredient entity with helps SpringTransaction and JPA
 *
 * @author Ivan Guravel
 * @date November 6,2012
 */
public interface IngredientService {

    /**
     * {@method getIngredientsListByLetter(String term)}
     *
     * @return the list of ingredients.
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                    on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when search has no results in the database)
     */

    List<String> getIngredientsListByLetter(String term);
    /**
     * {@method getIngredientIdByName(String ingredientName)}
     *
     * @return the id of ingredients by name.
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                    on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when search has no results in the database)
     */

    Integer getIngredientIdByName(String ingredientName);
    /**
     * {@method getAllIngredientsSortedList()}
     *
     * @return the list of ingredients.
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                    on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when search has no results in the database)
     */
//    List<Ingredient> getAllIngredientsWithOutRecipesInj();
    List<Ingredient> getAllIngredientsSortedList();

    /**
     * {@method getIngredientById()}
     *
     * @param ingredientId (ID of some ingredient)
     * @return the ingredient with id = ingridientId.
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                    on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when search has no results in the database)
     */
    Ingredient getIngredientById(Integer ingredientId);

    /**
     * {@method addIngredient(Ingredient ingredient)}
     * for adding information about some particular ingredient into DB
     *
     * @param ingredient (object of some particular ingredient)
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                    on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when ingredient is null)
     */
    void addIngredient(Ingredient ingredient);

    /**
     * {@method removeIngredient(Ingredient ingredient)}
     * for remove some particular ingredient from DB
     *
     * @param ingredient (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException)(resource
     *                                    on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException)(when ingredient is null)
     */
    void removeIngredient(Ingredient ingredient);

}