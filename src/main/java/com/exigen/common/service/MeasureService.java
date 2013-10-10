package com.exigen.common.service;

import com.exigen.common.domain.Measure;

import java.util.List;

/**
 * Interface {@code MeasureService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Lena
 * @date March 1,2013
 */
public interface MeasureService {
    /**
     * {@method getAllMeasure() }
     *
     *
     * @return the list of  all object of Measures.
     */
    List<Measure> getAllMeasure();
    /**
     * {@method getMeasuresById(Integer measureId)}
     *
     * @param measureId
     * @return the  object of Measures, where Id =@param).
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
