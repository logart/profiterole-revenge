package com.exigen.common.service;

import com.exigen.common.domain.Recipe;
import com.exigen.common.domain.Steps;
import com.exigen.common.repository.StepsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StepsServiceImpl implements StepsService {

    /**
     * {@code stepsDao} describes the stepsDao work with DB and Steps entity
     */
    @Autowired
    private StepsDao stepsDao;

    /**
     * {@inheritDoc}
     */

    @Transactional(readOnly =true)
    public List<Steps> getStepsRecipeList(Recipe recipe) {
        return stepsDao.getStepsRecipeList(recipe);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void addStep(Steps step) {
       stepsDao.addStep(step);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void removeStep(Steps step) {
        stepsDao.removeStep(step);
    }

    public void setStepsDao(StepsDao stepsDao){
        this.stepsDao=stepsDao;
    }
}
