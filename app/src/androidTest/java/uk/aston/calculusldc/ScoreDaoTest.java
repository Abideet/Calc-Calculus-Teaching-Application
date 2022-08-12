package uk.aston.calculusldc;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import uk.aston.calculusldc.root.Database.ScoreRoomDatabase;
import uk.aston.calculusldc.root.Database.Score;
import uk.aston.calculusldc.root.Database.ScoreDao;


public class ScoreDaoTest {

    public ScoreDaoTest(){

    }


    //Defines the manner in which tests will be executed. Thus, each test is executed synchronously
    @Rule
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    private ScoreDao mScoreDao;
    private ScoreRoomDatabase mDb;

    @Before
    public void createDb() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        // Using an inMemoryDatabaseBuilder because the information stored here disappears when the
        // process is killed.
        mDb = Room.inMemoryDatabaseBuilder(context, ScoreRoomDatabase.class)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build();
        mScoreDao = mDb.scoreDao();
    }

    @After
    public void closeDb() throws Exception
    {
        mDb.close();
    }

    @Test
    public void insert() throws Exception
    {
        double delta =.1;
        Score score = new Score("Chain Rule", 0);
        mScoreDao.insert(score);
        List<Score> allScores = LiveDataTestUtil.getValue(mScoreDao.getAllScores());
        assertEquals(allScores.get(0).getMscore(), score.getMscore(), delta);
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void getAnyScore() {

    }

    @Test
    public void getAllScores() {

    }

    @Test
    public void update() {

    }
}