package com.example.android.recipes.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.recipes.R;

public class RecipeDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        ImageView recipeImage = findViewById(R.id.recipeImageView);
        TextView recipeName = findViewById(R.id.recipeNameTextView);
        TextView recipeIngredients = findViewById(R.id.ingredientTextView);
        Button recipeWebsiteButton = findViewById(R.id.recipe_website_button);

        Intent intent = getIntent();
        String name = getIntent().getStringExtra("NAME");
        String url = getIntent().getStringExtra("URL");


        //Binding the view to the data

        recipeName.setText(name);
        recipeWebsiteButton.setText(url); //TODO hide the URL behind the button


        //TODO Opening the URL will require an implicit intent


}}
