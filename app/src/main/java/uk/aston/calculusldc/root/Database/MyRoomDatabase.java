package uk.aston.calculusldc.root.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.math.BigInteger;

    @Database(
            entities = {
            Score.class,
            },
            version = 5, exportSchema = false)


    public abstract class MyRoomDatabase extends RoomDatabase {

        public abstract ScoreDao scoreDao();


        //singleton pattern to create only one instance of a diagram
        private static MyRoomDatabase INSTANCE;

        public static MyRoomDatabase getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (MyRoomDatabase.class) {
                    if (INSTANCE == null) {
                        // Create database here.
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                MyRoomDatabase.class, "myRoom_database")
                                // Wipes and rebuilds instead of migrating if no Migration object.
                                // Migration is not part of this practical.
                                .fallbackToDestructiveMigration()
                                //.addCallback(sRoomDatabaseCallback)
                                //used if you only want single threaded application
                                .allowMainThreadQueries()
                                .build();
                    }
                }
            }
            return INSTANCE;
        }




    }

