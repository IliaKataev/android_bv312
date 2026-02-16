package com.example.asyncmediaplayer.PlayerService;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import com.example.asyncmediaplayer.R;

public class PlayerActivity extends AppCompatActivity {
    private ExoPlayer player;
    private PlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        playerView = findViewById(R.id.player_view);
        player = new ExoPlayer.Builder(this).build();

        playerView.setPlayer(player);
        String mediaUri = getIntent().getStringExtra("MEDIA_URI");

        if(mediaUri != null){
            Uri uri = Uri.parse(mediaUri);
            MediaItem mediaItem = MediaItem.fromUri(uri);
            player.setMediaItem(mediaItem);
            player.prepare();
            player.play();
        }
    }


    @Override
    protected void onStop(){
        super.onStop();
        if(player != null) {
            player.release();
        }
    }
}

