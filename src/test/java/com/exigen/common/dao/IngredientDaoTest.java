package com.exigen.common.dao;


import com.exigen.common.domain.*;
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
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testInMemory.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class IngredientDaoTest {
    @Mock
    private EntityManager entityManager;

    @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private CuisineDao cuisineDao;

    @Autowired
    private CategoriesDao categoriesDao;

    @Autowired
    private RecipeDao recipeDao;

    private Ingredient ingredient;
    private Recipe recipe;
    private Cuisine cuisine;
    private Category category;
    private Integer recipeId;
    private List<Recipe> recipeList;
    private List<Ingredient> ingredientList;


    @Before
    public void setup() {
        cuisine = new Cuisine("cuisin", "link");
        cuisineDao.addCuisine(cuisine);
        category = new Category("category");

        categoriesDao.addCategories(category);

        recipe = new Recipe("title", "desc", cuisine, category, "link1", "link2", 4);
        recipeDao.addRecipe(recipe);

        IngredientType type_t1 = new IngredientType("молочные продукты");
        List <IngredientType> listOfTypes = new ArrayList<IngredientType>(Arrays.asList(type_t1));
        ingredient = new Ingredient("name", 5, listOfTypes.get(0));
        ingredientList = new ArrayList<Ingredient>();
        recipeList = new ArrayList<Recipe>();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public  void testGetAllIngridients(){
        Assert.assertNotNull(ingredientDao.getAllIngredients());
    }

    @Test
    public void removeIngredientTest() {
        ingredientDao = new IngredientDaoImpl();
        ReflectionTestUtils.setField(ingredientDao, "entityManager", entityManager);
        ingredientDao.removeIngredient(ingredient);
        verify(entityManager, times(1)).remove(ingredient);
    }

    @Test
    public void addIngredientTest() {
        ingredientDao = new IngredientDaoImpl();
        ReflectionTestUtils.setField(ingredientDao, "entityManager", entityManager);
        ingredientDao.addIngredient(ingredient);
        verify(entityManager, times(1)).persist(ingredient);
    }
}