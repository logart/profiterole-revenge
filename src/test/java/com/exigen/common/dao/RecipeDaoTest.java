package com.exigen.common.dao;

import com.exigen.common.domain.Categories;
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

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testInMemory.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class RecipeDaoTest {

    @Autowired
    private RecipeDao recipeDao;
    @Autowired
    private CuisineDao cuisineDao;
    @Autowired
    private CategoriesDao categoriesDao;

    private Recipe recipe;
    private Recipe RecipeForId;
    private Cuisine cuisine;
    private Categories categories;
    private Integer id=0;

    @Before
    public void setup(){
        cuisine=new Cuisine("cuisin","link");
        categories=new Categories("category");
        categoriesDao.addCategories(categories);
        cuisineDao.addCuisine(cuisine);
        recipe=new Recipe("title","desc",cuisine,categories,"link1","link2",4);
    }


    @Test
    public void getRecipeTest(){
        Assert.assertEquals(null,recipeDao.getOneRecipe(0));
    }

    @Test
    public void addRecipeTest(){
        recipeDao.addRecipe(recipe);
        List<Recipe> recipeList=recipeDao.getRecipeCuisineList(cuisine);
        RecipeForId=recipeList.get(0);
        id=recipe.getRecipeId();
        Assert.assertEquals(recipe,recipeDao.getOneRecipe(id));
    }

    @Test
    public void removeRecipeTest(){
        recipeDao.removeRecipe(recipe);
        Assert.assertNull(recipeDao.getOneRecipe(id));
    }

}
