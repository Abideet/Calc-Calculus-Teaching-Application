package uk.aston.calculusldc.root.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.math.BigInteger;



@Entity(tableName = "score_table")
public class Score {

    //
//    @PrimaryKey(autoGenerate = true)
//    private int journeyID;




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

    public Score(@NonNull String topic, @NonNull double score)
    {
        this.mTopic = topic;
        this.mScore = score;

    }
    /*
     * This constructor is annotated using @Ignore, because Room expects only
     * one constructor by default in an entity class.
     */

//    @Ignore
//    public Score(int id, @NonNull String topic , @NonNull double score)
//    {
//        this.journeyID = id;
//        this.mScore = score;
//    }

//    public int getJourneyID() {
//        return journeyID;
//    }


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


//    public int getLocationID() {return journeyID;}

//
//    public void setJourneyID(int id)
//    {
//        this.journeyID = id;
//    }



    public void setmTopic(@NonNull String mTopic) {
        this.mTopic = mTopic;
    }

}
