package com.exigen.common.dao;

import com.exigen.common.domain.Category;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.CategoriesDao;
import com.exigen.common.repository.CuisineDao;
import com.exigen.common.repository.RecipeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testInMemory.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class CuisineDaoTest {
//
//
//    @Autowired
//    private CuisineDao cuisineDao;
//    @Autowired
//    private RecipeDao recipeDao;
//    @Autowired
//    private CategoriesDao categoriesDao;
//
//    private Cuisine testCuisine;
//
//    private Category testCategory;
//
//    private Recipe testRecipe=new Recipe("title","desc",testCuisine, testCategory,"bigimg","smalling",5,5);
//
//    private List<Recipe> recipes=new ArrayList<Recipe>();
//
//    @Before
//    public void setup() {
//        testCuisine = new Cuisine("test", "test");
//        testCategory =new Category("categ");
//
//    }
//
//
//    @Test
//    public void addCuisineTest() {
//
//
//        cuisineDao.addCuisine(testCuisine);
//        Assert.assertEquals(testCuisine, cuisineDao.getCuisine().get(0));
//    }
//
//
//    @Test
//    public void getCategoriesTest() {
//        Assert.assertNotNull(cuisineDao.getCuisine());
//    }
//
//    @Test
//    public void getOneCuisineListTest(){
//        categoriesDao.addCategories(testCategory);
//        cuisineDao.addCuisine(testCuisine);
//        testRecipe.setCategory(testCategory);
//        testRecipe.setCuisine(testCuisine);
//        recipeDao.addRecipe(testRecipe);
//        recipes.add(testRecipe);
//        testCuisine.setRecipes(recipes);
//        cuisineDao.addCuisine(testCuisine);
//        Assert.assertNull(recipeDao.getOneRecipe(testCuisine.getCuisineId()));
//
//
//    }

}