package com.example.secondlesson.room;

import androidx.room.ColumnInfo;

public class HistoryWithCategory {
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "expression")
    public String expression;

    @ColumnInfo(name = "result")
    public String result;

    @ColumnInfo(name = "category_name")
    public String name;

    @Override
    public String toString() {
        return expression + " = " + result + " (" + name + ")";
    }
}
