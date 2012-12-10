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
        List<Ingridient> ingridientList = this.entityManager.createNamedQuery("Ingridient.findIngridientsAboutRecipe", Ingridient.class)
                .setParameter("selectedRecipeId", recipeId)
                .getResultList();

        return ingridientList;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Ingridient getIngridientById(Integer ingridientId) {
        return entityManager.find(Ingridient.class, ingridientId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ingridient> getAllIngridients() {
        List<Ingridient> results= this.entityManager.createNamedQuery("Ingridient.getAllIngridients",Ingridient.class)
                .getResultList();

        return results;
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