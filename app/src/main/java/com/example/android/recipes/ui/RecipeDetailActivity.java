package com.example.android.recipes.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.recipes.R;
import com.example.android.recipes.models.network.Ingredient;
import com.example.android.recipes.models.network.Recipe;
import com.example.android.recipes.models.network.RecipeSelectedManager;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    //TODO check that code is persisting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        ImageView recipeImage = findViewById(R.id.recipeImageView);
        TextView recipeName = findViewById(R.id.recipeNameTextView);
        TextView recipeIngredients = findViewById(R.id.ingredientTextView);
        Button recipeWebsiteButton = findViewById(R.id.recipeWebsiteButton);
        TextView recipeServings = findViewById(R.id.servings);

        String name = getIntent().getStringExtra("NAME");
        final String url = getIntent().getStringExtra("URL");
        String imageUrl = getIntent().getStringExtra("IMAGE_URL");
        String servings = getIntent().getStringExtra("YIELD");

        Recipe recipe = RecipeSelectedManager.getInstance().getSelectedRecipe();

        recipeName.setText(name);
        recipeServings.setText(servings);
        recipeWebsiteButton.setText(url); //TODO hide the URL behind the button

        String listOfIngredients = getIngredientsFromRecipe(recipe);
      //  Log.i("Ingredients: ", listOfIngredients);
        recipeIngredients.setText(listOfIngredients);

        Glide.with(recipeImage)
                .load(imageUrl)
                .apply(new RequestOptions()
                .fitCenter())
                .into(recipeImage);


        findViewById(R.id.recipeWebsiteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(url));
                startActivity(browserIntent);

            }
        });

//        findViewById(R.id.saveRecipeButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                saveRecipe();
//            }
//        });
}
    private void saveRecipe(){

            //this should be an activity
    }

    @NonNull
    private String getIngredientsFromRecipe(@NonNull Recipe recipe) {
        //This is to convert the list of ingredients to a string
        StringBuilder listOfIngredientsStringBuilder = new StringBuilder();

        String SEPARATOR = ",";
        List<Ingredient> ingredients = recipe.getIngredients();

        for(Ingredient ingredient : ingredients){
            listOfIngredientsStringBuilder.append(ingredient.getText());
            listOfIngredientsStringBuilder.append(SEPARATOR);
        }

        return listOfIngredientsStringBuilder.toString();
    }




}
