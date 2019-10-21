package db;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.android.recipes.models.network.Recipe;

import java.util.List;

@android.arch.persistence.room.Dao
public interface Dao {

    @Insert
    void insert(Entry recipe); //save

    @Update
    void update(Entry recipe);

    @Delete
    void delete(Entry recipe);

    @Query("DELETE FROM savedRecipe_table")
    void deleteAll();

    @Query("SELECT * from savedRecipe_table ORDER BY name ASC")
    LiveData<List<Entry>> getAllRecipes();



}
