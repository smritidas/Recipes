package com.example.android.recipes.services;

//Retrofit Interface



import android.database.Observable;

import com.example.android.recipes.Constants;
import com.example.android.recipes.models.network.RecipeSearchResultResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {


        /**
         * Step 1:
         * RecipeSearchResultResponse getRecipes(String userInput)
         *
         * Step 2:
         * Call<RecipeSearchResultResponse> getRecipes(String userInput);
         *
         * Step 3:
         * Add url Annotation
         * @GET("/search/?app_id=" + Constants.APP_ID + "&app_key=" + Constants.APP_KEY)
         * Call<RecipeSearchResultResponse> getRecipes(String userInput);
         *
         * Step 4:
         * Add Query Annotation
         * @GET("/search/?app_id=" + Constants.APP_ID + "&app_key=" + Constants.APP_KEY)
         * Call<RecipeSearchResultResponse> getRecipes(String userInput);
         */

        /*
        https://api.edamam.com/search
        FIXED: ?app_id=bf667bb5
        FIXED: &app_key=26ebe966f1ca8e963cafe2b32000cee6

        &q=chicken
         */
        @GET("/search?app_id=" + Constants.APP_ID + "&app_key=" + Constants.APP_KEY)
        Call<RecipeSearchResultResponse> getRecipes(@Query("q") String userInput);


}
