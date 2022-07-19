package uk.aston.calculusldc.root.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreRepository {

    private final ScoreDao mScoreDao;
    private final LiveData<List<Score>> mAllJourneys;

    ScoreRepository(Application application) {
        MyRoomDatabase db = MyRoomDatabase.getDatabase(application);
        mScoreDao = db.scoreDao();
        mAllJourneys = mScoreDao.getAllJourneys();
    }

    LiveData<List<Score>> getmAllJourneys() {
        return mAllJourneys;
    }

    public void insert(Score score) {
        new insertAsyncTask(mScoreDao).execute(score);
    }

    public void deleteAll() {
        new deleteAllJourneysAsyncTask(mScoreDao).execute();
    }

    public void deleteJourney(Score score) {
        new deleteJourneyAsyncTask(mScoreDao).execute(score);
    }

    public void update(Score score)
    {
        new updateJourneyAsyncTask(mScoreDao).execute(score);
    }



    //inner class to insert journey without blocking the UI thread
    private static class insertAsyncTask extends AsyncTask<Score, Void, Void> {
        private final ScoreDao mAsyncTaskDao;

        insertAsyncTask(ScoreDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Score... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


    //inner class to delete journey without blocking the UI thread
    private static class deleteAllJourneysAsyncTask extends AsyncTask<Void, Void, Void> {
        private final ScoreDao mAsyncTaskDao;

        deleteAllJourneysAsyncTask(ScoreDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }


    private static class deleteJourneyAsyncTask extends AsyncTask<Score, Void, Void> {
        private final ScoreDao mAsyncTaskDao;

        deleteJourneyAsyncTask(ScoreDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Score... params) {
            mAsyncTaskDao.deleteJourney(params[0]);
            return null;
        }
    }


    private static class updateJourneyAsyncTask extends AsyncTask<Score, Void, Void>
    {
        private final ScoreDao mAsyncTaskDao;

        updateJourneyAsyncTask(ScoreDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Score... params)
        {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }


}


