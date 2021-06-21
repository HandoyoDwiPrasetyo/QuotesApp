package com.belajar.andro.quotesapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SearchHistoryModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;
    public abstract HistoryDao historyDao();

    public static AppDatabase iniDatabase(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(
                    context,AppDatabase.class, "history"
            ).allowMainThreadQueries().build();
        }
        return appDatabase;
    }

}
