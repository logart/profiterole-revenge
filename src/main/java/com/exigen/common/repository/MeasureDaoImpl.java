package com.exigen.common.repository;

import com.exigen.common.domain.Measure;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Interface {@code MeasureDao} used for get, add and remove objects
 * from Measure entity with helps JPA
 *
 * @author Volodymyr Samokhval
 * @date Mart 3,2013
 */

@Repository("MeasureDao")
public class MeasureDaoImpl implements MeasureDao{

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@method getAllMeasure() }
     *
     * @return the list of  all object of Measures.
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when has no results in the database)
     */
    @Override
    public List<Measure> getAllMeasure() {
        return this.entityManager.createQuery("select m from measures m").getResultList();
    }

    /**
     * {@method getMeasuresById(Integer measureId)}
     *
     * @param measureId
     * @return the  object of Measures, where Id =@param).
     * @throws org.springframework.dao.DataAccessException
     *                              (resource
     *                              on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when measureId is null, or has no results in the database)
     */
    @Override
    public Measure getMeasureById(Integer measureId) {
        return entityManager.find(Measure.class, measureId);
    }

    /**
     * {@method addMeasure(Measure measure)}
     * add the object of Measure for DB.
     *
     * @param measure
     */
    @Override
    public void addMeasure(Measure measure) {
        entityManager.persist(measure);
    }

    /**
     * {@method removeMeasure(Measure measure)}
     * remove the object of Measure from DB.
     *
     * @param measure
     */
    @Override
    public void removeMeasure(Measure measure) {
        entityManager.remove(measure);
    }
}
