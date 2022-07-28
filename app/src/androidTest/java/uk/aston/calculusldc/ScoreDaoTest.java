package uk.aston.calculusldc;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import uk.aston.calculusldc.LiveDataTestUtil;
import uk.aston.calculusldc.root.Database.MyRoomDatabase;
import uk.aston.calculusldc.root.Database.Score;
import uk.aston.calculusldc.root.Database.ScoreDao;


public class ScoreDaoTest {

    public ScoreDaoTest(){

    }


    //Defines the manner in which tests will be executed. Thus, each test is executed synchronously
    @Rule
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    private ScoreDao mScoreDao;
    private MyRoomDatabase mDb;

    @Before
    public void createDb() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        // Using an inMemoryDatabaseBuilder because the information stored here disappears when the
        // process is killed.
        mDb = Room.inMemoryDatabaseBuilder(context, MyRoomDatabase.class)
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
        List<Score> allScores = LiveDataTestUtil.getValue(mScoreDao.getAllJourneys());
        assertEquals(allScores.get(0).getMscore(), score.getMscore(), delta);
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void deleteJourney() {

    }

    @Test
    public void getAnyJourney() {

    }

    @Test
    public void getAllJourneys() {

    }

    @Test
    public void update() {

    }
}