package com.example.android.recipes.ui;

//Changing fragment to an activity

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.recipes.R;

import butterknife.BindView;

//Do all activities have to be declared in teh manifest?

public class RecipeActivity extends AppCompatActivity{

    private static final String TAG = RecipeActivity.class.getSimpleName();
    //add all textviews
   // @BindView()



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO rename contentview
        setContentView(R.layout.activity_recipe_detail);
        Log.d(TAG, "onCreate: started");



}}
