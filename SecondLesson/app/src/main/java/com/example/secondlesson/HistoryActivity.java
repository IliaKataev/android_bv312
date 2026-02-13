package com.example.secondlesson;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.secondlesson.models.HistoryItem;
import com.example.secondlesson.room.AppDataBase;
import com.example.secondlesson.room.HistoryEntity;
import com.example.secondlesson.room.HistoryWithCategory;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private ListView historyListView;
    private AppDataBase db;
    private ArrayAdapter<String> adapter;
    private List<HistoryWithCategory> historyList;
    private List<String> displayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyListView = findViewById(R.id.listView);

        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "my-database").allowMainThreadQueries().build();

        loadData();
        historyListView.setOnItemLongClickListener((parent, view, position, id) -> {
        new AlertDialog.Builder(this)
                  .setTitle("Удалить?")
                   .setMessage("Вы уверены, что хотите удалить эту запись?")
                   .setPositiveButton("Да", (dialog, which) -> {
                       HistoryWithCategory item = historyList.get(position);

                       HistoryEntity entityToDelete = new HistoryEntity();
                       entityToDelete.id = item.id;
                       db.historyDAO().delete(entityToDelete);

                       loadData();
                    })
                    .setNegativeButton("Нет", null)
                    .show();
            return true;
        });
    }

    private void loadData() {

        historyList = db.historyDAO().getHistoryWithCategory();
        displayList = new ArrayList<>();
        for (HistoryWithCategory item : historyList) {
            displayList.add(item.toString());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        historyListView.setAdapter(adapter);

    }


//    private DatabaseHelper dbHelper;
//    private ListView historyListView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_history);
//
//
//        historyListView = findViewById(R.id.listView);
//        dbHelper = new DatabaseHelper(this);
//
//        List<HistoryItem> historyList = dbHelper.getHistoryWithCategory();
//
//        ArrayAdapter<HistoryItem> adapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                historyList);
//
//        historyListView.setAdapter(adapter);
//
//        historyListView.setOnItemLongClickListener((parent, view, position, id) -> {
//            new AlertDialog.Builder(this)
//                    .setTitle("Удалить?")
//                    .setMessage("Вы уверены, что хотите удалить эту запись?")
//                    .setPositiveButton("Да", (dialog, which) -> {
//                        HistoryItem item = historyList.get(position);
//                        dbHelper.deleteItem(item.id);
//                        historyList.remove(position);
//                        adapter.notifyDataSetChanged();
//                    })
//                    .setNegativeButton("Нет", null)
//                    .show();
//            return true;
//        });
//    }
}
