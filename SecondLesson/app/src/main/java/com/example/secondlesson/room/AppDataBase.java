package com.example.secondlesson.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HistoryEntity.class, CategoryEntity.class}, version = 2, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract HistoryDAO historyDAO();
    public abstract CategoryDAO categoryDAO();
}
