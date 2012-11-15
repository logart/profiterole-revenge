package com.exigen.common.repository;

import com.exigen.common.domain.Step;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository("stepDao")
public class StepDaoImpl implements StepDao {

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */

    @Override
    public List<Step> getListOfRecipeSteps(Integer recipeId) {
        List<Step> stepsList = this.entityManager.createQuery("SELECT t FROM Step t WHERE t.recipe.recipeId=:selectedRecipeId")
                .setParameter("selectedRecipeId", recipeId)
                .getResultList();

        return stepsList;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void addStep(Step step) {
        entityManager.persist(step);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void removeStep(Step step) {
        entityManager.remove(step);

    }
}
