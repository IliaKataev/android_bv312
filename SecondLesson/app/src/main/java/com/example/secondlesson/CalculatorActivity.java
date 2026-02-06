package com.example.secondlesson;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    private EditText display;
    private int firstNumber = 0;
    private String operation = "";
    private boolean isNewInput = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        display = findViewById(R.id.display);
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
        isNewInput = true;
    }

    public void onClear(View view){
        display.setText("0");
        firstNumber = 0;
        operation = "";
        isNewInput = true;
    }
}