package com.example.android.recipes.models.network;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

//

public class Recipe {
    @SerializedName("label")
    private String name; //in the API they call this label

    @SerializedName("image")
    private String imageURL;

    @SerializedName("url")
    private String url; //original recipe identifier

    @SerializedName("yield")
    private int noOfServings;

    @SerializedName("ingredients")
    private List<Ingredient> ingredients;


}

