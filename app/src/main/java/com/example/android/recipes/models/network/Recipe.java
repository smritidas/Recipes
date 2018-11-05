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

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getUrl() {
        return url;
    }

    public int getNoOfServings() {
        return noOfServings;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", url='" + url + '\'' +
                ", noOfServings=" + noOfServings +
                ", ingredients=" + ingredients +
                '}';
    }
}

