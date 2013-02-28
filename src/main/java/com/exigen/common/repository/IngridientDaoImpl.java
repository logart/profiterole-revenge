package com.exigen.common.repository;


import com.exigen.common.domain.Ingredient;
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
    public List<Ingredient> getIngridientsRecipeList(Integer recipeId) {
        List<Ingredient> ingredientList = this.entityManager.createNamedQuery("Ingredient.findIngredientsAboutRecipe", Ingredient.class)
                .setParameter("selectedRecipeId", recipeId)
                .getResultList();

        return ingredientList;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Ingredient getIngridientById(Integer ingridientId) {
        return entityManager.find(Ingredient.class, ingridientId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ingredient> getAllIngridients() {
        List<Ingredient> results= this.entityManager.createNamedQuery("Ingredient.getAllIngredients",Ingredient.class)
                .getResultList();

        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addIngridient(Ingredient ingredient) {
        entityManager.persist(ingredient);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeIngridient(Ingredient ingredient) {
        entityManager.remove(ingredient);
    }
}