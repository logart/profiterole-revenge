package com.exigen.common.repository;


import com.exigen.common.domain.Ingredient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository("ingredientDao")
public class IngredientDaoImpl implements IngredientDao {

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public Ingredient getIngredientById(Integer ingredientId) {
        return entityManager.find(Ingredient.class, ingredientId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ingredient getIngredientByName(String ingredientName) {
        return entityManager.createNamedQuery("Ingredient.getIngredientByName",Ingredient.class)
                .setParameter("selectedName",ingredientName)
                .getSingleResult();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> results= this.entityManager.createNamedQuery("Ingredient.getAllIngredients",Ingredient.class)
                .getResultList();

        return results;
    }


    @Override
    public List<Ingredient> getIngredientsListByLetter(String term) {
        List<Ingredient> results= this.entityManager.createNamedQuery("Ingredient.getIngredientsListByLetter",Ingredient.class)
                .setParameter("term", term + "%")
                .getResultList();

        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addIngredient(Ingredient ingredient) {
        entityManager.persist(ingredient);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeIngredient(Ingredient ingredient) {
        entityManager.remove(ingredient);
    }
}