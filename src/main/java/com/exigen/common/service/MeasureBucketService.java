package com.exigen.common.service;

import com.exigen.common.domain.MeasuresBucket;

import java.util.List;
import java.util.Map;

/**
 * Interface {@code MeasureBucketService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Lena
 * @date March 1,2013
 */
public interface MeasureBucketService {

    /**
     * {@method getMeasureBucketByIngredientIdMeasureId(Integer ingredientId,Integer measureId)}
     *
     * @param ingredientId Id of ingredient
     * @param measureId Id of measure
     * @return the object  of MeasuresBucket).
     */
    MeasuresBucket getMeasureBucketByIngredientIdMeasureId(Integer ingredientId,Integer measureId);

    /**
     * {@method getMeasuresBucketListByIngredientId(Integer ingredientId)}
     *
     * @param ingredientId
     * @return the list of object of MeasuresBucket, where Ingredient entity =@param).
     */
    List<MeasuresBucket> getMeasuresBucketListByIngredientId(Integer ingredientId);

    /**
     * {@method getMeasuresBucketMapByIngredientId(Integer ingredientId)}
     *
     * @param ingredientId
     * @return the map where value ia a name of MeasuresBucket, and key is id.aIngredient entity =@param).
     */
    Map<Integer, String[]> getMeasuresBucketMapByIngredientId(Integer ingredientId);

    /**
     * {@method getMeasuresBucketListByMeasureId(Integer measureId)}
     *
     * @param measureId
     * @return the list of object of MeasuresBucket, where Measure entity =@param).
     */
    List<MeasuresBucket> getMeasuresBucketListByMeasureId(Integer measureId);

    /**
     * {@method getMeasuresBucketListById(Integer measureBucketId)}
     *
     * @param measureBucketId
     * @return the object of MeasuresBucket, where MeasuresBucket id =@param).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measureBucketId is null, or has no results in the database)
     */
    MeasuresBucket getMeasuresBucketListById(Integer measureBucketId);

    /**
     * {@method addMeasuresBucket(MeasuresBucket measuresBucket)}
     * add the object of MeasuresBucket for DB.
     * @param measuresBucket
     *
     */
    void addMeasuresBucket(MeasuresBucket measuresBucket);

    /**
     * {@method removeMeasuresBucket(MeasuresBucket measuresBucket)}
     * remove the object of MeasuresBucket from DB.
     * @param measuresBucket
     *
     */
    void removeMeasuresBucket(MeasuresBucket measuresBucket);
}
