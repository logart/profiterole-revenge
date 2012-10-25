package com.exigen.common.repository;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository("recipeDao")
public class RecipeDaoImpl implements RecipeDao {
    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Recipe> getOneRecipeList(Integer recipeId) {
        List<Recipe> results1 = this.entityManager.createNamedQuery("Recipe.findRecipeById")
                .setParameter("selectedId", recipeId).getResultList();
        return results1;
    }

    @Override
    public List<Recipe> getRecipeCuisineList(Cuisine cuisine) {
        List<Recipe> results = this.entityManager.createNamedQuery("Recipe.findRecipeFromCuisine")
                .setParameter("selectedCuisine", cuisine)
                .getResultList();


        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addRecipe(Recipe recipe) {
        entityManager.persist(recipe);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeRecipe(Recipe recipe) {
        entityManager.remove(recipe);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
