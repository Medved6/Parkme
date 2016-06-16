package com.example.sergewsevolojsky.parkme.adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.models.Reservation;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sergewsevolojsky on 08/06/16.
 */
public class ValidatedReservationViewHolder {


    @BindView(R.id.reservation_adress_textview)
    TextView reservationAdressTextView;

    @BindView(R.id.reservation_rental_arrival_date_textview)
    TextView reservationRentalArrivalDateTextView ;

    @BindView(R.id.reservation_rental_departure_date_textview)
    TextView reservationRentalDepartureDateTextView ;

    public ValidatedReservationViewHolder(View itemView) {

        ButterKnife.bind(this, itemView);

    }


    public void setReservation(Reservation reservations){


        String address = reservations.getStreet() + " " + reservations.getZipCode() + " " + reservations.getCity();

        reservationAdressTextView.setText(address);


        String arrival = Integer.toString(reservations.getRental().getArrival().getDay()) + " " + reservations.getRental().getArrival().getMonth() + " - " + Integer.toString(reservations.getRental().getArrival().getYear());
        String departure = Integer.toString(reservations.getRental().getDeparture().getDay()) + " " + reservations.getRental().getDeparture().getMonth() + " - " + Integer.toString(reservations.getRental().getDeparture().getYear());

        reservationRentalArrivalDateTextView.setText(arrival);
        reservationRentalDepartureDateTextView.setText(departure);



    }
}
