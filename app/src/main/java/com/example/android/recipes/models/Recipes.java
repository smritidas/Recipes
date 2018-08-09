package com.example.android.recipes.models;


import java.util.ArrayList;

public class Recipes {
    private String name; //in the API they call this label
    private String imageURL;
    private String url; //original recipe identifier
    private int noOfServings;
    private ArrayList<String> ingredients = new ArrayList<>();

    public Recipes(){};

    public Recipes(String name, String imageURL, String url,
                   int noOfServings, ArrayList<String> ingredients) {
        this.name = name;
        this.imageURL = imageURL;
        this.url = url;
        this.noOfServings = noOfServings;
        this.ingredients = ingredients;
    };

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }
    //TODO - if need be, look into resizing images so no memory crash

    public String getUrl() {
        return url;
    }

    public int getNoOfServings() {
        return noOfServings;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }
}

