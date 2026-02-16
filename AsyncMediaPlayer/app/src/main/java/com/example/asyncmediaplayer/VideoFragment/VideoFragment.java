package com.example.asyncmediaplayer.VideoFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import com.example.asyncmediaplayer.PlayerService.PlayerActivity;
import com.example.asyncmediaplayer.R;

public class VideoFragment extends Fragment {

    private ActivityResultLauncher<String> videoPickerLauncher;
    private Button playButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        videoPickerLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
            if (uri != null) {
                Intent intent = new Intent(getActivity(), PlayerActivity.class);
                intent.putExtra("MEDIA_URI", uri.toString());
                startActivity(intent);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, container, false);
        playButton = view.findViewById(R.id.btn_play_video);

        playButton.setOnClickListener(v -> {
            videoPickerLauncher.launch("video/*");
        });
        return view;
    }
}
