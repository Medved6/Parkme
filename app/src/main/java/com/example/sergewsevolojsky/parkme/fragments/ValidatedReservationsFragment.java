package com.example.sergewsevolojsky.parkme.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.activity.LoginActivity;
import com.example.sergewsevolojsky.parkme.activity.ReservationDetailActivity;
import com.example.sergewsevolojsky.parkme.activity.ReservationsActivity;
import com.example.sergewsevolojsky.parkme.adapter.ValidatedReservationsAdapter;
import com.example.sergewsevolojsky.parkme.models.Reservation;
import com.example.sergewsevolojsky.parkme.models.Spots;
import com.example.sergewsevolojsky.parkme.models.User;
import com.example.sergewsevolojsky.parkme.network.ReservationNetworkManager;
import com.example.sergewsevolojsky.parkme.network.SpotsNetworkManager;
import com.example.sergewsevolojsky.parkme.network.UserNetworkManager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ValidatedReservationsFragment extends Fragment {


    private static final String DEBUG_TAG = "Toto";
    private View rootView;
    private android.view.MotionEvent MotionEvent;

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

        final ValidatedReservationsAdapter validatedReservationsAdapter = new ValidatedReservationsAdapter(getContext());

        ListView listView = (ListView) rootView.findViewById(R.id.validated_reservation_listView);
        listView.setDivider(null);

        // CLICK
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i("CLICK", "Position=" + position);

                Reservation reservation = validatedReservationsAdapter.getItem(position);

                Log.i("RESERVATION ID", "SPOT ID=" + reservation.getStreet());

                displayReservationDetailFragment(reservation);

            }
        });

        listView.setAdapter(validatedReservationsAdapter);







        // VALIDATE RESERVATION REQUEST

        ReservationNetworkManager.findReservationByStatus(0,0, new ReservationNetworkManager.ReservationResultListener() {
            @Override
            public void onFindReservations(ArrayList<Reservation> reservations) {
                Log.e("RESERVATIONS",reservations.toString());

                if(!reservations.isEmpty()){
                    validatedReservationsAdapter.refresh(reservations);
                } else {
                    Log.i("RESERVATION", "EMPTY");

                }

            }

            @Override
            public void onFail() {}
        });




        return rootView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();

    }


    private void displayReservationDetailFragment(Reservation reservation) {


        SpotsNetworkManager.findSpotById(reservation.getSpotId(), new SpotsNetworkManager.SpotsIdResultListener() {
            @Override
            public void onFindSpotsById(ArrayList<Spots> spot) {

                Log.e("RESERVATIONS",spot.get(0).getCity());

                Intent intent = new Intent(MyApp.getInstance(), ReservationDetailActivity.class);
                intent.putExtra(ReservationDetailActivity.ARGUMENT_MOVIE, spot.get(0));
                startActivity(intent);

            }

            @Override
            public void onFail() {}
        });


    }

}
