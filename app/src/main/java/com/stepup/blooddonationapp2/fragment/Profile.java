package com.stepup.blooddonationapp2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.stepup.blooddonationapp2.Activity.EditProfile;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.Util.SharedPrefUtil;
import com.stepup.blooddonationapp2.databinding.FragmentProfileBinding;

public class Profile extends Fragment {

    FragmentProfileBinding binding;

    //Button btn_edit_profile;
    //TextView p_name, p_email, p_age, p_gender, p_mobile, p_bg, p_weight, p_state, p_city;


    @Override
    public void onResume() {
        super.onResume();

        /*binding.pName.setText(new SharedPrefUtil(getActivity()).getString("name"));
        binding.pEmail.setText(new SharedPrefUtil(getActivity()).getString("email"));
        binding.pAge.setText(new SharedPrefUtil(getActivity()).getString("bd"));
        binding.pGender.setText(new SharedPrefUtil(getActivity()).getString("gender"));
        binding.pMobile.setText(new SharedPrefUtil(getActivity()).getString("mobile"));
        binding.pBg.setText(new SharedPrefUtil(getActivity()).getString("blood_group"));
        binding.pWeight.setText(new SharedPrefUtil(getActivity()).getString("weight"));
        binding.pState.setText(new SharedPrefUtil(getActivity()).getString("state"));
        binding.pCity.setText(new SharedPrefUtil(getActivity()).getString("city"));*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_profile, container, false);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);

       /* btnEditProfile = view.findViewById(R.id.btn_edit_profile);
        p_name = view.findViewById(R.id.p_name);
        p_email = view.findViewById(R.id.p_email);
        p_age = view.findViewById(R.id.p_age);
        p_gender = view.findViewById(R.id.p_gender);
        p_mobile = view.findViewById(R.id.p_mobile);
        p_bg = view.findViewById(R.id.p_bg);
        p_weight = view.findViewById(R.id.p_weight);
        p_state = view.findViewById(R.id.p_state);
        p_city = view.findViewById(R.id.p_city);*/



/*

        new SharedPrefUtil(Login.this).saveString("name", response.body().getData().get(i).getName());
        new SharedPrefUtil(Login.this).saveString("mobile", response.body().getData().get(i).getMobileNo());
        new SharedPrefUtil(Login.this).saveString("user_id", response.body().getData().get(i).getUserId());
        new SharedPrefUtil(Login.this).saveString("UID", response.body().getData().get(i).getUID());
        new SharedPrefUtil(Login.this).saveString("blood_group", response.body().getData().get(i).getBloodGroup());
        new SharedPrefUtil(Login.this).saveString("ic_white_email", response.body().getData().get(i).getEmail());
        new SharedPrefUtil(Login.this).saveString("age", response.body().getData().get(i).getAge());
        new SharedPrefUtil(Login.this).saveString("city", response.body().getData().get(i).getCity() );
        new SharedPrefUtil(Login.this).saveString("state", response.body().getData().get(i).getState());
        new SharedPrefUtil(Login.this).saveString("gender", response.body().getData().get(i).getGender());
*/


        binding.btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditProfile.class));
            }
        });

        return binding.getRoot();
    }

}