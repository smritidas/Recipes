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
        TextView recipeServings = findViewById(R.id.noOfServingsTextView);
        TextView ingredients = findViewById(R.id.ingredientTextView);
        TextView website = findViewById(R.id.recipe_website);

        String name = getIntent().getStringExtra("Name");
        recipeName.setText(name);




}}
