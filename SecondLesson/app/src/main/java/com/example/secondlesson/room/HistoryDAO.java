package com.example.secondlesson.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDAO {

    @Insert
    void insert(HistoryEntity history);

    @Delete
    void delete(HistoryEntity history);

    @Query("SELECT * FROM history")
    List<HistoryEntity> getAll();

    @Query("SELECT h.id, h.expression, h.result, c.name AS category_name " +
            "FROM history h" +
            " LEFT JOIN categories c ON h.category_id = c.id" +
            " ORDER BY h.id DESC")
    List<HistoryWithCategory> getHistoryWithCategory();
}
