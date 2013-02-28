package com.exigen.common.service;

import com.exigen.common.domain.Ingredient;

import java.util.List;

/**
 * Interface {@code IngridientDao} used for get, add and remove objects
 * from Ingredient entity with helps SpringTransaction and JPA
 *
 * @author Ivan Guravel
 * @date November 6,2012
 */
public interface IngridientService {

    /**
     * {@method getIngridientsRecipeList(Integer recipeId)}
     *
     * @param recipeId (ID of some particular recipe)
     * @return the list of ingredients, where recipe in Ingredient entity =@param).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null, or has no results in the database)
     */
    List<Ingredient> getIngridientsRecipeList(Integer recipeId);

    /**
     * {@method getAllIngridientsWithOutRecipesInj()}
     *
     * @return the list of ingredients.
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when search has no results in the database)
     */
    List<Ingredient> getAllIngridientsWithOutRecipesInj();

    /**
     * {@method getIngridientById()}
     * @param ingridientId (ID of some ingredient)
     * @return the ingredient with id = ingridientId.
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when search has no results in the database)
     */
    Ingredient getIngridientById(Integer ingridientId);
    /**
     * {@method addIngridient(Ingredient ingredient)}
     * for adding information about some particular ingredient into DB
     *
     * @param ingredient (object of some particular ingredient)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when ingridient is null)
     */
    void addIngridient(Ingredient ingredient);

    /**
     * {@method removeIngridient(Ingredient ingredient)}
     * for remove some particular ingredient from DB
     *
     * @param ingredient (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when ingridient is null)
     */
    void removeIngridient(Ingredient ingredient);

    List<Ingredient> getAllIngridients(List<Integer> listOfRecipesId);
}