package com.example.android.recipes.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.recipes.R;
import com.example.android.recipes.models.network.Recipe;

import java.util.ArrayList;
import java.util.List;

public class SavedRecipeAdapter extends RecyclerView.Adapter<SavedRecipeAdapter.ViewHolder> {

    private static final String TAG = "SavedRecipeAdapter";
    //create arraylists?

    private List<Recipe> savedRecipe = new ArrayList<>();
    private Context context;

    public SavedRecipeAdapter(Context context){ // figure out constructor

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item_rv, parent, false);
        SavedRecipeAdapter.ViewHolder viewHolder = new SavedRecipeAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SavedRecipeAdapter.ViewHolder holder, int position) {
        Recipe recipe = savedRecipe.get(position);
        //What goes here?
    }

    @Override
    public int getItemCount() {
        return savedRecipe.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //include relevant views

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

