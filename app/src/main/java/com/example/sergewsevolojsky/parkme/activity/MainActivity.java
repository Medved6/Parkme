package com.example.sergewsevolojsky.parkme.activity;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.fragments.MapSearchFragment;
import com.example.sergewsevolojsky.parkme.fragments.MarkerDetailFragment;
import com.example.sergewsevolojsky.parkme.models.Spots;
import com.example.sergewsevolojsky.parkme.network.SpotsNetworkManager;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.ArrayList;

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








        // Create a mapView
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        MapSearchFragment mapSearchFragment = new MapSearchFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map_search_bar, mapSearchFragment)
                .addToBackStack(null)
                .commit();


        float lat = (float) 48.858124;
        float lon = (float) 2.35742;


        SpotsNetworkManager.findSpots(lat, lon, new SpotsNetworkManager.SpotsResultListener() {
            @Override
            public void onFindSpots(ArrayList<Spots> spots) {

                createMap(spots);

                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFail() {
                Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
            }
        });






    }



    private void createMap(final ArrayList<Spots> spots) {



        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {


                mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {

                        long markerId = marker.getId();

                        MarkerDetailFragment markerDetailFragment = new MarkerDetailFragment();

                        FragmentTransaction ft = getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.enter_animation, R.anim.enter_animation)
                                .add(R.id.marker_detail_container, markerDetailFragment)
                                .addToBackStack(null);



                        markerDetailFragment.newInstance(spots.get((int) markerId));

                        ft.commit();



                        return true;
                    }
                });


                for(int i = 0; i < spots.size(); i++){
                    Log.e("MAP SPOT LAT", Float.toString(spots.get(i).getLat()));
                    Log.e("MAP SPOT LON", Float.toString(spots.get(i).getLon()));

                    MarkerOptions markerOptions = new MarkerOptions()
                            .position(new LatLng(spots.get(i).getLat(), spots.get(i).getLon()));



                    // Il te faut un id
                    markerOptions.getMarker().setId(i);

                    mapboxMap.addMarker(markerOptions);

                }


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
