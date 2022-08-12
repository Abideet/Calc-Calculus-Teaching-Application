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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Score score);

    @Query("SELECT * from score_table ORDER BY score ASC")
    LiveData<List<Score>> getAllScores();

    @Update
    void update(Score... score);

}
