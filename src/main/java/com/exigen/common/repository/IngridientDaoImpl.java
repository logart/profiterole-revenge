package com.exigen.common.repository;


import com.exigen.common.domain.Ingridient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository("ingridientDao")
public class IngridientDaoImpl implements IngridientDao {

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ingridient> getIngridientsRecipeList(Integer recipeId) {
        List<Ingridient> ingridientList = this.entityManager.createQuery("SELECT t FROM Ingridient t WHERE t.recipe.recipeId=:selectedRecipeId")
                .setParameter("selectedRecipeId", recipeId)
                .getResultList();

        return ingridientList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addIngridient(Ingridient ingridient) {
        entityManager.persist(ingridient);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeIngridient(Ingridient ingridient) {
        entityManager.remove(ingridient);
    }
}