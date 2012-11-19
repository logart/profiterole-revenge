package com.exigen.common.service;

import com.exigen.common.domain.Step;

import java.util.List;

/**
 * Interface {@code StepsService} used for get, add and remove objects
 * from Steps entity with helps JPA adn Spring Transaction
 *
 * @author Ivan Guravel
 * @date November 9,2012
 */
public interface StepService {

    /**
     * {@method getStepsRecipeList(Integer recipeId)}
     *
     * @param recipeId (Id of some particular recipe)
     * @return the list of step, where recipe in Steps entity ==@param).
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when recipe is null, or has no results in the database)
     */

    List<Step> getListOfRecipeSteps(Integer recipeId);

    /**
     * {@method addStep(Steps step)}
     * for adding information about some particular step into DB
     *
     * @param step (object of some particular step)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when step is null)
     */

    void addStep(Step step);

    /**
     * {@method removeStep(Steps step)}
     * for remove some particular step from DB
     *
     * @param step (object of some particular step)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when step is null)
     */

    void removeStep(Step step);
}