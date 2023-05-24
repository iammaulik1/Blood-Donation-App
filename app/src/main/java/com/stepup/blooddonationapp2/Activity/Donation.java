package com.stepup.blooddonationapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.ActivityDonationBinding;

import java.util.Calendar;

public class Donation extends AppCompatActivity {

    private ActivityDonationBinding binding;
    Dialog dialog;
    EditText edt_state, edt_city, edt_donationplace;
    Button selectlocation, submit, selectdate;
    private static final int REQUEST_LOCATION_SELECTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityDonationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Donation History");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(Donation.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_add_history);

                selectdate = dialog.findViewById(R.id.edt_selectdate);
                edt_state = dialog.findViewById(R.id.edt_state);
                edt_city = dialog.findViewById(R.id.edt_city);
                selectlocation = dialog.findViewById(R.id.btn_selectlocation);
                edt_donationplace = dialog.findViewById(R.id.edt_donationplace);
                submit = dialog.findViewById(R.id.btn_history);


                selectdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar calendar = Calendar.getInstance();
                        DatePickerDialog datePickerDialog = new DatePickerDialog(Donation.this, AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {

                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                Calendar newDate = Calendar.getInstance();
                                newDate.set(year, monthOfYear, dayOfMonth);

                                selectdate.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
                                selectdate.setTextColor(getResources().getColor(R.color.red_500));
                            }

                        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                        datePickerDialog.show();
                    }

                });

                selectlocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Donation.this, LocationSelectionActivity.class);
                        startActivityForResult(intent, REQUEST_LOCATION_SELECTION);
                    }
                });

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    dialog.dismiss();
                    }
                });


                dialog.show();


            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate user backward when back button is clicked
        return true;
    }
}