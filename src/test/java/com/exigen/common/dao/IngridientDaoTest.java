package com.exigen.common.dao;


import com.exigen.common.domain.Categories;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Ingridient;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.CategoriesDao;
import com.exigen.common.repository.CuisineDao;
import com.exigen.common.repository.IngridientDao;
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
public class IngridientDaoTest {

    @Autowired
    private IngridientDao ingridientDao;

    @Autowired
    private CuisineDao cuisineDao;

    @Autowired
    private CategoriesDao categoriesDao;

    @Autowired
    private RecipeDao recipeDao;


    private Ingridient ingridient;
    private Recipe recipe;
    private Cuisine cuisine;
    private Categories categories;
    private Integer recipeId;
    private List<Recipe> recipeList;
    private List<Ingridient> ingridientList;

    @Before
    public void setup(){
        cuisine=new Cuisine("cuisin","link");
        cuisineDao.addCuisine(cuisine);
        categories=new Categories("category");

        categoriesDao.addCategories(categories);

        recipe=new Recipe("title","desc",cuisine,categories,"link1","link2",4);
        recipeDao.addRecipe(recipe);
        ingridient = new Ingridient("name",5, 12,"unit",recipe);
        ingridientList=new ArrayList<Ingridient>();
        recipeList=new ArrayList<Recipe>();
    }

    @Test
    public void addAndGetIngridientsTest(){
        recipeList=recipeDao.getRecipeCuisineList(cuisine);
        recipe=recipeList.get(0);
        recipeId=recipe.getRecipeId();
        ingridientList.add(ingridient);
        ingridientDao.addIngridient(ingridient);
        Assert.assertEquals(ingridientList,ingridientDao.getIngridientsRecipeList(recipeId));

    }

    @Test
    public void removeIngridientsTest(){
        ingridientDao.removeIngridient(ingridient);



        Assert.assertEquals(ingridientList,ingridientDao.getIngridientsRecipeList(recipeId));
    }

}
