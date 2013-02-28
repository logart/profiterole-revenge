package com.exigen.common.domain;

import javax.persistence.*;

/**
 * Class {@code IngredientBucket} is an entity what describe how many of some ingredient
 * contains the recipe
 *
 * @author Tony Soprano
 * @date Feb 26, 2013
 */
@Entity
@Table(name = "ingredientsBucket")
public class IngredientBucket {

    /**
     * {@code id} its a primary key for this entity
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * {@code ingredient} this field contains ingredient
     */
    @ManyToOne
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;

    /**
     * {@code countOfIngridient} this field to describe quantity of particular ingredient
     * in some recipe
     */
    private float countOfIngredient;

    /**
     * {@code unitOfMeasure} this field contains the unit of measure
     * of particular ingredient in this entity.
     */
    @ManyToOne
    @JoinColumn(name = "measureId")
    private Measure measure;

    /**
     * {@code recipe} this field contains recipe, what have got
     * this ingredient
     */
    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;

    /**
     * {@methods IngredientBucket} this are constructors of this class
     */
    public IngredientBucket() {

    }

    public IngredientBucket(Ingredient ingredient, int countOfIngridient, String unitOfMeasure) {

    }

    /**
     * {@methods } below its a getters and setters
     */
    public int getId() {
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

    public float getCountOfIngredient() {
        return countOfIngredient;
    }

    public void setCountOfIngredient(float countOfIngredient) {
        this.countOfIngredient = countOfIngredient;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
