package com.exigen.common.dao;

import com.exigen.common.domain.Category;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.domain.Step;
import com.exigen.common.repository.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testInMemory.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class StepDaoTest {

    @Mock
    private EntityManager entityManager;
    private Step step = new Step(1, "step");
    private List<Step> stepList = new ArrayList<Step>();
    private Cuisine cuisine = new Cuisine("cuisine", "link");
    private Category category = new Category("category");
    private Recipe recipe = new Recipe("title", "description", cuisine, category, "link1", "link2", 4);
    private StepDao stepDao = new StepDaoImpl();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void removeStepsTest() {
        ReflectionTestUtils.setField(stepDao, "entityManager", entityManager);
        stepDao.removeStep(step);
        verify(entityManager, times(1)).remove(step);
    }

    @Test
    public void addStepTest() {
        ReflectionTestUtils.setField(stepDao, "entityManager", entityManager);
        stepDao.addStep(step);
        verify(entityManager, times(1)).persist(step);
    }

}