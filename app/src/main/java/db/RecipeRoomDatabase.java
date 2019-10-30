package db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
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
