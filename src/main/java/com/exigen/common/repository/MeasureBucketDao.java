package com.exigen.common.repository;

import com.exigen.common.domain.MeasuresBucket;

import java.util.List;

/**
 * Interface {@code MeasureBucketDao} used for get, add and remove objects
 * from MeasureBucket entity with helps JPA
 *
 * @author Volodymyr Samokhval
 * @date Mart 3,2013
 */
public interface MeasureBucketDao {

    /**
     * {@method getMeasureBucketByIngredientIdMeasureId(Integer ingredientId, Integer measureId)}
     *
     * @param ingredientId Id of ingredient
     * @param measureId    Id of measure
     * @return the object  of MeasuresBucket).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when ingredientId is null, when measureId is null, or has no results in the database)
     */
    MeasuresBucket getMeasureBucketByIngredientIdMeasureId(Integer ingredientId, Integer measureId);

    /**
     * {@method getMeasuresBucketListByIngredientId(Integer ingredientId)}
     *
     * @param ingredientId
     * @return the list of object of MeasuresBucket, where Ingredient entity =@param).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when ingredientId is null, or has no results in the database)
     */
    List<MeasuresBucket> getMeasuresBucketListByIngredientId(Integer ingredientId);

    /**
     * {@method getMeasuresBucketListByMeasureId(Integer measureId)}
     *
     * @param measureId
     * @return the list of object of MeasuresBucket, where Measure entity =@param).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measureId is null, or has no results in the database)
     */
    List<MeasuresBucket> getMeasuresBucketListByMeasureId(Integer measureId);

    /**
     * {@method addMeasuresBucket(MeasuresBucket measuresBucket)}
     * add the object of MeasuresBucket for DB.
     *
     * @param measuresBucket
     */
    void addMeasuresBucket(MeasuresBucket measuresBucket);

    /**
     * {@method removeMeasuresBucket(MeasuresBucket measuresBucket)}
     * remove the object of MeasuresBucket from DB.
     *
     * @param measuresBucket
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when has no results in the database)
     */
    void removeMeasuresBucket(MeasuresBucket measuresBucket);
}
