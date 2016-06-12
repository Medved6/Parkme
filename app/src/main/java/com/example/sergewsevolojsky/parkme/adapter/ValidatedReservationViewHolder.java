package com.example.sergewsevolojsky.parkme.adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.models.Reservation;

/**
 * Created by sergewsevolojsky on 08/06/16.
 */
public class ValidatedReservationViewHolder {

    private TextView reservationNameTextView;

    public ValidatedReservationViewHolder(View itemView) {

        // ButterKnife.bind(this, itemView);

        reservationNameTextView = (TextView) itemView.findViewById(R.id.reservation_name_textview);
    }

    public void setReservation(Reservation reservations){
        reservationNameTextView.setText(reservations.getCity());
        Log.i("toto","ok");
    }
}
