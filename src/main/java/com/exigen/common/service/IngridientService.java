package com.exigen.common.service;

import com.exigen.common.domain.Ingridient;

import java.util.List;

/**
 * Interface {@code IngridientDao} used for get, add and remove objects
 * from Ingridient entity with helps SpringTransaction and JPA
 *
 * @author Ivan Guravel
 * @date November 6,2012
 */
public interface IngridientService {

    /**
     * {@method getIngridientsRecipeList(Integer recipeId)}
     *
     * @param recipeId (ID of some particular recipe)
     * @return the list of ingridients, where recipe in Ingridient entity =@param).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null, or has no results in the database)
     */
    List<Ingridient> getIngridientsRecipeList(Integer recipeId);

    /**
     * {@method addIngridient(Ingridient ingridient)}
     * for adding information about some particular ingridient into DB
     *
     * @param ingridient (object of some particular ingridient)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when ingridient is null)
     */
    public void addIngridient(Ingridient ingridient);

    /**
     * {@method removeIngridient(Ingridient ingridient)}
     * for remove some particular ingridient from DB
     *
     * @param ingridient (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when ingridient is null)
     */
    public void removeIngridient(Ingridient ingridient);
}