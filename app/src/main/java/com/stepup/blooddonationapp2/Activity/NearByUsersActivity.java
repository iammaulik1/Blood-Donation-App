package com.stepup.blooddonationapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.stepup.blooddonationapp2.R;

import java.io.IOException;
import java.util.ArrayList;


public class NearByUsersActivity /*extends AppCompatActivity implements OnMapReadyCallback*/ {

    private GoogleMap mMap;
    /*private ActivityNearByBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNearByBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Enable zoom controls
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add nearby users' markers with green pins
        addNearbyUsersMarkers();

        // Add user's own location marker with a red pin
        addUserLocationMarker();
    }

    private void addNearbyUsersMarkers() {
        // Get the nearby user locations (you can replace this with your own logic)
        List<LatLng> nearbyUserLocations = getNearbyUserLocations();

        // Add markers for each nearby user location
        for (LatLng location : nearbyUserLocations) {
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(location)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            mMap.addMarker(markerOptions);
        }
    }

    private void addUserLocationMarker() {
        // Get the user's own location (you can replace this with your own logic)
        LatLng userLocation = getUserLocation();

        // Add a marker for the user's own location
        MarkerOptions markerOptions = new MarkerOptions()
                .position(userLocation)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mMap.addMarker(markerOptions);
    }

    // Replace these methods with your own logic to get nearby user locations and the user's own location
    private List<LatLng> getNearbyUserLocations() {
        List<LatLng> nearbyUserLocations = new ArrayList<>();
        // Add nearby user locations to the list
        // Example:
        nearbyUserLocations.add(new LatLng(37.7749, -122.4194));
        nearbyUserLocations.add(new LatLng(37.7740, -122.4200));
        nearbyUserLocations.add(new LatLng(37.7755, -122.4177));
        return nearbyUserLocations;
    }

    private LatLng getUserLocation() {
        // Return the user's own location
        // Example:
        return new LatLng(37.7749, -122.4194);
    }*/
}