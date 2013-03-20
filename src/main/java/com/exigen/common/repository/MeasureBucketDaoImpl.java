package com.exigen.common.repository;


import com.exigen.common.domain.MeasuresBucket;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Interface {@code MeasureBucketDao} used for get, add and remove objects
 * from MeasureBucket entity with helps JPA
 *
 * @author Volodymyr Samokhval
 * @date Mart 3,2013
 */

@Repository("MeasureBucketDao")
public class MeasureBucketDaoImpl implements MeasureBucketDao {

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@method getMeasureBucketByIngredientIdMeasureId(Integer ingredientId, Integer measureId)}
     *
     * @param ingredientId Id of ingredient
     * @param measureId    Id of measure
     * @return the object  of MeasuresBucket).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when ingredientId is null, when measureId is null,
     *                              or has no results in the database)
     */
    @Override
    public MeasuresBucket getMeasureBucketByIngredientIdMeasureId(Integer ingredientId, Integer measureId) {
        MeasuresBucket result = (MeasuresBucket) this.entityManager.createQuery("SELECT mb FROM MeasuresBucket mb " +
                "WHERE mb.ingredient.id=:selectedIngredient AND mb.measure.id=:selectedMeasure").setParameter
                ("selectedIngredient", ingredientId).setParameter("selectedMeasure", measureId).getSingleResult();
        return result;
    }

    /**
     * {@method getMeasuresBucketListByIngredientId(Integer ingredientId)}
     *
     * @param ingredientId
     * @return the list of object of MeasuresBucket, where Ingredient entity =@param).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when ingredientId is null, or has no results in the database)
     */
    @Override
    public List<MeasuresBucket> getMeasuresBucketListByIngredientId(Integer ingredientId) {
        List<MeasuresBucket> results = this.entityManager.createQuery("SELECT mb FROM MeasuresBucket mb " +
                "WHERE mb.ingredient.id=:selectedIngredient").setParameter("selectedIngredient",
                ingredientId).getResultList();
        return results;
    }

    /**
     * {@method getMeasuresBucketListByMeasureId(Integer measureId)}
     *
     * @param measureId
     * @return the list of object of MeasuresBucket, where Measure entity =@param).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measureId is null, or has no results in the database)
     */
    @Override
    public List<MeasuresBucket> getMeasuresBucketListByMeasureId(Integer measureId) {
        return this.entityManager.createQuery("SELECT mb FROM MeasuresBucket mb " +
                "WHERE mb.ingredient.id=:selectedMeasure").setParameter("selectedMeasure",
                measureId).getResultList();
    }

    /**
     * {@method addMeasuresBucket(MeasuresBucket measuresBucket)}
     * add the object of MeasuresBucket for DB.
     *
     * @param measuresBucket
     */
    @Override
    public void addMeasuresBucket(MeasuresBucket measuresBucket) {
        entityManager.persist(measuresBucket);
    }

    /**
     * {@method removeMeasuresBucket(MeasuresBucket measuresBucket)}
     * remove the object of MeasuresBucket from DB.
     *
     * @param measuresBucket
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when has no results in the database)
     */
    @Override
    public void removeMeasuresBucket(MeasuresBucket measuresBucket) {
        entityManager.remove(measuresBucket);
    }
}
