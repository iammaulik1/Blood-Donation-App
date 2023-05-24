package com.stepup.blooddonationapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.ActivityChatLayoutBinding;

public class ChatLayoutActivity extends AppCompatActivity {

    private ActivityChatLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.userChatToolbar);
        getSupportActionBar().setTitle("Chats");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate user backward when back button is clicked
        return true;
    }
}