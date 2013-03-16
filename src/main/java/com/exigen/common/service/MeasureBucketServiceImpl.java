package com.exigen.common.service;

import com.exigen.common.domain.MeasuresBucket;
import com.exigen.common.repository.MeasureBucketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class {@code MeasureBucketServiceImpl} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Elena
 * @date March 4,2013
 */
@Service("measureBucketService")
@Transactional(readOnly = true)
public class MeasureBucketServiceImpl implements MeasureBucketService {
    /**
     * {@code measureBucketDao} describes the MeasureBucketDao for work with
     * DB and MeasureBucket entity
     */
    @Autowired
    private MeasureBucketDao measureBucketDao;

    /**
     * {@method getMeasureBucketByIngredientIdMeasureId(Integer ingredientId,Integer measureId)}
     *
     * @param ingredientId Id of ingredient
     * @param measureId Id of measure
     * @return the object  of MeasuresBucket).
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
   public MeasuresBucket getMeasureBucketByIngredientIdMeasureId(Integer ingredientId,Integer measureId){
        return measureBucketDao.getMeasureBucketByIngredientIdMeasureId(ingredientId, measureId);
    }

    /**
     * {@method getMeasuresBucketListByIngredientId(Integer ingredientId)}
     *
     * @param ingredientId
     * @return the list of object of MeasuresBucket, where Ingredient entity =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
  public   List<MeasuresBucket> getMeasuresBucketListByIngredientId(Integer ingredientId){
      return measureBucketDao.getMeasuresBucketListByIngredientId(ingredientId);
  }

    /**
     * {@method getMeasuresBucketListByMeasureId(Integer measureId)}
     *
     * @param measureId
     * @return the list of object of MeasuresBucket, where Measure entity =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    public List<MeasuresBucket> getMeasuresBucketListByMeasureId(Integer measureId){
        return measureBucketDao.getMeasuresBucketListByMeasureId(measureId);
    }

    /**
     * {@method addMeasuresBucket(MeasuresBucket measuresBucket)}
     * add the object of MeasuresBucket for DB.
     * @param measuresBucket
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measuresBucket is null)
     *
     */
    @Override
    public void addMeasuresBucket(MeasuresBucket measuresBucket){
        measureBucketDao.addMeasuresBucket(measuresBucket);
    }

    /**
     * {@method removeMeasuresBucket(MeasuresBucket measuresBucket)}
     * remove the object of MeasuresBucket from DB.
     * @param measuresBucket
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measuresBucket is null)
     */
    @Override
    public void removeMeasuresBucket(MeasuresBucket measuresBucket){
        measureBucketDao.removeMeasuresBucket(measuresBucket);
    }
    /**
     * {@method setMeasureBucketDao(MeasureBucketDao measureBucketDao)}
     * set  MeasureBucketDao
     *
     * @param measureBucketDao (object of MeasureBucketDao)
     */
    public void setMeasuresBucketDao(MeasureBucketDao measureBucketDao) {
        this.measureBucketDao = measureBucketDao;
    }
}
