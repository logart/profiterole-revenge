package com.exigen.common.repository;

import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class {@code CuisineDao} used for get, add and remove objects
 * from Cuisine entity with helps JPA
 *
 * @author Sergey
 * @date June 17,2012
 */
@Repository("cuisineDao")

public class CuisineDaoImpl implements CuisineDao {
    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@method getCuisine()}
     *
     * @return the list of all cuisines, when it situated in Cuisine entity
     * @throws org.springframework.dao.DataAccessException(resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    public List<Cuisine> getCuisine() {
        List<Cuisine> results = this.entityManager.createQuery("select t from Cuisine t ")
                .getResultList();
        return results;
    }

    /**
     * {@method getOneCuisineList(Cuisine cuis)}
     *
     * @return the list of recipes, when it situated in this Cuisine.
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuis is null, or parameter cuis is does not match
     *                                   no one object in database)
     */
    @Override
    public List<Recipe> getOneCuisineList(Integer cuis) {
        List<Recipe> results = this.entityManager.createQuery("select t from Recipe t where t.cuisine.cuisineId=:selectedCuis")
                .setParameter("selectedCuis", cuis)
                .getResultList();
        return results;
    }

    /**
     * {@method addCuisine(Cuisine cuisine)}
     * for add info about our cuisines into DB
     *
     * @param cuisine(object of some particular cuisine)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null)
     */
    @Override
    public void addCuisine(Cuisine cuisine) {
        entityManager.persist(cuisine);
    }

    /**
     * {@method removeCuisine(Cuisine cuisine)}
     * for remove our cuisines from DB
     *
     * @param cuisine(object of some particular cuisine)
     * @throws org.springframework.dao.DataAccessException(resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException(when cuisine is null)
     */
    @Override
    public void removeCuisine(Cuisine cuisine) {
        entityManager.remove(cuisine);
    }

    /**
     * {@method setEntityManager(EntityManager entityManager)}
     * for tests in DAO. Inject EM in this class
     */

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}