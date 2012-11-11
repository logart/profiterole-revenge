package com.exigen.common.repository;

import com.exigen.common.domain.Recipe;
import com.exigen.common.domain.Steps;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@inheritDoc}
 */

public class StepsDaoImpl implements StepsDao {

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */

    @Override
    public List<Steps> getStepsRecipeList(Recipe recipe) {
        List<Steps> stepsList = this.entityManager.createQuery("SELECT t FROM Steps t WHERE t.recipe.recipeId=:selectedRecipe.recipeId")
                .setParameter("selectedRecipe", recipe)
                .getResultList();

        return stepsList;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void addStep(Steps step) {
        entityManager.persist(step);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void removeStep(Steps step) {
        entityManager.remove(step);

    }
}
