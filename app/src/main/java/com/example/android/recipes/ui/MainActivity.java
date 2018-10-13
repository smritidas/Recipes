package com.example.android.recipes.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.recipes.R;
import com.example.android.recipes.models.network.RecipeSearchResultResponse;
import com.example.android.recipes.services.RetroFitClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO (1) Follow a coding convention
//TODO (2) How do I want to structure the API?


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.ingredientEditText) EditText ingredientEditText;
    @BindView(R.id.findRecipeButton) Button findRecipesButton;
    @BindView(R.id.appNameTextView) TextView appNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface openSans = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf");
        appNameTextView.setTypeface(openSans);
        findRecipesButton.setOnClickListener(this);

        RetroFitClient.getWebService()
                .getRecipes("chicken")
                .enqueue(new Callback<RecipeSearchResultResponse>() {
                    @Override
                    public void onResponse(Call<RecipeSearchResultResponse> call,
                                           Response<RecipeSearchResultResponse> response) {
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
    public void onClick(View view) {
        if (view == findRecipesButton){
            String ingredient = ingredientEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RecipesListActivity.class);
            intent.putExtra("ingredient", ingredient);
            startActivity(intent);
        }
    }
}
