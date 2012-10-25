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
@Repository("cuisineDao")

public class CuisineDaoImpl implements CuisineDao {
    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Cuisine> getCuisine() {
        List<Cuisine> results = this.entityManager.createQuery("select t from Cuisine t ")
                .getResultList();
        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Recipe> getOneCuisineList(Integer cuis) {
        List<Recipe> results = this.entityManager.createQuery("select t.recipes from Cuisine t where t.cuisineId=:selectedCuis")
                .setParameter("selectedCuis", cuis)
                .getResultList();
        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCuisine(Cuisine cuisine) {
        entityManager.persist(cuisine);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeCuisine(Cuisine cuisine) {
        entityManager.remove(cuisine);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}