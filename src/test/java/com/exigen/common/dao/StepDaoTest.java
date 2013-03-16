package com.exigen.common.dao;

import com.exigen.common.domain.Category;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.domain.Step;
import com.exigen.common.repository.CategoriesDao;
import com.exigen.common.repository.CuisineDao;
import com.exigen.common.repository.RecipeDao;
import com.exigen.common.repository.StepDao;
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
public class StepDaoTest {

    @Autowired
    private CuisineDao cuisineDao;

    @Autowired
    private CategoriesDao categoriesDao;

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private StepDao stepDao;

    private Recipe recipe;
    private Cuisine cuisine;
    private Category category;
    private Step step;
    private Integer recipeId;
    private List<Recipe> recipeList;
    private List<Step> stepList;


    @Before
    public void setup() {
        cuisine = new Cuisine("cuisin", "link");
        cuisineDao.addCuisine(cuisine);
        category = new Category("category");

        categoriesDao.addCategories(category);

        recipe = new Recipe("title", "desc", cuisine, category, "link1", "link2", 4);
        recipeDao.addRecipe(recipe);
        step = new Step(1, "step");
        stepDao.addStep(step);
        stepList = new ArrayList<Step>();
        recipeList = new ArrayList<Recipe>();
    }

    @Test
    public void addAndGetStepsTest() {
        recipeList = recipeDao.getRecipeCuisineList(cuisine);
        recipe = recipeList.get(0);
        recipeId = recipe.getId();

        stepList.add(step);
        Assert.assertEquals(stepList, stepDao.getListOfRecipeSteps(recipeId));
    }

    @Test
    public void removeStepsTest() {
        stepDao.removeStep(step);
        Assert.assertEquals(stepList, stepDao.getListOfRecipeSteps(recipeId));
    }

}