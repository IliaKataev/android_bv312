package com.example.secondlesson;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import kotlin.internal.PlatformDependent;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = findViewById(R.id.spinner);
        textResult = findViewById(R.id.text_result);

        String[] options = {
                "Java",
                "Kotlin",
                "C#",
                "C++",
                "Swift",
                "Python",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                options
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                String selected = options[i];
                textResult.setText("Вы выбрали: " + selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

        });

    }
}
