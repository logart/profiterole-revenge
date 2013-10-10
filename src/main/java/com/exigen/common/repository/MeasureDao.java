package com.exigen.common.repository;

import com.exigen.common.domain.Measure;

import java.util.List;

/**
 * Interface {@code MeasureDao} used for get, add and remove objects
 * from Measure entity with helps JPA
 *
 * @author Volodymyr Samokhval
 * @date Mart 3,2013
 */
public interface MeasureDao {

    /**
     * {@method getAllMeasure() }
     *
     * @return the list of  all object of Measures.
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when has no results in the database)
     *
     */
    List<Measure> getAllMeasure();

    /**
     * {@method getMeasuresById(Integer measureId)}
     *
     * @param measureId
     * @return the  object of Measures, where Id =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measureId is null, or has no results in the database)
     */
    Measure getMeasureById(Integer measureId);

    /**
     * {@method addMeasure(Measure measure)}
     * add the object of Measure for DB.
     * @param measure
     *
     */
    void addMeasure(Measure measure);

    /**
     * {@method removeMeasure(Measure measure)}
     * remove the object of Measure from DB.
     * @param measure
     *
     */
    void removeMeasure(Measure measure);
}
