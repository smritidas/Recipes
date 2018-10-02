package com.example.android.recipes.models.network;



import com.google.gson.annotations.SerializedName;

public class Ingredient {

    @SerializedName("uri")
    private String name;

    @SerializedName("quantity")
    private float quantity;

    @SerializedName("measure")
    private Measure measure;

    @SerializedName("weight")
    private float weight;

    @SerializedName("food")
    private Food food;
}
