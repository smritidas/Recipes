package com.example.android.recipes.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.android.recipes.R;
import com.example.android.recipes.adapters.RecipesAdapter;
import com.example.android.recipes.models.network.Hit;
import com.example.android.recipes.models.network.Recipe;
import com.example.android.recipes.models.network.RecipeSearchResultResponse;
import com.example.android.recipes.services.RetroFitClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesListActivity extends AppCompatActivity {

    public static final String TAG = RecipesListActivity.class.getSimpleName();

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private RecipesAdapter adapter;

    public List<Recipe> recipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_rv);
        ButterKnife.bind(this);
        adapter = new RecipesAdapter(this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String ingredient = intent.getStringExtra("ingredient");
        getRecipes(ingredient);
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
}
