package com.example.android.recipes.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.recipes.R;
import com.example.android.recipes.models.network.Recipe;
import com.example.android.recipes.models.network.RecipeSelectedManager;

public class RecipeDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        ImageView recipeImage = findViewById(R.id.recipeImageView);
        TextView recipeName = findViewById(R.id.recipeNameTextView);
        TextView recipeIngredients = findViewById(R.id.ingredientTextView);
        Button recipeWebsiteButton = findViewById(R.id.recipe_website_button); //TODO follow a common code convention

        Intent intent = getIntent();
        String name = getIntent().getStringExtra("NAME");
        String url = getIntent().getStringExtra("URL");
        String imageUrl = getIntent().getStringExtra("IMAGE_URL");
      //  Recipe recipe = RecipeSelectedManager.getInstance().getSelectedRecipe();


        recipeName.setText(name);
        recipeWebsiteButton.setText(url); //TODO hide the URL behind the button
     //   recipeIngredients.setText(recipe);

        Glide.with(recipeImage) //TODO Resize image
                .load(imageUrl)
                .into(recipeImage);


        //TODO Opening the URL will require an implicit intent


}}
