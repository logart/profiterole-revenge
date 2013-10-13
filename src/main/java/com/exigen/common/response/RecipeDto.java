package com.exigen.common.response;

import com.exigen.common.domain.Category;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.IngredientBucket;
import com.exigen.common.domain.Step;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class RecipeDto implements PrintDto {

    /**
     * {@code id} its a primary key for this entity
    */
    private Integer id;

    /**
    * {@code title} describes name of recipe in this entity. Its showed in our views
    */
    private String title;

    /**
    * {@code description} this field is intended to describe the recipe
    */
    private String description;

    /**
    * {@code cuisine} This field is a reference to the Cuisine entity
     */
    private Cuisine cuisine;

    /**
    * {@code category} This field is a reference to the Category entity
    */
    private Category category;

    /**
    * {@code bigImg} This field to save reference on image for recipe
    */
    private String bigImage;

    /**
    * {@code smallImg} This field to save reference on image(small) for recipe
    */
    private String smallImage;

    /**
    * {@code time} This field to save time of creation for recipe
    */
    private Integer timeOfCooking;

    /**
    * {@code complexity} This field to save complexity of recipe
     */
    private String complexity;

    /**
    * {@code quantityOfDish} This field to save quantity of dish of creation for recipe
     */
    private Integer quantityOfDish;

    /**
     * {@code markers} This field to save markers ("острый", "вегетарианский", "от шеф-повара")
    */
    private Byte markers;

    /**
    * {@code ingredients} it's list of ingredient's buckets in recipe.
    */
    private List<IngredientBucket> ingredients = new ArrayList<IngredientBucket>();

    /**
    * {@code steps} it's list of steps in recipe.
    */
    private List<Step> steps = new ArrayList<Step>();

    /**
     * {@method Recipe} its a default constructor for JPA
     */

    public RecipeDto() {
    }

    /**
     * {@methods } below its a getters and setters
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public Integer getTimeOfCooking() {
        return timeOfCooking;
    }

    public void setTimeOfCooking(Integer timeOfCooking) {
        this.timeOfCooking = timeOfCooking;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String compexity) {
        this.complexity = compexity;
    }

    public List<IngredientBucket> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientBucket> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getQuantityOfDish() {
        return quantityOfDish;
    }

    public void setQuantityOfDish(Integer quantityOfDish) {
        this.quantityOfDish = quantityOfDish;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }


    public Byte getMarkers() {
        return markers;
    }

    public void setMarkers(Byte markers) {
        this.markers = markers;
    }

}