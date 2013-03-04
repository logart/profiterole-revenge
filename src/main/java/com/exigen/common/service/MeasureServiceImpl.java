package com.exigen.common.service;

import com.exigen.common.domain.Measure;
import com.exigen.common.repository.MeasureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* Class {@code MeasureServiceImpl} used for push object from and in DAO for get, add and
* remove objects into DB with helps SpringTransaction and JPA
*
* @author Elena
* @date March 4,2013
*/
@Service("measureService")
@Transactional(readOnly = true)
public class MeasureServiceImpl implements MeasureService {
    /**
     * {@code measureDao} describes the MeasureBucketDao for work with
     * DB and Measure entity
     */
    @Autowired
    private MeasureDao measureDao;


    /**
     * {@method getAllMeasure() }
     * @return the list of  all object of Measures.      *
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    public List<Measure> getAllMeasure() {
        return measureDao.getAllMeasure();
    }

    /**
     * {@method getMeasuresById(Integer measureId)}
     * @param measureId
     * @return the  object of Measures, where Id =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     */
    @Override
    public Measure getMeasureById(Integer measureId) {
        return measureDao.getMeasureById(measureId);
    }

    /**
     * {@method addMeasure(Measure measure)}
     * add the object of Measure for DB.
     * @param measure
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measure is null)
     */
    @Override
    public void addMeasure(Measure measure) {
        measureDao.addMeasure(measure);
    }

    /**
     * {@method removeMeasure(Measure measure)}
     * remove the object of Measure from DB.
     *
     * @param measure
     * @throws org.springframework.dao.DataAccessException (resource
     *          on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measure is null)
     */
    @Override
    public void removeMeasure(Measure measure) {
        measureDao.removeMeasure(measure);
    }
    /**
     * {@method setMeasureDao(MeasureDao measureDao)}
     * set  MeasureDao
     *
     * @param measureDao (object of MeasureDao)
     */
    public void setMeasureDao(MeasureDao measureDao) {
        this.measureDao = measureDao;
    }
}
