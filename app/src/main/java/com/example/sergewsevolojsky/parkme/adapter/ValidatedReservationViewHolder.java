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


    @BindView(R.id.reservation_street_textview)
    TextView reservationStreetTextView;

    @BindView(R.id.reservation_zipcode_textview)
    TextView reservationZipCodeTextView;

    @BindView(R.id.reservation_city_textview)
    TextView reservationCityTextView ;

    @BindView(R.id.reservation_rental_arrival_day_textview)
    TextView reservationRentalArrivalDayTextView ;

    @BindView(R.id.reservation_rental_arrival_month_textview)
    TextView reservationRentalArrivalMonthTextView ;

    @BindView(R.id.reservation_rental_arrival_year_textview)
    TextView reservationRentalArrivalYearTextView ;

    @BindView(R.id.reservation_rental_departure_day_textview)
    TextView reservationRentalDepartureDayTextView ;

    @BindView(R.id.reservation_rental_departure_month_textview)
    TextView reservationRentalDepartureMonthTextView ;

    @BindView(R.id.reservation_rental_departure_year_textview)
    TextView reservationRentalDepartureYearTextView ;


    public ValidatedReservationViewHolder(View itemView) {

        ButterKnife.bind(this, itemView);

    }


    public void setReservation(Reservation reservations){



        reservationStreetTextView.setText(reservations.getStreet());
        reservationZipCodeTextView.setText(reservations.getZipCode());
        reservationCityTextView.setText(reservations.getCity());

        reservationRentalArrivalDayTextView.setText(Integer.toString(reservations.getSpotId()));
        reservationRentalArrivalMonthTextView.setText(reservations.getRental().getArrival().getMonth());
        reservationRentalArrivalYearTextView.setText(reservations.getRental().getArrival().getYear());

        reservationRentalDepartureDayTextView.setText(reservations.getRental().getDeparture().getDay());
        reservationRentalDepartureMonthTextView.setText(reservations.getRental().getDeparture().getMonth());
        reservationRentalDepartureYearTextView.setText(reservations.getRental().getDeparture().getYear());



    }
}
