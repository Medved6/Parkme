package com.example.sergewsevolojsky.parkme.network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.models.Reservation;
import com.example.sergewsevolojsky.parkme.models.User;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sergewsevolojsky on 12/06/16.
 */
public class ReservationNetworkManager {


    public interface ReservationResultListener {
        void onFindReservations(ArrayList<Reservation> reservations);

        void onFail();
    }

    public static void findReservationByStatus(int id , int status,  final ReservationResultListener listener) {

        String url = UrlBuilder.getReservationsByStatusUrl(id, status);

        JacksonRequest<Reservation[]> request = new JacksonRequest<Reservation[]>(Request.Method.GET, url, new JacksonRequestListener<Reservation[]>() {
            @Override
            public void onResponse(Reservation[] response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null) {
                            listener.onFindReservations(new ArrayList<>(Arrays.asList(response)));
                        }
                    }
                }

            }

            @Override
            public JavaType getReturnType() {
                return ArrayType.construct(SimpleType.construct(Reservation.class), null, null);
            }
        });

        MyApp.getInstance().getRequestQueue().add(request);
    }
}
