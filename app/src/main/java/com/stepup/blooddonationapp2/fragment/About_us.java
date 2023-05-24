package com.stepup.blooddonationapp2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.databinding.FragmentAboutUsBinding;


public class About_us extends Fragment {



    private SupportMapFragment mapFragment;
private FrameLayout frameLayout;

    public About_us() {
        // Required empty public constructor
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAboutUsBinding binding = FragmentAboutUsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        if (mapFragment == null) {
            mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapContainer);
            if (mapFragment == null) {
                mapFragment = SupportMapFragment.newInstance();
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.mapContainer, mapFragment)
                        .commit();
            }
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    LatLng latLng = new LatLng(21.241780980135385, 72.87644025247083);
                    googleMap.addMarker(new MarkerOptions().position(latLng)
                            .title("Stepup Technosys"));

                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    googleMap.animateCamera(CameraUpdateFactory.zoomIn());
                    googleMap.animateCamera(CameraUpdateFactory.zoomTo(5), 2000, null);

                    googleMap.getUiSettings().setZoomControlsEnabled(true);
                    googleMap.getUiSettings().setCompassEnabled(true);
                    googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                }
            });
        }

        return view;
    }

}