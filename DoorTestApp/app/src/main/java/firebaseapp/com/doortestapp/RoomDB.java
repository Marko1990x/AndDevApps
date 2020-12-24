package firebaseapp.com.doortestapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//first this
@Database(entities = {MainData.class},version = 1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {  // class must be abstract

    // in this class import my database class and initialize it basicly so i can use this class to call methods if i am right

    //crate database instance
    private static RoomDB database;

    //define database name
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context){
        //check condition
        if (database == null){
            // if database is null
            // initialize database
            database = Room.databaseBuilder(context.getApplicationContext(),RoomDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        //return database
        return database;
    };


    //Create Dao
    public abstract MainDao mainDao();

}
