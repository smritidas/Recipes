package com.example.android.recipes.services;

import com.example.android.recipes.Constants;
import com.example.android.recipes.models.network.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//Old OkHTTP based

public class RecipeService {

//    public static void findRecipes(String ingredient, Callback callback){
//        String APP_KEY = Constants.APP_KEY;
//        String APP_ID = Constants.APP_ID;
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RECIPES_BASE_URL).newBuilder();
//        String url = urlBuilder.build().toString();
//        urlBuilder.addQueryParameter(Constants.QUERY_PARAMETER, ingredient);
//        urlBuilder.addQueryParameter(Constants.APP_QUERY_PARAMETER, APP_ID);
//        urlBuilder.addQueryParameter(Constants.KEY_QUERY_PARAMETER, APP_KEY);
//
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        Call call = client.newCall(request);
//        call.enqueue(callback);
//    }
//
//    public ArrayList<Recipe> processResults(Response response){
//        ArrayList<Recipe> recipes = new ArrayList<>();
//        try{
//            String jsonData = response.body().string();
//            if(response.isSuccessful()){
//                JSONObject returnJSON = new JSONObject(jsonData);
//                JSONArray stuffJSON = returnJSON.getJSONArray("stuff");
//                for (int i = 0; i < stuffJSON.length(); i++){
//                    JSONObject foodJSON = stuffJSON.getJSONObject(i);
//                    String name = foodJSON.getString("label");
//                    String imageURL = foodJSON.getString("imageURL");
//                    String URL = foodJSON.getString("URL");
//                    int noOfServings = foodJSON.getInt("servings");
//
//                    ArrayList<String> recipe = new ArrayList<>();
//                    JSONArray recipeJSON = foodJSON.getJSONObject("recipes")
//                            .getJSONArray("display_ingredients");
//                    for (int y = 0; y < recipeJSON.length(); y++) {
//                        recipe.add(recipeJSON.get(y).toString());
//                    }
//
//                  //  Recipe food = new Recipe(name, imageURL, URL, noOfServings, recipe);
//                  //  recipes.add(food);
//                }
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return recipes;
//    }

}
