package db;


import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
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
