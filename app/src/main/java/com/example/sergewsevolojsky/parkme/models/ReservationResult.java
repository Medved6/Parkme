package com.example.sergewsevolojsky.parkme.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergewsevolojsky on 12/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationResult {
    private Reservation[] reservations;

    public Reservation[] setReservations() { return reservations; }

    public void setReservations(Reservation[] reservations) { this.reservations = reservations; }
}