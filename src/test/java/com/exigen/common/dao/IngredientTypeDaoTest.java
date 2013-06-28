package com.exigen.common.dao;

import com.exigen.common.domain.IngredientType;
import com.exigen.common.repository.IngredientTypeDao;
import com.exigen.common.repository.IngredientTypeDaoImpl;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testInMemory.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class IngredientTypeDaoTest {
    @Mock
    private EntityManager entityManager;
    @Autowired
    private IngredientTypeDao ingredientTypeDao;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addIngredientTypeTest(){
    ingredientTypeDao = new IngredientTypeDaoImpl();
    ReflectionTestUtils.setField(ingredientTypeDao, "entityManager", entityManager);
        IngredientType type = new IngredientType("молочные продукты");
    ingredientTypeDao.addIngredientType(type);
    verify(entityManager, times(1)).persist(type);
    }

    @Test
    public void removeIngredientTypeTest(){
        ingredientTypeDao = new IngredientTypeDaoImpl();
        ReflectionTestUtils.setField(ingredientTypeDao,"entityManager", entityManager);
        IngredientType type = new IngredientType("молочные продукты");
        ingredientTypeDao.removeIngredientType(type);
        verify(entityManager,times(1)).remove(type);

    }

}
