package com.exigen.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code Ingredient} is an ordinary user defined Java class whose instances
 * can be stored in the database.
 *
 * @author Ivan Guravel
 * @date Feb 24,2013
 */

@Entity
@Table(name = "ingredients")
@NamedQueries({
        @NamedQuery(name = "Ingredient.getAllIngredients",
                query = "SELECT i FROM Ingredient i")
})
public class Ingredient implements Serializable, Comparable {

    /**
     * {@code id} its a primary key for this entity
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * {@code name} this field describes the unique name
     * of particular ingredient in this entity. This name using for add
     * components into our recipe
     */
    private String name;

    /**
     * {@code calories} this field to describe calories value in particular ingredient for 100gr.
     */
    private int calories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    private List<MeasuresBucket> measuresBucketList = new ArrayList<MeasuresBucket>();

//       @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredientId")
//      private List<IngredientBucket> ingredientBucketList = new ArrayList<IngredientBucket>();


    /**
     * {@method Ingredient} its a default constructor for JPA
     */
    public Ingredient() {

    }

    /**
     * {@method Ingredient} its a constructor for setting name of Ingredient
     */
    public Ingredient(String name) {
        this.name = name;
    }

    /**
     * {@method Ingredient} its a constructor for adding data in entity
     */
    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public List<MeasuresBucket> getMeasuresBucketList() {
        return measuresBucketList;
    }

    public void setMeasuresBucketList(List<MeasuresBucket> measuresBucketList) {
        this.measuresBucketList = measuresBucketList;
    }

    @Override
    public int compareTo(Object ingredient) {
        Ingredient otherIngredient = (Ingredient) ingredient;
        return this.name.compareTo(otherIngredient.name);
    }
}
