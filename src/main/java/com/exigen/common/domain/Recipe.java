package com.exigen.common.domain;

import org.apache.solr.analysis.LowerCaseFilterFactory;
import org.apache.solr.analysis.SnowballPorterFilterFactory;
import org.apache.solr.analysis.StandardTokenizerFactory;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Parameter;

import javax.persistence.*;
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
// This annotation tells hibernate search that this class has to be indexed
@Indexed
@AnalyzerDef(name = "customanalyzer",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
                        @Parameter(name = "language", value = "Russian")
                })
        })

public class Recipe {


    private static final int CALORIES_COEFFICIENT = 100;

    /**
     * {@code id} its a primary key for this entity
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * {@code title} describes name of recipe in this entity. Its showed in our views
     */
    @Analyzer(definition = "customanalyzer")
    @Field(index= Index.YES,store = Store.NO)
    private String title;

    /**
     * {@code description} this field is intended to describe the recipe
     */
    @Column(columnDefinition = "mediumtext")
    @Analyzer(definition = "customanalyzer")
    @Field(index= Index.YES,store = Store.NO)
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
     * {@code complexity} This field to save complexity of recipe
     */
    @Column(columnDefinition = "VARCHAR(20)")
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
                  String bigImage, String smallImage, Integer timeOfCooking ) {
        this.title = title;
        this.description = description;
        this.cuisine = cuisine;
        this.category = category;
        this.bigImage = bigImage;
        this.smallImage = smallImage;
        this.timeOfCooking = timeOfCooking;
    }
    /**
     * {@methods Recipe} its a constructors for adding data in entity
     */

    public Recipe(String title, String description, Cuisine cuisine, Category category,
                  String bigImage, String smallImage, Integer timeOfCooking, Byte markers) {
        this.title = title;
        this.description = description;
        this.cuisine = cuisine;
        this.category = category;
        this.bigImage = bigImage;
        this.smallImage = smallImage;
        this.timeOfCooking = timeOfCooking;
        this.markers = markers;
    }

    /**
     * {@methods Recipe} its a constructors for adding data in entity
     * add complexity of recipe, quantity of dish
     */

    public Recipe(String title, String description, Cuisine cuisine, Category category,
                  String bigImage, String smallImage, Integer timeOfCooking, String complexity,
                  Integer quantityOfDish, Byte markers) {
        this.title = title;
        this.description = description;
        this.cuisine = cuisine;
        this.category = category;
        this.bigImage = bigImage;
        this.smallImage = smallImage;
        this.timeOfCooking = timeOfCooking;
        this.complexity = complexity;
        this.quantityOfDish = quantityOfDish;
        this.markers = markers;
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

    public int getCalories() {
        int calories = 0;
        for (IngredientBucket ib : ingredients) {
            calories += (int) (ib.getCountOfIngredient() * ib.getIngredient().getCalories() * ib.getMeasuresBucket()
                    .getGramEquals() / CALORIES_COEFFICIENT);

        }
        return calories;
    }
}