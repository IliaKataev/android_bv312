package com.example.secondlesson;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private ListView historyListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        historyListView = findViewById(R.id.history_list);
        dbHelper = new DatabaseHelper(this);

        List<String> historyList = dbHelper.getHistory();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                historyList);

        historyListView.setAdapter(adapter);
    }

}
