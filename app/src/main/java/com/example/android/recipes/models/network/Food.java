package com.example.android.recipes.models.network;

import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("label")
    private String label;

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Food{" +
                "label='" + label + '\'' +
                '}';


    }
}
