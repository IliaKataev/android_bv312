package com.example.secondlesson.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Insert
    long insert(CategoryEntity category);

    @Delete
    void delete(CategoryEntity category);

    @Query("SELECT * FROM categories")
    List<CategoryEntity> getAll();

    @Query("SELECT * FROM categories WHERE name = :name LIMIT 1")
    CategoryEntity getByName(String name);
}
