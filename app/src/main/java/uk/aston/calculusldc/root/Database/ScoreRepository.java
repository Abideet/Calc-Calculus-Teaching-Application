package uk.aston.calculusldc.root.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ScoreRepository {

    private final ScoreDao mScoreDao;
    private final LiveData<List<Score>> mAllScores;

    ScoreRepository(Application application) {
        ScoreRoomDatabase db = ScoreRoomDatabase.getDatabase(application);
        mScoreDao = db.scoreDao();
        mAllScores = mScoreDao.getAllScores();
    }

    LiveData<List<Score>> getmAllScores() {
        return mAllScores;
    }

    public void insert(Score score) {
        new insertAsyncTask(mScoreDao).execute(score);
    }



    public void update(Score score)
    {
        new updateScoreAsyncTask(mScoreDao).execute(score);
    }



    //inner class to insert score without blocking the UI thread
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


    private static class updateScoreAsyncTask extends AsyncTask<Score, Void, Void>
    {
        private final ScoreDao mAsyncTaskDao;

        updateScoreAsyncTask(ScoreDao dao) {
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


