package com.stepup.blooddonationapp2.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.ActivitySignupBinding;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;
    String[] Bloodgroup = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    String name, mobile, email, pasword, weight, age, city, state, gender, bloodgroup, birthdate, month, day, lat, lon, mVerificationId;

    int r_age, mYear;

    ////////////////////////////////////////////
    private static final int REQUEST_LOCATION_SELECTION = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.spinbloodgroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle when nothing is selected
            }
        });
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, Bloodgroup);
        binding.spinbloodgroup.setAdapter(aa);

        Places.initialize(getApplicationContext(), "AIzaSyBX-Pwz5MXoftEYncfmlHmIuVa0odTzH7w");////
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        binding.selectAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LocationSelectionActivity.class);
                startActivityForResult(intent, REQUEST_LOCATION_SELECTION);
            }
        });




        binding.edtbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final DatePickerDialog datePickerDialog = new DatePickerDialog(SignupActivity.this, AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        monthOfYear = monthOfYear + 1;
                        if (monthOfYear < 10) {
                            month = "0" + String.valueOf(monthOfYear);
                        } else {
                            month = String.valueOf(monthOfYear);
                        }
                        if (dayOfMonth < 10) {
                            day = "0" + String.valueOf(dayOfMonth);
                        } else {
                            day = String.valueOf(dayOfMonth);
                        }
                        mYear = year;
                        binding.edtbd.setText(year + "-" + month + "-" + day);
                        binding.edtbd.setTextColor(getResources().getColor(R.color.red_500));
                    }

                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

            }
        });

        binding.btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }



    ////////////////////////////////////////////////////////////////////////////////////

}