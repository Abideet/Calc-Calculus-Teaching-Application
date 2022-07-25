package uk.aston.calculusldc.root.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.math.BigInteger;

/**
     * WordRoomDatabase. Includes code to create the database.
     * After the app creates the database, all further interactions
     * with it happen through the WordViewModel.
     */

    @Database(
            entities = {
            Score.class,
            },
            version = 5, exportSchema = false)


    public abstract class MyRoomDatabase extends RoomDatabase {

        //ask if you have to create 2 different daos
        public abstract ScoreDao scoreDao();


        //singleton class so only one db created
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

//    private static RoomDatabase.Callback sRoomDatabaseCallback =
//            new RoomDatabase.Callback(){
//
//                @Override
//                public void onOpen (@NonNull SupportSQLiteDatabase db){
//                    super.onOpen(db);
//                    new PopulateDbAsync(INSTANCE).execute();
//                }
//            };


//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        //Initially populate database
//        private final ScoreDao mDao;
//        BigInteger[] journeyDurations = {BigInteger.valueOf(111), BigInteger.valueOf(111), BigInteger.valueOf(111)};
//        String[] topic = {"Chain Rule", "Chain Rule", "Chain Rule"};
//
//        Double[] scoreValue = {2.3, 5.1, 1.7};
//
//        PopulateDbAsync(MyRoomDatabase db)
//        {
//            mDao = db.scoreDao();
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            // Start the app with a clean database every time.
//            // Not needed if you only populate the database
//            // when it is first created
//            mDao.deleteAll();
//
//            for (int i = 0; i <= journeyDurations.length - 1; i++) {
//                Score score = new Score(topic[i], scoreValue[i]);
//                mDao.insert(score);
//            }
//            return null;
//        }
//    }


    }

