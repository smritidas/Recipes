package db;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.android.recipes.models.network.Recipe;

import java.util.List;

@android.arch.persistence.room.Dao
public interface Dao {

    @Insert
    void save(Entry recipe);

    @Query("DELETE FROM savedRecipe")
    void deleteAll();

    @Query("SELECT * from savedRecipe ORDER BY name ASC")
    LiveData<List<Entry>> getAllRecipes();

    //TODO what else would users maybe want?

}
