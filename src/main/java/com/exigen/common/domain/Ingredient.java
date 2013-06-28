package com.exigen.common.domain;



import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
                query = "SELECT i FROM Ingredient i ORDER BY i.name")
})
 public class Ingredient {


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


    /**
     * {@code type} this field to describe types of ingredient
     */

    @ManyToOne(targetEntity = IngredientType.class)
    @JoinColumn(name = "typeId", nullable = false)
    private IngredientType type;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    private List<MeasuresBucket> measuresBucketList = new ArrayList<MeasuresBucket>();



    /**
     * {@method Ingredient} its a default constructor for JPA
     */
    public Ingredient() {

    }

    /**
     * {@method Ingredient} its a constructor for setting name of Ingredient
     */
    public Ingredient(String name, IngredientType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * {@method Ingredient} its a constructor for adding data in entity
     * {@param } name,calories,type
     */

    public Ingredient(String name, int calories, IngredientType type) {
        this.name = name;
        this.calories = calories;
        this.type = type;
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

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", type=" + type +
                ", measuresBucketList=" + measuresBucketList +
                '}';
    }
}
