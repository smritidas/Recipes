package com.example.android.recipes.ui;

//TODO - ask if the viewmodel is in the right place

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import db.Entry;
import db.RecipeRepository;

public class RecipeViewModel extends AndroidViewModel {
    private RecipeRepository repository;
    private LiveData<List<Entry>> allRecipes;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
        repository = new RecipeRepository(application);
        allRecipes = repository.getAllRecipes();
    }

    public void insert(Entry recipe){
        repository.insert(recipe);
    }

    public void update(Entry recipe){
        repository.update(recipe);
    }

    public void delete(Entry recipe){
        repository.delete(recipe);
    }

    public void deleteAlNotes(){
        repository.deleteAll();
    }

    public LiveData<List<Entry>> getAllRecipes() {
        return allRecipes;
    }
}
