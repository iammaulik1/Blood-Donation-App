package com.stepup.blooddonationapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.ActivitySendRequestBinding;

public class Send_Request extends AppCompatActivity  implements View.OnClickListener {

    private ActivitySendRequestBinding binding;

    String bloodgroup, lat, lon, message, city, state, mobile;
    private static final int REQUEST_LOCATION_SELECTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivitySendRequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.sendRequestToolbar);
        getSupportActionBar().setTitle("Send Request");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.btnap.setOnClickListener(this);
        binding.btnbp.setOnClickListener(this);
        binding.btnop.setOnClickListener(this);
        binding.btnabp.setOnClickListener(this);
        binding.btnan.setOnClickListener(this);
        binding.btnbn.setOnClickListener(this);
        binding.btnabn.setOnClickListener(this);
        binding.btnon.setOnClickListener(this);
        binding.btnLocation.setOnClickListener(this);
        binding.btnSendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnap:
                binding.btnap.setBackground(getResources().getDrawable(R.drawable.shape_circle));
                binding.btnbp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnop.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnan.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnon.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                bloodgroup = "A+";
                break;
            case R.id.btnbp:
                binding.btnbp.setBackground(getResources().getDrawable(R.drawable.shape_circle));
                binding.btnap.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnop.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnan.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnon.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                bloodgroup = "B+";
                break;
            case R.id.btnop:
                binding.btnop.setBackground(getResources().getDrawable(R.drawable.shape_circle));
                binding.btnap.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnan.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnon.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                bloodgroup = "O+";
                break;
            case R.id.btnabp:
                binding.btnabp.setBackground(getResources().getDrawable(R.drawable.shape_circle));
                binding.btnap.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnop.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnan.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnon.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                bloodgroup = "AB+";
                break;
            case R.id.btnan:
                binding.btnan.setBackground(getResources().getDrawable(R.drawable.shape_circle));
                binding.btnap.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnop.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnon.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                bloodgroup = "A-";
                break;
            case R.id.btnbn:
                binding.btnbn.setBackground(getResources().getDrawable(R.drawable.shape_circle));
                binding.btnap.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnop.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnan.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnon.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                bloodgroup = "B-";
                break;
            case R.id.btnon:
                binding.btnon.setBackground(getResources().getDrawable(R.drawable.shape_circle));
                binding.btnap.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnop.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnan.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                bloodgroup = "O-";
                break;
            case R.id.btnabn:
                binding.btnabn.setBackground(getResources().getDrawable(R.drawable.shape_circle));
                binding.btnap.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnop.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnabp.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnan.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnbn.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                binding.btnon.setBackground(getResources().getDrawable(R.drawable.shape_circle_outline));
                bloodgroup = "AB-";
                break;
            case R.id.btn_location:
               /* PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(Send_Request.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException |
                         GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }*/

                binding.btnLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Send_Request.this, LocationSelectionActivity.class);
                        startActivityForResult(intent, REQUEST_LOCATION_SELECTION);
                    }
                });
                break;
            case R.id.btn_send_request:

                /*if (binding.edtMobile.getText().toString().equals("")) {
                    binding.edtMobile.setError("Please Enter Mobile Number");
                } else if (binding.edtMobile.getText().toString().length() < 10) {
                    binding.edtMobile.setError("Please Enter Valid Mobile Number");
                } else if (binding.edtMsg.getText().toString().equals("")) {
                    binding.edtMsg.setError("Please Enter the Message");
                } else if (binding.btnLocation.getText().toString().equals("Select Location")) {
                    Toast.makeText(this, "Please Select Location From Map", Toast.LENGTH_SHORT);
                } else if (binding.edtCity.getText().toString().equals("")) {
                    binding.edtCity.setError("Please Enter the City Name");
                } else if (binding.edtState.getText().toString().equals("")) {
                    binding.edtState.setError("Please Enter the State Name");
                } else {
                    *//*send_req();*//*
                    Toast.makeText(this, "Request send Successfully", Toast.LENGTH_SHORT).show();
                }*/



                binding.btnSendRequest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Send_Request.this, "Your Request Sended Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Send_Request.this, DashboardActivity.class));
                    }
                });
                break;

        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate user backward when back button is clicked
        return true;
    }
}