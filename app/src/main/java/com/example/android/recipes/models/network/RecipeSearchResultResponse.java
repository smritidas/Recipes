package com.example.android.recipes.models.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Response Model for https://developer.edamam.com/edamam-docs-recipe-api
 */
public class RecipeSearchResultResponse {

    @SerializedName("hits")
    private List<Hit> recipeHits;

    public List<Hit> getRecipeHits() {
        return recipeHits;
    }

    @Override
    public String toString() {
        return "RecipeSearchResultResponse{" +
                "recipeHits=" + recipeHits +
                '}';
    }
}
