package com.example.android.recipes.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;


import com.example.android.recipes.R;
import com.example.android.recipes.adapters.RecipeListAdapter;
import com.example.android.recipes.models.network.Recipe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesListActivity extends AppCompatActivity {
    public static final String TAG = RecipesListActivity.class.getSimpleName();

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;

    public ArrayList<Recipe> mRecipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_rv);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String ingredient = intent.getStringExtra("ingredient");
        getRecipes(ingredient);
    }

    private void getRecipes(String ingredient) {
 //       final RecipeService recipeService = new RecipeService();
//        recipeService.findRecipes(ingredient, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) {
//                mRecipes = recipeService.processResults(response);
//
//                RecipesListActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mAdapter = new RecipeListAdapter(getApplicationContext(), mRecipes);
//                        RecyclerView.LayoutManager layoutManager =
//                                new LinearLayoutManager(RecipesListActivity.this);
//                        mRecyclerView.setLayoutManager(layoutManager);
//                        mRecyclerView.setAdapter(mAdapter);
//                        mRecyclerView.setHasFixedSize(true);
//                    }
//
//                });
//            }
//
//        });
    }
}
