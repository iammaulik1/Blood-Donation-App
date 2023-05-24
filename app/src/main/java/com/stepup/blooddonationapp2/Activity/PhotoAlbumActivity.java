package com.stepup.blooddonationapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.stepup.blooddonationapp2.databinding.ActivityPhotoAlbumBinding;

public class PhotoAlbumActivity extends AppCompatActivity {

    private ActivityPhotoAlbumBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityPhotoAlbumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.photoAlbumToolbar);
        getSupportActionBar().setTitle("Photo Gallery");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate user backward when back button is clicked
        return true;
    }
}