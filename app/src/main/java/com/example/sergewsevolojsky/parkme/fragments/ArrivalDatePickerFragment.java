package com.example.sergewsevolojsky.parkme.fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.models.Reservation;
import com.example.sergewsevolojsky.parkme.models.ReservationDate;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArrivalDatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    int year = 2016;
    int month = 5;
    int day = 15;


    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        // Use the current date as the default date in the picker



        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int newYear, int newMonth, int newDay) {

        ReservationDate date = new ReservationDate();

        date.setDay(newDay);
        date.setMonth(newMonth);
        date.setYear(newYear);

        //String[] monthes = {"Jan","Feb","Mar","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};

        Button arrival = (Button) getActivity().findViewById(R.id.arrival_picker_button);

        year = newYear;
        month = newMonth;
        day = newDay;

        String newButtonText = Integer.toString(date.getDay()) + " " + date.getMonth() + " - " + date.getYear();

        arrival.setText(newButtonText);

        MapSearchFragment.getInstance().setArrivalDate(date);

    }
}
