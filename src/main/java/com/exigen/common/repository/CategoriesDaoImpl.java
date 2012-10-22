package com.exigen.common.repository;

import com.exigen.common.domain.Categories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * {@inheritDoc}
 */

@Repository("categoriesDao")

public class CategoriesDaoImpl implements CategoriesDao {
    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Categories> getCategories() {
        List<Categories> results = this.entityManager.createQuery("select t from Categories t")
                .getResultList();
        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCategories(Categories categ) {

        entityManager.persist(categ);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeCategories(Categories categ) {
        entityManager.remove(categ);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
