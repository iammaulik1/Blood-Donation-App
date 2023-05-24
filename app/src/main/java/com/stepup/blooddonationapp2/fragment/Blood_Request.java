package com.stepup.blooddonationapp2.fragment;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.FragmentBloodRequestBinding;


public class Blood_Request extends Fragment {

    FragmentBloodRequestBinding binding;

    // FrameLayout frame;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    //Button btn_all_req, btn_my_req;
    static int flag = 1;

    public Blood_Request() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBloodRequestBinding.inflate(inflater,container,false);
        setHasOptionsMenu(true);


        fragment = new All_Request();
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
        // Inflate the layout for this fragment

        binding.btnAllReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 2) {
                    fragment = new All_Request();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame, fragment);
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction.commit();

                    binding.btnAllReq.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
                    binding.btnAllReq.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.red_500));

                    binding.btnMyReq.setTextColor(ContextCompat.getColor(getActivity(),R.color.black));
                    binding.btnMyReq.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.transparent));
                    flag = 1;

                }
            }
        });

        binding.btnMyReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 1) {
                    fragment = new My_Request();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame, fragment);
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction.commit();

                    binding.btnMyReq.setTextColor(getResources().getColor(R.color.white));
                    binding.btnMyReq.setBackgroundColor(getResources().getColor(R.color.red_500));

                    binding.btnAllReq.setTextColor(getResources().getColor(R.color.black));
                    binding.btnAllReq.setBackgroundColor(getResources().getColor(R.color.transparent));
                    flag = 2;

                }
            }
        });



        return binding.getRoot();
    }
}