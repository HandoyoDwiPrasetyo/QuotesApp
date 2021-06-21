package com.belajar.andro.quotesapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {
    @Insert
    long insertHistory(SearchHistoryModel searchHistoryModel);

    @Delete
    int deleteHistory(SearchHistoryModel searchHistoryModel);

    @Query("SELECT * FROM history_data")
    List<SearchHistoryModel> getHistory();
}
