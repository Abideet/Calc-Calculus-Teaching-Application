package uk.aston.calculusldc.root.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
            entities = {
            Score.class,
            },
            version = 5, exportSchema = false)


    public abstract class ScoreRoomDatabase extends RoomDatabase {

        public abstract ScoreDao scoreDao();


        //singleton pattern to create only one instance of a diagram
        private static ScoreRoomDatabase INSTANCE;

        public static ScoreRoomDatabase getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (ScoreRoomDatabase.class) {
                    if (INSTANCE == null) {
                        // Create database here.
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                ScoreRoomDatabase.class, "myRoom_database")
                                .fallbackToDestructiveMigration()
                                .allowMainThreadQueries()
                                .build();
                    }
                }
            }
            return INSTANCE;
        }

    }

