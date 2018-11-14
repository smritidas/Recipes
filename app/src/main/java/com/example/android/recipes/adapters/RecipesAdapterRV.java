package com.example.android.recipes.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.recipes.R;
import com.example.android.recipes.models.network.Recipe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipesAdapterRV extends RecyclerView.Adapter<RecipesAdapterRV.ViewHolder> {

    private static final String TAG = RecipesAdapterRV.class.getSimpleName();
    private List<Recipe> recipes = new ArrayList<>(); //Should this be a list or an ArrayList?
    private Context context; //What the heck is context?

    public RecipesAdapterRV(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recipeImageView) ImageView image;
        @BindView(R.id.recipeNameTextView) TextView nameOfRecipe;
        @BindView(R.id.noOfServings) TextView yield;
        @BindView(R.id.sourceSite) TextView url;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setupWithRecipe(@NonNull Recipe recipe) {
            nameOfRecipe.setText(recipe.getName());
            yield.setText(Integer.toString(recipe.getNoOfServings()));
            url.setText(recipe.getUrl());

            Glide.with(image)
                    .load(recipe.getImageURL())
                    .into(image);
        }
    }

    @Override
    public RecipesAdapterRV.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item_rv, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipesAdapterRV.ViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        holder.setupWithRecipe(recipe);
        //add Glide here
        //add action for when item is clicked

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void addRecipes(List<Recipe> recipes) {
        int newRecipeSize = recipes.size();
        this.recipes.addAll(0, recipes);

        // TODO: Check out this link
        // https://github.com/codepath/android_guides/wiki/Using-the-RecyclerView#notifying-the-adapter
        notifyItemRangeInserted(0, newRecipeSize);
    }
}
