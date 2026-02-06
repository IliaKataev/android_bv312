package com.example.secondlesson;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrientationActivity extends AppCompatActivity {

    private TextView textOrientation;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);

        textOrientation = findViewById(R.id.text_orientation);
        updateOrientationText(getResources().getConfiguration().orientation);
    }

    private void updateOrientationText(int orientation) {
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            textOrientation.setText("Книжный");
        }else if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            textOrientation.setText("Альбомный");
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateOrientationText(newConfig.orientation);
    }
}
