package com.exigen.common.domain;

import org.hibernate.validator.constraints.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code AddRecipeData} is a class that contains the user's
 * text data for further validation and added to the database
 *
 * @author Oleg Kalinichenko
 * @date December 02, 2012
 */
public class AddRecipeData implements Serializable {
    /**
     * {@code maxStepSize} Contains maximum length of title text
     */
    private static final int maxTitleSize = 250;

    /**
     * {@code maxStepSize} Contains maximum length of description text
     */
    private static final int maxDescriptionSize = 3000;

    /**
     * {@code maxStepSize} Contains maximum value of cooking time
     */
    private static final int maxCookingTimeSize = 540;

    /**
     * {@code maxStepSize} Contains minimum value of cooking time
     */
    private static final int minCookingTimeSize = 6;

    /**
     * {@code title} Contains the title of recipe.
     */
    @NotEmpty(message = "Поле должно быть указано.")
    @Size(max = maxTitleSize, message = "Количество символов не должно превышать" + maxTitleSize + "символов.")
    @Pattern(regexp = "^[а-яА-ЯіІїЇєЄёЁa-zA-Z0-9 \\Q.,()[]+-*/=\"'\\E]*$", message = "Корректными значениями являются большие и маленькие буквы (English, Українська, Русский), цифры, символы(,()[]+-*/=\"'')")
    private String title;

    /**
     * {@code description} This field is intended to describe the recipe.
     */
    @NotEmpty(message = "Поле должно быть указано.")
    @Size(max = maxDescriptionSize, message = "Количество символов не должно превышать " + maxDescriptionSize + " символов.")
    @Pattern(regexp = "^[а-яА-ЯіІїЇєЄёЁa-zA-Z0-9\\r\\n \\Q(.,()+-=\"':;[]!?*%<>/\\E]*$", message = "Корректными значениями являются большие и маленькие буквы (English, Українська, Русский), цифры, символы(.,()+-=\"':;[]!?*%<>/)", flags = javax.validation.constraints.Pattern.Flag.MULTILINE)
    private String description;

    /**
     * {@code cookingTime} This field contains cooking time.
     */
    @NotEmpty(message = "Поле должно быть указано.")
    @Pattern(regexp = "^[0-9]*$", message = "Должно быть целым числом.")
    @Min(value = minCookingTimeSize, message = "Корректное значение лежит в диапазоне от  " + minCookingTimeSize + " до  " + maxDescriptionSize + " (целые).")
    @Max(value = maxCookingTimeSize, message = "Корректное значение лежит в диапазоне от " + minCookingTimeSize + " до  " + maxDescriptionSize + " (целые).")
    private String cookingTime;

    /**
     * {@code cuisineId} This field contains the selected cuisine ID, to obtain appropriate cuisine
     */
    @NotEmpty(message = "Кухня должна быть указана.")
    private String cuisineId;

    /**
     * {@code cuisineId} This field contains the selected category ID, to obtain appropriate category
     */
    @NotEmpty(message = "Категория должна быть указана.")
    private String categoryId;

    /**
     * {@code cuisine} This field is a reference to the Cuisine entity.
     */
    private Cuisine cuisine;

    /**
     * {@code category} This field is a reference to the Categories entity.
     */
    private Categories category;

    /**
     * {@code ingredientList} This field contains list of steps for meal
     */
    private List<String> stepsList = new ArrayList<String>();

    /**
     * {@code ingredientList} This field contains list of names of ingredients for meal
     */
    private List<String> ingredientsNameList = new ArrayList<String>();

    /**
     * {@code ingredientList} This field contains list of counts of ingredients for meal
     */
    private List<String> ingredientsCountList = new ArrayList<String>();

    /**
     * {@code ingredientList} This field contains list of types of ingredients for meal
     */
    private List<String> ingredientsTypeList = new ArrayList<String>();

    public String getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(String cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public AddRecipeData() {

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

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public List<String> getIngredientsNameList() {
        return ingredientsNameList;
    }

    public void setIngredientsNameList(List<String> ingredientsNameList) {
        this.ingredientsNameList = ingredientsNameList;
    }

    public List<String> getIngredientsCountList() {
        return ingredientsCountList;
    }

    public void setIngredientsCountList(List<String> ingredientsCountList) {
        this.ingredientsCountList = ingredientsCountList;
    }

    public void setIngredientsCountList(int index, String ingredientsCountList) {
        this.ingredientsCountList.set(index, ingredientsCountList);
    }

    public List<String> getIngredientsTypeList() {
        return ingredientsTypeList;
    }

    public void setIngredientsTypeList(List<String> ingredientsTypeList) {
        this.ingredientsTypeList = ingredientsTypeList;
    }

    public List<String> getStepsList() {
        return stepsList;
    }

    public void setStepsList(List<String> stepsList) {
        this.stepsList = stepsList;
    }
}
