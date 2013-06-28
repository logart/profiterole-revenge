package com.exigen.common.service;

/**
 * Class {@code IngredientTypeService} used for get, add and remove objects
 * from IngredientType entity with helps SpringTransaction JPA
 * @author Victoria Ganzha
 * @date  20.06.13
 *
 */

import com.exigen.common.domain.IngredientType;

import com.exigen.common.repository.IngredientTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ingredientTypeService")
@Transactional
public class IngredientTypeServiceImpl implements IngredientTypeService {

    /**
     * {@code ingredientTypeDao} describes the IngredientTypeDao work with DB and IngredientType entity
     */
    @Autowired
    private IngredientTypeDao ingredientTypeDao;

    /**
     * {@method getIngredientTypeById(Integer typeId)}
     *
     * @param typeId
     * @return the  object of IngredientType, where Id =@param).
     */
    @Override
    public IngredientType getIngredientTypeById(Integer typeId) {
        return ingredientTypeDao.getIngredientTypeById(typeId);
    }

    /**
     * {@method addIngredientType(IngredientType type)}
     * add the object of IngredientType for DB.
     * @param type
     *
     */
    @Override
    public void addIngredientType(IngredientType type){
        ingredientTypeDao.addIngredientType(type);
    }

    /**
     * {@method removeIngredientType(IngredientType type)}
     * remove the object of IngredientType from DB.
     * @param type
     *
     */
    @Override
    public void removeIngredientType(IngredientType type){
        ingredientTypeDao.removeIngredientType(type);
    }


    public void setIngredientTypeDao(IngredientTypeDao ingredientTypeDao){
        this.ingredientTypeDao = ingredientTypeDao;
    }

}
