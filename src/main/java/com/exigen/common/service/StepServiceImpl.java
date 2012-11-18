package com.exigen.common.service;

import com.exigen.common.domain.Step;
import com.exigen.common.repository.StepDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StepServiceImpl implements StepService {

    /**
     * {@code stepsDao} describes the stepsDao work with DB and Steps entity
     */
    @Autowired
    private StepDao stepDao;

    /**
     * {@inheritDoc}
     */

    @Transactional(readOnly = true)
    public List<Step> getListOfRecipeSteps(Integer recipeId) {
        return stepDao.getListOfRecipeSteps(recipeId);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void addStep(Step step) {
        stepDao.addStep(step);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void removeStep(Step step) {
        stepDao.removeStep(step);
    }

    public void setStepDao(StepDao stepDao) {
        this.stepDao = stepDao;
    }
}
