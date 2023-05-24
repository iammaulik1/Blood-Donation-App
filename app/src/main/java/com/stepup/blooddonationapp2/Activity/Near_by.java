package com.stepup.blooddonationapp2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.stepup.blooddonationapp2.databinding.ActivityNearByBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Near_by extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityNearByBinding binding;
    private HashMap<Marker, String> markerTextMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNearByBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.nearByToolbar);
        getSupportActionBar().setTitle("Near By Donors");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        // Set the marker click listener
        mMap.setOnMarkerClickListener(this);

        // Initialize the marker-text map
        markerTextMap = new HashMap<>();

        // Add nearby users' markers with green pins and associated text
        addNearbyUsersMarkers();

        // Add user's own location marker with a red pin and associated text
        addUserLocationMarker();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        // Retrieve the associated text for the clicked marker
        String markerText = markerTextMap.get(marker);

        if (markerText != null) {
            // Show a text message in an info window when a marker is clicked
            marker.setSnippet(markerText);
            marker.showInfoWindow();
        }

        return true;
    }

    private void addNearbyUsersMarkers() {
        // Get the nearby user locations and associated text (you can replace this with your own logic)
        HashMap<LatLng, String> nearbyUserLocations = getNearbyUserLocations();

        // Add markers for each nearby user location and associate the respective text
        for (LatLng location : nearbyUserLocations.keySet()) {
            String markerText = nearbyUserLocations.get(location);

            MarkerOptions markerOptions = new MarkerOptions()
                    .position(location)
                    .title(markerText) // Set the title for the marker
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            Marker marker = mMap.addMarker(markerOptions);
            markerTextMap.put(marker, markerText);
        }
    }

    private void addUserLocationMarker() {
        // Get the user's own location and associated text (you can replace this with your own logic)
        LatLng userLocation = getUserLocation();
        String markerText = "Your Location";

        // Add a marker for the user's own location and associate the respective text
        MarkerOptions markerOptions = new MarkerOptions()
                .position(userLocation)
                .title(markerText) // Set the title for the marker
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        Marker marker = mMap.addMarker(markerOptions);
        markerTextMap.put(marker, markerText);
    }

    // Replace this method with your own logic to get nearby user locations and associated text
    private HashMap<LatLng, String> getNearbyUserLocations() {
        HashMap<LatLng, String> nearbyUserLocations = new HashMap<>();
        // Add nearby user locations and associated text to the map
        // Example:
        nearbyUserLocations.put(new LatLng(21.223241427615687, 72.79052048951344), "Pahal Hospital");
        nearbyUserLocations.put(new LatLng(21.21019931990672, 72.77352601286486), " Dhwani Hospital");
        nearbyUserLocations.put(new LatLng(21.198516453780258, 72.7950695160911), "Parth Hospital");
        return nearbyUserLocations;
    }

    private LatLng getUserLocation() {
        // Return the user's own location
        // Example:

        LatLng userLocation = new LatLng(21.20867782770039, 72.78915646876415);

        // Move the camera to the user's city
        float zoomLevel = 12.0f; // Adjust the zoom level as needed
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, zoomLevel));

        return userLocation;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Navigate user backward when back button is clicked
        return true;
    }
}