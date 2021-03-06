package db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Entry.class}, version = 1)
public abstract class RecipeRoomDatabase extends RoomDatabase {

    public abstract Dao dao();

    private static volatile RecipeRoomDatabase INSTANCE;

    public static synchronized RecipeRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RecipeRoomDatabase.class) {
                if (INSTANCE == null) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                RecipeRoomDatabase.class, "recipe_database")
                                .fallbackToDestructiveMigration()
                                .build();
                    }
                }
            }
        }
        return INSTANCE;
    }


}
