package com.example.secondlesson;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.secondlesson.room.AppDataBase;
import com.example.secondlesson.room.CategoryEntity;
import com.example.secondlesson.room.HistoryEntity;

import java.util.ArrayList;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity {

    private EditText display;
    private int firstNumber = 0;
    private String operation = "";
    private boolean isNewInput = true;
    private AppDataBase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        display = findViewById(R.id.display);

        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "my-database").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        CategoryEntity category = db.categoryDAO().getByName("Обычные");

        if(category == null){
            category = new CategoryEntity();
            category.name = "Обычные";
            long newId = db.categoryDAO().insert(category);
            category.id = (int)newId;
        }

        Button buttonHistory = findViewById(R.id.button_history);
        buttonHistory.setOnClickListener(v -> startActivity(new Intent(this, HistoryActivity.class)));

    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        if (isNewInput) {
            display.setText("");
            isNewInput = false;
        }
        display.append(button.getText());
    }

    public void onOperationClick(View view) {
        Button button = (Button) view;
        firstNumber = Integer.parseInt(display.getText().toString());
        operation =  button.getText().toString();
        isNewInput = true;
    }

    public void onEqual(View view){
        int secondNumber = Integer.parseInt(display.getText().toString());
        int result = 0;

        switch (operation){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if(secondNumber != 0){
                    result = firstNumber / secondNumber;
                }else{
                    display.setText("Error");
                    return;
                }
                break;
        }

        display.setText(String.valueOf(result));

        CategoryEntity category = db.categoryDAO().getByName("Обычные");

        HistoryEntity history = new HistoryEntity();
        history.expression = firstNumber + " " + operation + " " + secondNumber;
        history.result = String.valueOf(result);
        history.category_id = category.id;

        db.historyDAO().insert(history);


        isNewInput = true;
    }

    public void onClear(View view){
        display.setText("0");
        firstNumber = 0;
        operation = "";
        isNewInput = true;
    }


}