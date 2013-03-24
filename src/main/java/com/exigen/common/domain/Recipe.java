package com.exigen.common.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code Recipe} is an ordinary user defined Java class whose instances
 * can be stored in the database.
 *
 * @author Ulyana Kucheryavaya
 * @date July 17,2012
 */
@Entity
@Table(name = "recipes")
@NamedQueries({
        @NamedQuery(name = "Recipe.findRecipesFromCuisine",
                query = "SELECT rp FROM Recipe AS rp WHERE rp.cuisine=:selectedCuisine"),
        @NamedQuery(name = "Recipe.findRecipeById",
                query = "SELECT rp FROM Recipe AS rp WHERE rp.id=:selectedId")
})

public class Recipe implements Serializable {

    /**
     * {@code id} its a primary key for this entity
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * {@code title} describes name of recipe in this entity. Its showed in our views
     */
    private String title;

    /**
     * {@code description} this field is intended to describe the recipe
     */
    @Column(columnDefinition = "mediumtext")
    private String description;

    /**
     * {@code cuisine} This field is a reference to the Cuisine entity
     */
    @ManyToOne
    @JoinColumn(name = "cuisineId", nullable = false)
    private Cuisine cuisine;

    /**
     * {@code category} This field is a reference to the Category entity
     */
    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    /**
     * {@code bigImg} This field to save reference on image for recipe
     */

    @Column(columnDefinition = "mediumtext")
    private String bigImage;

    /**
     * {@code smallImg} This field to save reference on image(small) for recipe
     */

    @Column(columnDefinition = "mediumtext")
    private String smallImage;

    /**
     * {@code time} This field to save time of creation for recipe
     */
    private Integer timeOfCooking;

    /**
     * {@code ingredients} it's list of ingredient's buckets in recipe.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<IngredientBucket> ingredients = new ArrayList<IngredientBucket>();

    /**
     * {@code steps} it's list of steps in recipe.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Step> steps = new ArrayList<Step>();

    /**
     * {@method Recipe} its a default constructor for JPA
     */

    public Recipe() {
    }

    /**
     * {@methods Recipe} its a constructors for adding data in entity
     */

    public Recipe(String title, String description, Cuisine cuisine, Category category,
                  String bigImage, String smallImage, Integer timeOfCooking) {
        this.title = title;
        this.description = description;
        this.cuisine = cuisine;
        this.category = category;
        this.bigImage = bigImage;
        this.smallImage = smallImage;
        this.timeOfCooking = timeOfCooking;
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

    public List<IngredientBucket> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientBucket> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public int getCalories() {
        int calories = 0;
        int caloriesCoefficient = 100;
        for (IngredientBucket ib : ingredients) {
            calories += (int) (ib.getCountOfIngredient() * ib.getIngredient().getCalories() * ib.getMeasuresBucket()
                    .getGramEquals() / caloriesCoefficient);

        }
        return calories;
    }
}