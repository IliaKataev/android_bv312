package com.example.secondlesson;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container1, new FirstFragment())
                    .replace(R.id.container2, new SecondFragment())
                    .commit();
        }
    }
}
