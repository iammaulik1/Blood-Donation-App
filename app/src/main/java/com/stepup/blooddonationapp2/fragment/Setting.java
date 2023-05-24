package com.stepup.blooddonationapp2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.stepup.blooddonationapp2.Activity.ChangePassword;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.Util.SharedPrefUtil;
import com.stepup.blooddonationapp2.databinding.FragmentSettingBinding;


public class Setting extends Fragment {

    FragmentSettingBinding binding;

    //TextView changepass;
    Fragment fragment;
    //Switch notificationswitch;

    public Setting() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View v = inflater.inflate(R.layout.fragment_setting, container, false);

        binding = FragmentSettingBinding.inflate(inflater,container,false);
        setHasOptionsMenu(true);

        //changepass = v.findViewById(R.id.text_changepassword);
        //notificationswitch = v.findViewById(R.id.notificationswitch);


        if (new SharedPrefUtil((getActivity())).getBoolean("ntf", true)) {
            binding.notificationswitch.setChecked(true);
        } else {
            binding.notificationswitch.setChecked(false);
        }

        binding.notificationswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    new SharedPrefUtil(getActivity()).saveBoolean("ntf", true);
                    Toast.makeText(getActivity(), String.valueOf(new SharedPrefUtil(getActivity()).getBoolean("ntf")), Toast.LENGTH_SHORT);
                } else {
                    new SharedPrefUtil(getActivity()).saveBoolean("ntf", false);
                    Toast.makeText(getActivity(), String.valueOf(new SharedPrefUtil(getActivity()).getBoolean("ntf")), Toast.LENGTH_SHORT);
                }
            }
        });


        binding.textChangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ChangePassword.class);
                startActivity(i);
            }
        });

        return binding.getRoot();
    }
}