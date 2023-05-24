package com.stepup.blooddonationapp2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.FragmentPrivacyPolicyBinding;


public class Privacy_policy extends Fragment {

    FragmentPrivacyPolicyBinding binding;

    public Privacy_policy() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPrivacyPolicyBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}