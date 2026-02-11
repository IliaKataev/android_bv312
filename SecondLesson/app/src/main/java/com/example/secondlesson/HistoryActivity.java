package com.example.secondlesson;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.secondlesson.models.HistoryItem;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private ListView historyListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        historyListView = findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(this);

        List<HistoryItem> historyList = dbHelper.getHistory();

        ArrayAdapter<HistoryItem> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                historyList);

        historyListView.setAdapter(adapter);

        historyListView.setOnItemLongClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Удалить?")
                    .setMessage("Вы уверены, что хотите удалить эту запись?")
                    .setPositiveButton("Да", (dialog, which) -> {
                        HistoryItem item = historyList.get(position);
                        dbHelper.deleteItem(item.id);
                        historyList.remove(position);
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("Нет", null)
                    .show();
            return true;
        });
    }
}
