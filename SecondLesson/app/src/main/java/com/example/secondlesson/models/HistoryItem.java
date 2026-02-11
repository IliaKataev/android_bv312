package com.example.secondlesson.models;

public class HistoryItem {

    public int id;
    public String expression;

    public HistoryItem(int id, String expression) {
        this.id = id;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return expression;
    }

}
