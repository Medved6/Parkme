package com.example.sergewsevolojsky.parkme.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.models.ReservationDate;
import com.mapbox.geocoder.MapboxGeocoder;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapSearchFragment extends Fragment {

    /*@BindView(R.id.arrival_picker_button)
    Button arrival_picker_button;

    @BindView(R.id.departure_picker_button)
    Button departure_picker_button;*/

    View rootView;

    private static MapSearchFragment instance;
    Button arrival_picker_button = null;
    Button departure_picker_button = null;
    private ReservationDate arrivaleDate;
    private ReservationDate departureDate;

    public MapSearchFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // INSTANCE
        MapSearchFragment.instance = this;


        // DOM
        rootView = inflater.inflate(R.layout.fragment_map_search, container, false);
        arrival_picker_button = (Button) rootView.findViewById(R.id.arrival_picker_button);
        departure_picker_button = (Button) rootView.findViewById(R.id.departure_picker_button);




        //EVENTS
        arrival_picker_button.setOnClickListener(new View.OnClickListener(){

            DialogFragment newFragment = new ArrivalDatePickerFragment();

            @Override
            public void onClick(View v) {
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });
        departure_picker_button.setOnClickListener(new View.OnClickListener(){

            DialogFragment newFragment = new DepartureDatePickerFragment();



            @Override
            public void onClick(View v) {
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });






        // Inflate the layout for this fragment
        return rootView;
    }



    // GETTERS & SETTERS
    
    public void setArrivalDate(ReservationDate date){
        this.arrivaleDate = date;
    }
    public ReservationDate getArrivalDate() {
        return departureDate;
    }
    public void setDepartureDate(ReservationDate departureDate) {
        this.departureDate = departureDate;
    }
    public ReservationDate getDepartureDate() {
        return departureDate;
    }







    public static MapSearchFragment getInstance() {
        return instance;
    }

}
