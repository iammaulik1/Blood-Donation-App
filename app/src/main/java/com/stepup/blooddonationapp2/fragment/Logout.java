package com.stepup.blooddonationapp2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepup.blooddonationapp2.Activity.LoginActivity;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.FragmentLogoutBinding;


public class Logout extends Fragment {

    FragmentLogoutBinding binding ;

    public Logout() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentLogoutBinding.inflate(inflater,container,false);
        setHasOptionsMenu(true);

        binding.btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
            }
        });
        return binding.getRoot();
    }
}