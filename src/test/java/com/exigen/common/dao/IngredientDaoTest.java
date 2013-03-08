package com.exigen.common.dao;


import com.exigen.common.domain.Category;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Ingredient;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.CategoriesDao;
import com.exigen.common.repository.CuisineDao;
import com.exigen.common.repository.IngredientDao;
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
public class IngredientDaoTest {

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
        ingredient = new Ingredient("name", 5);
        ingredientList = new ArrayList<Ingredient>();
        recipeList = new ArrayList<Recipe>();
    }

    //@Test
    //public void addAndGetIngridientsTest() {
    //    recipeList = recipeDao.getRecipeCuisineList(cuisine);
    //    recipe = recipeList.get(0);
    //    recipeId = recipe.getId();
    //    ingredientList.add(ingredient);
    //    ingredientDao.addIngredient(ingredient);
    //    Assert.assertEquals(ingredientList, ingredientDao.getIngredientById(recipeId));

    //}

    @Test
    public void removeIngridientsTest() {
        ingredientDao.removeIngredient(ingredient);


        Assert.assertEquals(ingredient, ingredientDao.getIngredientById(recipeId));
    }

    @Test
    public  void testGetAllIngridients(){
        Assert.assertNotNull(ingredientDao.getAllIngredients());
    }

}