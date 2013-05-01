package com.exigen.common.dao;


import com.exigen.common.domain.Category;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.repository.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.mockito.Matchers.anyList;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testInMemory.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class SearchDaoImplTest {

    @PersistenceContext
    private EntityManager entityManager;


    private SearchDao searchDao = new SearchDaoImpl();

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private CuisineDao cuisineDao;

    @Autowired
    private CategoriesDao categoriesDao;

    private Recipe recipe;
    private Cuisine cuisine;
    private Category category;


    @Before
    public void setup() {
        cuisine = new Cuisine("cuisin", "link");
        category = new Category("category");
        categoriesDao.addCategories(category);
        cuisineDao.addCuisine(cuisine);
        recipe = new Recipe("title", "description", cuisine, category, "link1", "link2", 4);
    }


    @Test
    public void simpleSearchTest() {

        ReflectionTestUtils.setField(searchDao, "entityManager", entityManager);
        ((SearchDaoImpl)searchDao).doIndexing();

        entityManager.persist(recipe);

        Assert.assertEquals(anyList(), searchDao.searchRecipe("description"));
        Assert.assertEquals(anyList(), searchDao.searchRecipe("title"));
    }

}
