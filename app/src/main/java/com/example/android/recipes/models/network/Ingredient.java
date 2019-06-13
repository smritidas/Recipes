package com.example.android.recipes.models.network;

/**
 * the API has changed June 2019 - I added text - the API doesn't record this
 */

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

    @SerializedName("text")
    private String text;

    public String getText() {
        return text; }

    public String getName() {
        return name;
    }

    public float getQuantity() {
        return quantity;
    }

    public Measure getMeasure() {
        return measure;
    }

    public float getWeight() {
        return weight;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", measure=" + measure +
                ", weight=" + weight +
                ", food=" + food +
                ", text=" + text +
                '}';
    }
}
