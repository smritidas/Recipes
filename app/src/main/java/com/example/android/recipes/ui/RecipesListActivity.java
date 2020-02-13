package com.example.android.recipes.ui;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.android.recipes.R;
import com.example.android.recipes.adapters.RecipesAdapter;
import com.example.android.recipes.models.network.Hit;
import com.example.android.recipes.models.network.Ingredient;
import com.example.android.recipes.models.network.Recipe;
import com.example.android.recipes.models.network.RecipeSearchResultResponse;
import com.example.android.recipes.models.network.RecipeSelectedManager;
import com.example.android.recipes.services.RetroFitClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesListActivity extends AppCompatActivity implements RecipesAdapter.ListItemClickListener{

    public static final String TAG = RecipesListActivity.class.getSimpleName();

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private RecipesAdapter adapter;

    public List<Recipe> recipes = new ArrayList<>();
    private List<Ingredient> ingredients;
    private Context context;
    private String imageURL;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_rv);
        ButterKnife.bind(this);
        adapter = new RecipesAdapter(this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String ingredient = intent.getStringExtra("ingredient");
        getRecipes(ingredient);

 //       saveButton = findViewById(R.id.saveRecipeButton);
//        saveButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: pressed");
//                //what to write to persist to database
//            }
//        });
    }

    private void getRecipes(String ingredient) {
        RetroFitClient.getWebService()
                .getRecipes(ingredient)
                .enqueue(new Callback<RecipeSearchResultResponse>() {
                    @Override
                    public void onResponse(Call<RecipeSearchResultResponse> call,
                                           Response<RecipeSearchResultResponse> response) {
                        List<Hit> hits = response.body().getRecipeHits();
                        List<Recipe> recipes = new ArrayList<>();
                        for (Hit hit : hits) {
                            recipes.add(hit.getRecipe());
                        }
                        adapter.addRecipes(recipes);
                        Log.i(TAG, response.body().toString());
                    }
                    @Override
                    public void onFailure(Call<RecipeSearchResultResponse> call,
                                          Throwable t) {
                        Log.w(TAG, t);
                    }
                });
    }


    @Override
    public void onClick(Recipe recipe) {
        Intent startIntent = new Intent(this, RecipeDetailActivity.class);
        startIntent.putExtra("NAME", recipe.getName());
        startIntent.putExtra("URL", recipe.getUrl());
        startIntent.putExtra("IMAGE_URL", recipe.getImageURL());
        startIntent.putExtra("YIELD", recipe.getNoOfServings()); //TODO figure out why this isn't working
        StringBuilder listOfIngredientsStringBuilder = new StringBuilder();

        String SEPARATOR = ",";
        List<Ingredient> ingredients = recipe.getIngredients();

        for(Ingredient ingredient : ingredients){
            listOfIngredientsStringBuilder.append(ingredient);
            listOfIngredientsStringBuilder.append(SEPARATOR);
        }

        String listOfIngredients = listOfIngredientsStringBuilder.toString();
        Log.i("Set Ingredients: ", listOfIngredients);
        RecipeSelectedManager.getInstance().setSelectedRecipe(recipe); //this is for the ingredients list
        startActivity(startIntent);
    }
}
