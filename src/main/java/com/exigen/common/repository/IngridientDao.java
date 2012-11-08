package com.exigen.common.repository;


import com.exigen.common.domain.Ingridient;
import com.exigen.common.domain.Recipe;

import java.util.List;

/**
 * Interface {@code IngridientDao} used for get, add and remove objects
 * from Ingridient entity with helps JPA
 *
 * @author Ivan Guravel
 * @date November 6,2012
 */

public interface IngridientDao {

    /**
     * {@method getIngridientsRecipeList(Recipe recipe)}
     *
     * @param recipe(object of some particular recipe)
     * @return the list of ingridients, where recipe in Ingridient entity =@param).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null, or has no results in the database)
     */
    List<Ingridient> getIngridientsRecipeList(Recipe recipe);

    /**
     * {@method addIngridient(Ingridient ingridient)}
     * for adding information about some particular ingridient into DB
     *
     * @param ingridient(object of some particular ingridient)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when ingridient is null)
     */
    public void addIngridient(Ingridient ingridient);

    /**
     * {@method removeIngridient(Ingridient ingridient)}
     * for remove some particular ingridient from DB
     *
     * @param ingridient(object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when ingridient is null)
     */
    public void removeIngridient(Ingridient ingridient);


}