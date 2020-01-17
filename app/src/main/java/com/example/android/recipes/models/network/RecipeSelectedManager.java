package com.example.android.recipes.models.network;

/*
 * This class is used to help move all the variables via intents
 */

import androidx.annotation.Nullable;

public class RecipeSelectedManager {

    private static RecipeSelectedManager instance;
    @Nullable
    private Recipe selectedRecipe;

    public static RecipeSelectedManager getInstance() {
        if (instance == null) {
            instance = new RecipeSelectedManager();
        }
        return instance;
    }

    public void setSelectedRecipe(@Nullable Recipe recipe) {
        selectedRecipe = recipe;
    }

    @Nullable
    public Recipe getSelectedRecipe() {
        return selectedRecipe;
    }
}
