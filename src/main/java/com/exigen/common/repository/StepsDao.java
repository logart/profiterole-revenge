package com.exigen.common.repository;


import com.exigen.common.domain.Recipe;
import com.exigen.common.domain.Steps;

import java.util.List;

/**
 * Interface {@code StepsDao} used for get, add and remove objects
 * from Steps entity with helps JPA
 *
 * @author Ivan Guravel
 * @date November 9,2012
 */

public interface StepsDao {


    /**
     * {@method getStepsRecipeList(Recipe recipe)}
     *
     * @param recipe(object of some particular recipe)
     * @return the list of steps, where recipe in Steps entity ==@param).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null, or has no results in the database)
     */

    List<Steps> getStepsRecipeList(Recipe recipe);

    /**
     * {@method addStep(Steps step)}
     * for adding information about some particular step into DB
     *
     * @param step(object of some particular step)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when step is null)
     */

    public void addStep(Steps step);

    /**
     * {@method removeStep(Steps step)}
     * for remove some particular step from DB
     *
     * @param step(object of some particular step)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when step is null)
     */

    public void removeStep(Steps step);


}
