package com.example.android.recipes.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.recipes.R;
import com.example.android.recipes.models.network.Recipe;
import com.example.android.recipes.ui.RecipeDetailActivity;

//import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * OLD Recyclerview
 */

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>  {
    private ArrayList<Recipe> recipe = new ArrayList<>(); //
    private Context context;

    public RecipeListAdapter(Context context, ArrayList<Recipe> recipes){
        context = context;
        recipe = recipes;
    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item_rv,
                parent,false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return recipe.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.recipeImageView) ImageView mRecipeImageView;
        @BindView(R.id.recipeNameTextView) TextView mRecipeNameTextView;
        @BindView(R.id.noOfServings) TextView mNoOfServings;

        private Context mContext;

        public RecipeViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, RecipeDetailActivity.class);
                    intent.putExtra("position", itemPosition + "");
                   // intent.putExtra("recipes", Parcels.wrap(recipe));
                    mContext.startActivity(intent);

                }
            });

        }

    }
}
