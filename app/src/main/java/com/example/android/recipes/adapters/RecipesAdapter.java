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


//Recyclerview Adapter

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    private static final String TAG = RecipesAdapter.class.getSimpleName();
    private List<Recipe> recipes = new ArrayList<>();
    private Context context;

    public RecipesAdapter(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recipeImageView) ImageView recipe_imageView;
        @BindView(R.id.recipeNameTextView) TextView nameOfRecipe_textView;
        @BindView(R.id.noOfServings) TextView yield_textView;
        @BindView(R.id.sourceSite) TextView url_textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setupWithRecipe(@NonNull Recipe recipe) {
            nameOfRecipe_textView.setText(recipe.getName());
            yield_textView.setText(Integer.toString(recipe.getNoOfServings()));
            url_textView.setText(recipe.getUrl());

            Glide.with(recipe_imageView)
                    .load(recipe.getImageURL())
                    .into(recipe_imageView);
        }
    }

    @Override
    public RecipesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item_rv, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipesAdapter.ViewHolder holder, int position) {
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
