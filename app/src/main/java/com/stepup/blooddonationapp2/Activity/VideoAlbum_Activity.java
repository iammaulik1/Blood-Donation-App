package com.stepup.blooddonationapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.ActivityVideoAlbumBinding;

public class VideoAlbum_Activity extends AppCompatActivity {

    private ActivityVideoAlbumBinding binding;


    private VideoView videoPlayer;
    private TextView videoDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityVideoAlbumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.videoAlbumToolbar);
        getSupportActionBar().setTitle("Video Album");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        VideoView videoView = findViewById(R.id.video_player);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri onlineUri = Uri.parse("https://media.istockphoto.com/id/994594020/video/rider-in-a-yellow-whitewater-kayak-dropping-a-waterfall.mp4?s=mp4-640x640-is&k=20&c=6Mj3GfJ6a6rvceh-ARvcSWSBoB4zw36f6HAJ5vWdSqQ=");
        Uri offlineUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(onlineUri);
//videoView.setVideoURI(offlineUri);
        videoView.requestFocus();
        videoView.start();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate user backward when back button is clicked
        return true;
    }
}