package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@code Ingridient} is an ordinary user defined Java class whose instances
 * can be stored in the database.
 *
 * @author Ivan Guravel
 * @date November 6,2012
 */

@Entity
@Table(name = "ingridients")
public class Ingridient implements Serializable {

    /**
     * {@code ingridientId} its a primary key for this entity
     * The @Id annotation marks a field as a primary key field.
     * The @GeneratedValue annotation specifies that the primary key is automatically
     * allocated by DB.
     */
    @Id
    @GeneratedValue
    private Integer ingridientId;

    /**
     * {@code nameOfIngridient} this field to describe the unique name
     * of particular ingridient in this entity. This name using for add
     * components into our recipe
     */
    private String nameOfIngridient;

    /**
     * {@code calories} this field to describe calories value in particular ingridient.
     */
    private float calories;

    /**
     * {@code countOfIngridient} this field to describe quantity of particular ingridient
     * in some recipe
     */
    private int countOfIngridient;

    private String unitOfMeasure;

    /**
     * {@code recipe} this field its a bidirectional reference on Recipe entity.
     */
    @ManyToOne
    @JoinColumn(name = "recip_id", nullable = false)
    private Recipe recipe;

    /**
     * {@method Ingridient} its a default constructor for JPA
     */
    public Ingridient() {

    }

    /**
     * {@method Ingridient} its a constructor for adding data in entity
     */
    public Ingridient(String nameOfIngridient, float calories, int countOfIngridient, String unitOfMeasure, Recipe recipe) {
        this.nameOfIngridient = nameOfIngridient;
        this.calories = calories;
        this.countOfIngridient = countOfIngridient;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

    /**
     * {@methods } below its a getters and setters
     */

    public Integer getIngridientId() {
        return ingridientId;
    }

    public void setIngridientId(Integer ingridientId) {
        this.ingridientId = ingridientId;
    }

    public String getNameOfIngridient() {
        return nameOfIngridient;
    }

    public void setNameOfIngridient(String nameOfIngridient) {
        this.nameOfIngridient = nameOfIngridient;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getCountOfIngridient() {
        return countOfIngridient;
    }

    public void setCountOfIngridient(int countOfIngridient) {
        this.countOfIngridient = countOfIngridient;
    }
}
