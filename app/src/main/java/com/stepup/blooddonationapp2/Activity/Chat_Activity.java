package com.stepup.blooddonationapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.ActivityChatBinding;

import java.text.BreakIterator;

public class Chat_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActivityChatBinding binding;
    private Toolbar mToolbar;
    RecyclerView chat_recycler;
    String[] Bloodgroup = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    Spinner spinbg;
    String bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.youtubeToolbar);
        getSupportActionBar().setTitle("Chats");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });

        binding.card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open chat layout when card view is clicked
                openChatLayout();
            }
        });






    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate user backward when back button is clicked
        return true;
    }

    private void openChatLayout() {
        Intent intent = new Intent(this, ChatLayoutActivity.class);
        startActivity(intent);
    }

}