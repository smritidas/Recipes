package com.example.android.recipes.models.network;


import com.google.gson.annotations.SerializedName;

public class Hit {

    @SerializedName("recipe")
    private Recipe recipe;

    @SerializedName("bookmarked")
    private boolean bookmarked;

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
