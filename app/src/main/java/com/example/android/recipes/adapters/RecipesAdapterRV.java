package com.example.android.recipes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.recipes.R;
import com.example.android.recipes.models.network.Recipe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipesAdapterRV extends RecyclerView.Adapter<RecipesAdapterRV.ViewHolder> {

    private static final String TAG = "RecipesAdapterRV";
    private ArrayList<Recipe> recipe = new ArrayList<>(); //Should this be a list or an ArrayList?
    private Context context; //What the heck is context?



    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recipeImageView) ImageView image;
        @BindView(R.id.recipeNameTextView) TextView nameOfRecipe;
        @BindView(R.id.noOfServings) TextView yield;
        @BindView(R.id.sourceSite) TextView url;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecipesAdapterRV.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recipes_rv, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipesAdapterRV.ViewHolder holder, int position) {

        //add Glide here

    }

    @Override
    public int getItemCount() {
        return recipe.size();
    }
}
