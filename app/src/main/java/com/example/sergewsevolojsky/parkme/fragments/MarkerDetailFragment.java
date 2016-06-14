package com.example.sergewsevolojsky.parkme.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarkerDetailFragment extends Fragment {


    public MarkerDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_marker_detail, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }




}
