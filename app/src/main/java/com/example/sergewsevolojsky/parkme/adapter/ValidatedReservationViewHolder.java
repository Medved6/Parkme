package com.example.sergewsevolojsky.parkme.adapter;

import android.view.View;
import android.widget.TextView;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.models.Reservation;

/**
 * Created by sergewsevolojsky on 08/06/16.
 */
public class ValidatedReservationViewHolder {

    private TextView reservationNameTextview;

    public ValidatedReservationViewHolder(View itemView) {

        // ButterKnife.bind(this, itemView);

        reservationNameTextview = (TextView) itemView.findViewById(R.id.reservation_name_textview);
    }

    public void setReservation(Reservation reservation){
        //reservationNameTextview.setText(reservation.getSpotId());
    }
}
