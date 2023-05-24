package com.stepup.blooddonationapp2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.FragmentBloodCompatibilityBinding;


public class Blood_compatibility extends Fragment {

    FragmentBloodCompatibilityBinding binding;


    public Blood_compatibility() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_blood_compatibility, container, false);

        binding = FragmentBloodCompatibilityBinding.inflate(inflater,container,false);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }
}