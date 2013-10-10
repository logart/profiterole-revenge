package com.exigen.common.repository;

import com.exigen.common.domain.IngredientType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Class {@code IngredientType} used for get, add and remove objects
 * from IngredientType entity with helps JPA
 * @author Victoria Ganzha
 * @date  20.06.13
 *
 */
@Repository("ingredientTypeDao")
public class IngredientTypeDaoImpl implements IngredientTypeDao{

    /**
     * {@code entityManager} describes the EntityManager for JPA ORM
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public IngredientType getIngredientTypeById(Integer typeId) {
        return this.entityManager.find(IngredientType.class, typeId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addIngredientType(IngredientType type){
        entityManager.persist(type);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeIngredientType(IngredientType type){
        entityManager.remove(type);
    }



}

