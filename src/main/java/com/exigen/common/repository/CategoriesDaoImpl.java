package com.exigen.common.repository;

import com.exigen.common.domain.Categories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class {@code CategoriesDao} used for get, add and remove objects
 * from Categories entity with helps JPA
 *
 * @author Sergey
 * @date July 17,2012
 */

@Repository("categoriesDao")

public class CategoriesDaoImpl implements CategoriesDao {
    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@method getCategories()}
     *
     * @return the list of all categories, when it situated in Categories entity
     * @throws org.springframework.dao.DataAccessException(resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    public List<Categories> getCategories() {
        List<Categories> results = this.entityManager.createQuery("select t from Categories t")
                .getResultList();
        return results;
    }

    /**
     * {@method addCategories(Categories categ)}
     * for add info about our categories of recipes into DB
     *
     * @param categ(object of some particular category)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when categ is null)
     */
    @Override
    public void addCategories(Categories categ) {

        entityManager.persist(categ);
    }
    /**
     * {@method removeCategories(Categories categories)}
     * for remove our categories of recipes from DB
     *
     * @param categ(object of some particular category)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when categ is null)
     */
    @Override
    public void removeCategories(Categories categ) {
        entityManager.remove(categ);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
