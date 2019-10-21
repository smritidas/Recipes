package db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class RecipeRepository {

    private Dao dao;
    private LiveData<List<Entry>> allRecipes;


    public RecipeRepository(Application application){
        RecipeRoomDatabase database = RecipeRoomDatabase.getDatabase(application);
        dao = database.dao();
        allRecipes = dao.getAllRecipes();
    }

    public void insert(Entry recipe){
        new InsertAsyncTask(dao).execute(recipe);
    }

    public void update(Entry recipe){
        new UpdateAsyncTask(dao).execute(recipe);
    }

    public void delete(Entry recipe){
        new DeleteAsyncTask(dao).execute(recipe);
    }

    public void deleteAll(){
        new DeleteAllAsyncTask(dao).execute();
    }

    public LiveData<List<Entry>> getAllRecipes(){
        return allRecipes;
    }

    private static class InsertAsyncTask extends android.os.AsyncTask<Entry, Void, Void> {
        private Dao dao;

        private InsertAsyncTask(Dao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Entry... entries) {
            dao.insert(entries[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Entry, Void, Void> {
        private Dao dao;

        private UpdateAsyncTask(Dao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Entry... entries) {
            dao.update(entries[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Entry, Void, Void> {
        private Dao dao;

        private DeleteAsyncTask(Dao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Entry... entries) {
            dao.delete(entries[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;

        private DeleteAllAsyncTask(Dao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            return null;
        }
    }
}
