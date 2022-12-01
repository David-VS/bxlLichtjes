package be.ehb.bxllichtjes.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import be.ehb.bxllichtjes.R;
import be.ehb.bxllichtjes.model.Event;
import be.ehb.bxllichtjes.model.EventDAOMock;

public class FirstFragment extends Fragment {

    private GoogleMap mMap;
    private MapView mapView;

    private OnMapReadyCallback onMapReadyCallback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            mMap = googleMap;
            setupCamera();
            addMarkers();
        }
    };

    private void addMarkers() {
        ArrayList<Event> events = EventDAOMock.getEvents();

        for(Event e : events){
            float hue = 0;

            switch (e.getType()){
                case PROJECTION:
                    hue = BitmapDescriptorFactory.HUE_BLUE;
                    break;
                case INTERACTIVE:
                    hue = BitmapDescriptorFactory.HUE_GREEN;
                    break;
            }

            Marker m = mMap.addMarker(new MarkerOptions()
            .position(e.getPosition())
                    .title(e.getName())
                    .snippet(e.getDescription())
                    .icon(BitmapDescriptorFactory.defaultMarker(hue))
            );
        }
    }

    private void setupCamera() {
        LatLng bxlcoord = new LatLng(50.858712, 4.347446);
        CameraUpdate center = CameraUpdateFactory.newLatLngZoom(bxlcoord, 14);
        mMap.animateCamera(center);
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(onMapReadyCallback);

    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}