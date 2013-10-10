package com.exigen.common.domain;


import java.util.Map;

/**
 * Class {@code RecipeWithMarkers} is an ordinary user defined Java class whose instances
 * describe recipe with markers
 *
 * @author Elena Vasilkovich
 * @date April 22,2013
 */
public class RecipeWithMarkers {

    /**
     * {@code cuisine} This field is a reference to the Recipe entity
     */
    private Recipe recipe;

    /**
     * {@code cuisine} This field describes the map of markers
     */
    private Map<String,String> markers;

    public RecipeWithMarkers() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Map<String,String> getMarkers() {
        return markers;
    }

    public void setMarkers(Map<String,String> markers) {
        this.markers = markers;
    }
}
