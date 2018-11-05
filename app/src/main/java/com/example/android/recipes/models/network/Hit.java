package com.example.android.recipes.models.network;


import com.google.gson.annotations.SerializedName;

public class Hit {

    @SerializedName("recipe")
    private Recipe recipe;

    @SerializedName("bookmarked")
    private boolean bookmarked;

    public Recipe getRecipe() {
        return recipe;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    @Override
    public String toString() {
        return "Hit{" +
                "recipe=" + recipe +
                ", bookmarked=" + bookmarked +
                '}';
    }
}

/**
 * SERIALIZED
 * ----------------
 * Hit -> String
 *
 * new Hit(bookmarked = True,
 *         numViews = 3,
 *         numLikes = 5)
 * ----Serialized---->
 * "{
 *  bookmarked: True,
 *  numViews: 3,
 *  numLikes: 5
 * }"
 *
 *
 *
 *
 * DESERIALIZED
 * String -> Hit
 *
 *
 */
