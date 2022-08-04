package uk.aston.calculusldc.root.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ScoreDao {

    //Called when a Journey is inserted inside the room db
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Score score);

    @Query("DELETE from score_table")
    void deleteAll();

    @Delete
    void deleteJourney(Score score);

    //change from array
    @Query("SELECT * from score_table LIMIT 1")
    Score[] getAnyJourney();

    //order table by the date
    @Query("SELECT * from score_table ORDER BY score ASC")
    LiveData<List<Score>> getAllJourneys();

    @Update
    void update(Score... score);

}
