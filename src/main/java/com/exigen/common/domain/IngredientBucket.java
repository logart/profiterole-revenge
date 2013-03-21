package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@code IngredientBucket} is an entity what describe how many of some ingredient
 * contains the recipe
 *
 * @author Tony Soprano
 * @date Feb 26, 2013
 */
@Entity
@Table(name = "ingredientsBucket")
public class IngredientBucket implements Serializable {

    /**
     * {@code id} its a primary key for this entity
     */
    @Id
    @GeneratedValue
    private Integer  id;

    /**
     * {@code ingredient} this field contains ingredient
     */
    @ManyToOne
    @JoinColumn(name = "ingredientId", nullable = false)
    private Ingredient ingredient;

    /**
     * {@code countOfIngridient} this field to describe quantity of particular ingredient
     * in some recipe
     */
    private Float countOfIngredient;

    /**
     * {@code unitOfMeasure} this field contains the unit of measure
     * of particular ingredient in this entity.
     */
    @ManyToOne
    @JoinColumn(name = "measureBucketId", nullable = false)
//    private Measure measure;
      private MeasuresBucket   measuresBucket;
    /**
     * {@code recipe} this field contains recipe, what have got
     * this ingredient
     */
    @ManyToOne
    @JoinColumn(name = "recipeId", nullable = false)
    private Recipe recipe;

    /**
     * {@methods IngredientBucket} this are constructors of this class
     */
    public IngredientBucket() {

    }

 /*   public IngredientBucket(Ingredient ingredient, float countOfIngredient, Measure measure, Recipe recipe) {
        this.ingredient = ingredient;
        this.countOfIngredient = countOfIngredient;
        this.measure = measure;
        this.recipe = recipe;
    }
 */

    public IngredientBucket(Ingredient ingredient, float countOfIngredient, MeasuresBucket measuresBucket, Recipe recipe) {
        this.ingredient = ingredient;
        this.countOfIngredient = countOfIngredient;
        this.measuresBucket = measuresBucket;
        this.recipe = recipe;
    }

    /**
     * {@methods } below its a getters and setters
     */
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Float getCountOfIngredient() {
        return countOfIngredient;
    }

    public void setCountOfIngredient(float countOfIngredient) {
        this.countOfIngredient = countOfIngredient;
    }

/*    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
 */

    public MeasuresBucket getMeasuresBucket() {
        return measuresBucket;
    }

    public void setMeasuresBucket(MeasuresBucket measuresBucket) {
        this.measuresBucket = measuresBucket;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
