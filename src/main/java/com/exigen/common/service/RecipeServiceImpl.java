package com.exigen.common.service;

import com.exigen.common.domain.*;
import com.exigen.common.repository.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * Class {@code RecipeService} used for push object from and in DAO for get, add and
 * remove objects into DB with helps SpringTransaction and JPA
 *
 * @author Sergey
 * @date July 17,2012
 */

@Transactional(readOnly = true)
public class RecipeServiceImpl implements RecipeService {

    /**
     * {@code recipeDao} describes the RecipeDao work with DB and Recipe entity
     */
    @Autowired
    private RecipeDao recipeDao;

    /**
     * {@code CATEGORY_1} describes the first category
     */
    private static final int CATEGORY_1 = 1;

    /**
     * {@code CATEGORY_1} describes the fourth category
     */
    private static final int CATEGORY_4 = 4;
    /**
     * {@code portion} describes the ArrayList<Integer> with portion of Recipe
     */
    @Resource
    private List<Integer> portion;

    /**
     * {@code markers} describes the LinkedHashMap<String, String> with names and pictures of markers
     */
    @Resource
    private Map<String,String> markers;

    /**
     * {@code MASK_AND} describes the const
     */
    private static final int MASK_AND = 1;

    /**
     * {@code S_RIGHT} describes the number of digits to the right shift
     */
    private static final int S_RIGHT = 1;
    /**
     * {@method getRecipeCuisineList(Cuisine cuisine)}
     *
     * @param cuisine (object of some particular recipe)
     * @return the list of recipes, where cuisine ikn Recipe entity =@param).
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when cuisine is null, or id has no results in the database)
     */
    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getRecipeCuisineList(Cuisine cuisine) {
        return recipeDao.getRecipeCuisineList(cuisine);
    }

    /**
     * {@method getOneRecipeList(Integer recipeId)}
     *
     * @param recipeId (unique identificator of some particular recipe)
     * @return the recipe, where Recipe field recipeId equals parameter recipeId( return complete description
     *         of the recipe with the steps, ingredients, Pictures.).
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipeId is null, or id has no results in the database)
     */

    @Override
    @Transactional(readOnly = true)
    public Recipe getOneRecipe(Integer recipeId) {
        return recipeDao.getOneRecipe(recipeId);

    }

    /**
     * {@method addRecipe(Recipe recipe)}
     * for adding information about some particular recipe into DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipe is null)
     */
    @Transactional
    public void addRecipe(Recipe recipe) {
        recipeDao.addRecipe(recipe);
    }

    /**
     * {@method removeRecipe(Recipe recipe)}
     * for remove some particular recipe from DB
     *
     * @param recipe (object of some particular recipe)
     * @throws org.springframework.dao.DataAccessException (resource
     *                                   on cloudfoundry is unavalible, DB is changed)
     * @throws NullPointerException (when recipe is null)
     */
    @Transactional
    public void removeRecipe(Recipe recipe) {
        recipeDao.removeRecipe(recipe);
    }

    /**
     * {@method setRecipeDao(RecipeDao recipeDao)}
     * for tests services. Inject in this class
     */

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    /**
     * {@method setPortion(ArrayList<Integer> portion)}
     * for initialized from bean. Inject in this class
     */
    public void setPortion(List<Integer> portion) {
        this.portion = portion;
    }

    /**
     * {@method setMarkers(Map<String,String> markers)}
     * for tests services. Inject in this class
     */
    public void setMarkers(Map<String,String> markers) {
        this.markers = markers;
    }

    /**
     * {@method getMarkersOfRecipe(Recipe recipe)}
     * for adding information about markers of recipe
     *
     * @param recipe (object of some particular recipe)
     *
     * @return the map of markers
     *
     */
      public Map<String,String> getMarkersOfRecipe(Recipe recipe){
        int marker = recipe.getMarkers();
        int z;
        Iterator<Map.Entry<String, String>> itr1 = markers.entrySet().iterator();
        Map<String,String> stringMap =new LinkedHashMap<String, String>();
       int i=markers.size();
        for(int j=0; j<=i-1; j++){
            z= marker&MASK_AND;
            marker=  (marker>>S_RIGHT);
            Map.Entry<String, String> entry = itr1.next();
            if (z==1){
                stringMap.put(entry.getKey(),entry.getValue());
            }
        }
        return stringMap;
    }

    /**
     * {@method getListRecipesWithMarkersAndPortion(List<Recipe> recipeList)}
     * for adding information about markers of list of recipe
     *
     * @param recipeList (object list of some particular recipe)
     *
     * @return the list of the object of RecipeWithMarkers
     *
     */
    public List<RecipeWithMarkers> getListRecipesWithMarkersAndPortion(List<Recipe> recipeList){
        List<RecipeWithMarkers> recipesWithMarkers = new ArrayList<RecipeWithMarkers>();
        for(Recipe recipe: recipeList){
            if (recipe.getCategory().getId() == CATEGORY_1 || recipe.getCategory().getId() == CATEGORY_4 ){
                recipe.setValueOfPortion(portion.get(0));
            } else {
                recipe.setValueOfPortion(portion.get(1));
            }
            RecipeWithMarkers recipeWithMarkers = new RecipeWithMarkers();
            recipeWithMarkers.setRecipe(recipe);
            recipeWithMarkers.setMarkers(getMarkersOfRecipe(recipe));
            recipesWithMarkers.add(recipeWithMarkers);
        }
        return recipesWithMarkers;
    }

    /**
     * {@method getListOfMarkersNames()}
     * for get information about names of markers
     *
     * @return the list of names of markers
     *
     */
    public List<String> getListOfMarkersNames(){
        List<String> listMarkersNames = new ArrayList<String>();
        Iterator<Map.Entry<String, String>> itr1 = markers.entrySet().iterator();
        int i=markers.size();
        for(int j=0; j<=i-1; j++){
            Map.Entry<String, String> entry = itr1.next();
            listMarkersNames.add(entry.getKey());
        }
        return listMarkersNames;
    }
}