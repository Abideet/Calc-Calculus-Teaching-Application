package uk.aston.calculusldc.root.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.math.BigInteger;



@Entity(tableName = "score_table")
public class Score {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "topic")
    public String mTopic;


    @NonNull
    @ColumnInfo(name = "score")
    public double mScore;


    public Score()
    {

    }

    @Ignore
    public Score(@NonNull String topic, @NonNull double score)
    {
        this.mTopic = topic;
        this.mScore = score;

    }


    public double getMscore() {
        return mScore;
    }

    public void setMscore(@NonNull double mScore) {
        this.mScore = mScore;
    }

    @NonNull
    public String getmTopic()
    {
        return mTopic;
    }



    public void setmTopic(@NonNull String mTopic) {
        this.mTopic = mTopic;
    }

}
