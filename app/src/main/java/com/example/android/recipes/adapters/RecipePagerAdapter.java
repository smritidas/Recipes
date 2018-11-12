package com.example.android.recipes.adapters;

/**
 * Use this for fragment
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.recipes.models.network.Recipe;
import com.example.android.recipes.ui.RecipeDetailFragment;

import java.util.ArrayList;

public class RecipePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Recipe> mRecipes;

    public RecipePagerAdapter(FragmentManager fm, ArrayList<Recipe> recipe) {
        super(fm);
        mRecipes = recipe;
    }

    @Override
    public Fragment getItem(int position) {
        return RecipeDetailFragment.newInstance(mRecipes.get(position));
    }

    @Override
    public int getCount() {
        return mRecipes.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "FIX ME";
//        return mRecipes.get(position).getName();
    }
}
