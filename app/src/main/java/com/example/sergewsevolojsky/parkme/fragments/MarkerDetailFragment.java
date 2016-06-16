package com.example.sergewsevolojsky.parkme.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.activity.MainActivity;
import com.example.sergewsevolojsky.parkme.models.Spots;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarkerDetailFragment extends Fragment {


    private static final String DESCRIBABLE_KEY = "MARKER_ARGUMENT";
    private static Spots spot_marker;

    public MarkerDetailFragment() {
        // Required empty public constructor
    }


    public static MarkerDetailFragment newInstance(Spots spot) {
        
        Bundle args = new Bundle();

        spot_marker = spot;


        MarkerDetailFragment fragment = new MarkerDetailFragment();
        fragment.setArguments(args);







        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_marker_detail, container, false);




        TextView distance_textview = (TextView) rootView.findViewById(R.id.distance_reservation_textview);
        TextView price_textview = (TextView) rootView.findViewById(R.id.price_reservation_textview);
        TextView rate_textview = (TextView) rootView.findViewById(R.id.rate_reservation_textview);


        String newDistance = Integer.toString(spot_marker.getDistance()) + "m";
        String newPrice = Integer.toString(spot_marker.getPrice()) + "€";
        String newRate = Integer.toString(spot_marker.getRate()) + "/5";

        distance_textview.setText(newDistance);
        price_textview.setText(newPrice);
        rate_textview.setText(newRate);



        // Inflate the layout for this fragment
        return rootView;
    }



    public void updateInfo(){



    }




}
