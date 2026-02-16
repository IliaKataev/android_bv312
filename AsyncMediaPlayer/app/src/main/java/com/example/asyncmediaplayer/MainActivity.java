package com.example.asyncmediaplayer;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.asyncmediaplayer.AudioFragment.AudioFragment;
import com.example.asyncmediaplayer.VideoFragment.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
           if(item.getItemId() == R.id.nav_audio){
               loadFragment(new AudioFragment());
               return true;
           } else if(item.getItemId() == R.id.nav_video) {
               loadFragment(new VideoFragment());
               return true;
           }
           return false;
        });
    }

    private void loadFragment(Fragment Fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, Fragment)
                .commit();
    }
}


/*

Мобильное приложение на Java, которое реализует 3 основные идеи:
1. Аудио и медиа проигрыватель. Выбор: просмотр видео или прослушивание аудио
2. Асинхронность ???
3. Material Design. Использование основных принципов, рекомендаций и ?шаблонов?





 */