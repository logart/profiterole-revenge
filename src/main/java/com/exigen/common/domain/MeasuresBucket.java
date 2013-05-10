package com.exigen.common.domain;

import javax.persistence.*;

/**
 * Class {@code MeasuresBucket} is an entity what describe
 * relationship between measures of measurement
 *
 * @author Tony Soprano
 * @date Feb 26, 2013
 */
@Entity
@Table(name = "measuresBucket")
public class MeasuresBucket {


    /**
     * {@code id} its a primary key for this entity
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * {@code id} its a field what contains measure
     */
    @ManyToOne
    @JoinColumn(name = "measureId", nullable = false)
    private Measure measure;

    /**
     * {@code id} its a field what contains ingredient
     */
    @ManyToOne
    @JoinColumn(name = "ingredientId", nullable = false)
    private Ingredient ingredient;

    /**
     * {@code id} its a field what contains how many grams contains a measure
     */
    private Integer gramEquals;

    /**
     * {@methods MeasuresBucket} its a constructors for adding data in entity
     */
    public MeasuresBucket() {

    }

    public MeasuresBucket(Measure measure, Ingredient ingredient, Integer gramEquals) {
        this.measure = measure;
        this.ingredient = ingredient;
        this.gramEquals = gramEquals;
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

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getGramEquals() {
        return gramEquals;
    }

    public void setGramEquals(int gramEquals) {
        this.gramEquals = gramEquals;
    }
}


