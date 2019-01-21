package com.example.android.recipes.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        TextView recipeYield = findViewById(R.id.noOfServingsTextView);
        TextView recipeIngredients = findViewById(R.id.ingredientTextView);
        TextView recipeWebsite = findViewById(R.id.recipe_website);

        Intent intent = getIntent();
        String name = getIntent().getStringExtra("name");
        String url = getIntent().getStringExtra("url");

        //Binding the view to the data

        recipeName.setText(name);
        recipeWebsite.setText(url);


        //Opening the URL will require an implicit intent


}}
