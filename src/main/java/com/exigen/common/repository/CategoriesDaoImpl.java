package com.exigen.common.repository;

import com.exigen.common.domain.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class {@code CategoriesDao} used for get, add and remove objects
 * from Category entity with helps JPA
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
     * {@method getCategory()}
     *
     * @return the list of all categories, when it situated in Category entity
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    public List<Category> getCategories() {
        List<Category> results = this.entityManager.createQuery("select t from categories t")
                .getResultList();
        return results;
    }

    /**
     * {@method getCategory(Integer id)}
     * @param id(ID of category)
     * @return the categorie with id specified in the passed parameter.
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    public Category getCategory(Integer id) {
        return this.entityManager.find(Category.class, id);
    }

    /**
     * {@method addCategories(Category categ)}
     * for add info about our categories of recipes into DB
     *
     * @param category(object of some particular category)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when categ is null)
     */
    @Override
    public void addCategories(Category category) {

        entityManager.persist(category);
    }

    /**
     * {@method removeCategories(Category categories)}
     * for remove our categories of recipes from DB
     *
     * @param category(object of some particular category)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when categ is null)
     */
    @Override
    public void removeCategories(Category category) {
        entityManager.remove(category);
    }

    /**
     * {@method setEntityManager(EntityManager entityManager)}
     * for tests in DAO. Inject EM in this class
     */

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}