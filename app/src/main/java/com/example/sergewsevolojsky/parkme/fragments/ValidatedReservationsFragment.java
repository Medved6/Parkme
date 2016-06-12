package com.example.sergewsevolojsky.parkme.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.adapter.ValidatedReservationsAdapter;
import com.example.sergewsevolojsky.parkme.models.Reservation;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ValidatedReservationsFragment extends Fragment {


    private View rootView;

    public ValidatedReservationsFragment() {
        // Required empty public constructor
    }


    public static ValidatedReservationsFragment newInstance() {

        Bundle args = new Bundle();

        ValidatedReservationsFragment fragment = new ValidatedReservationsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_validated_reservations, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.validated_reservation_listview);

        ValidatedReservationsAdapter validatedReservationsAdapter = new ValidatedReservationsAdapter(getContext());
        listView.setAdapter(validatedReservationsAdapter);

        Reservation reservation;
        ArrayList<Reservation> reservations = new ArrayList<>();
        for (int i = 0; i<100; i++){
            reservation = new Reservation();
            //reservation.setSpotId(i);
            reservations.add(reservation);
        }

        validatedReservationsAdapter.refresh(reservations);

        return rootView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

    }


}
