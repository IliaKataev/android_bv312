package com.example.secondlesson.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "history",
        foreignKeys = @ForeignKey(
            entity = CategoryEntity.class,
            parentColumns = "id",
            childColumns = "category_id",
            onDelete = ForeignKey.CASCADE
        ),
        indices = @Index(value = "category_id")
)
public class HistoryEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String expression;

    public String result;

    //@ColumnInfo(name = "category_id", defaultValue = "1")
    public int category_id;



}
