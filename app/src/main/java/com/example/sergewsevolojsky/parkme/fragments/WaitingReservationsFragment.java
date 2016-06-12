package com.example.sergewsevolojsky.parkme.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergewsevolojsky.parkme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WaitingReservationsFragment extends Fragment {


    public WaitingReservationsFragment() {
        // Required empty public constructor
    }

    public static WaitingReservationsFragment newInstance() {

        Bundle args = new Bundle();

        WaitingReservationsFragment fragment = new WaitingReservationsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_waiting_reservations, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
    }
}
