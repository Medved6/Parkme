package com.example.sergewsevolojsky.parkme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.models.Reservation;

import java.util.ArrayList;

/**
 * Created by sergewsevolojsky on 08/06/16.
 */
public class ValidatedReservationsAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Reservation> reservations;

    @Override
    public int getCount() {
        return reservations.size();
    }

    @Override
    public Reservation getItem(int position) {
        return reservations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ValidatedReservationViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.validated_reservation_list_item, null);
            holder = new ValidatedReservationViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ValidatedReservationViewHolder) convertView.getTag();
        }

        holder.setReservation(reservations.get(position));

        return convertView;
    }

    public ValidatedReservationsAdapter(Context context) {
        this.reservations = new ArrayList<>();
        this.context = context;
    }

    public void refresh(ArrayList<Reservation> reservations){
        this.reservations.clear();
        this.reservations.addAll(reservations);
        notifyDataSetChanged();
    }
}
