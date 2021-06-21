package com.belajar.andro.quotesapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history_data")
public class SearchHistoryModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "cari")
    private String cari;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCari() {
        return cari;
    }

    public void setCari(String cari) {
        this.cari = cari;
    }
}
