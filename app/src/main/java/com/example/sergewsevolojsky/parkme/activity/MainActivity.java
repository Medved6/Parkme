package com.example.sergewsevolojsky.parkme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.fragments.MarkerDetailFragment;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;


import com.mapbox.mapboxsdk.maps.MapView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends NavigationDrawerParentActivity
         {


    private MapView mapView;
    private MarkerOptions markerOptions;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);

        setNavigation();




        if(!MyApp.getInstance().sessionID){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }


        // Create a mapView
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {

                        long markerId = marker.getId();

                        MarkerDetailFragment markerDetailFragment = new MarkerDetailFragment();

                        getSupportFragmentManager()
                                .beginTransaction()
                                //.setCustomAnimations(R.anim.enter_animation, R.anim.enter_animation)
                                .add(R.id.marker_detail_container, markerDetailFragment)
                                .addToBackStack(null)
                                .commit();


                        return true;
                    }
                });

                MarkerOptions markerOptions = new MarkerOptions()
                        .position(new LatLng(48.851867, 2.419921))
                        .title("Maison d'Anne Usse")
                        .snippet("rue 27 xDenlaron Delle");


                // Il te faut un id
                markerOptions.getMarker().setId(5012);

                mapboxMap.addMarker(markerOptions);
            }
        });

    }




    // MAP BOX METHODS
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }




}
