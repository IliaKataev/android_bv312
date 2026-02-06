package com.example.secondlesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class InflaterActivity extends AppCompatActivity {

    private LinearLayout container;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflater);

        container = findViewById(R.id.container);
        buttonAdd = findViewById(R.id.button_add);

        buttonAdd.setOnClickListener(view -> addItem());
    }

    private void addItem() {
        LayoutInflater inflater = LayoutInflater.from(this);

        View item = inflater.inflate(R.layout.item_text, container, false);

        container.addView(item);

    }
}
