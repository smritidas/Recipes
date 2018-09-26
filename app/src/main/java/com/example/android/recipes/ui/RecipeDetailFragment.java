package com.example.android.recipes.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.recipes.R;
import com.example.android.recipes.models.network.Recipe;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipeDetailFragment extends Fragment {
  //  @BindView(R.id.recipeTextView) ImageView mRecipeImageView;
    @BindView(R.id.recipeNameTextView) TextView mRecipeNameTextView;
    @BindView(R.id.noOfServings) TextView mServingsTextView;
   // @BindView(R.id.ingredientListView) ListView mIngredientListView;
    @BindView(R.id.directions) TextView mDirectionsTextView;
    @BindView(R.id.saveRecipeButton) Button mButton;

    private Recipe mRecipe;

    public static RecipeDetailFragment newInstance(Recipe recipe){
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipes", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);
      //  Picasso.with(view.getContext()).load(mRecipe.getImageURL()).into(mRecipeImageView);

        mRecipeNameTextView.setText(mRecipe.getName());
        mServingsTextView.setText(mRecipe.getNoOfServings());
        mDirectionsTextView.setText(mRecipe.getUrl());

        //TODO - wire up the ingredientListView - how do I want do handle this?
        //TODO - wire up the button
        //TODO - fix the missing views and use Picasso


        return view;
    }

}
