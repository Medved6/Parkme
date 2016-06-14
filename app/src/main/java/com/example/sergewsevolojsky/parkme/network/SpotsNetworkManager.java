package com.example.sergewsevolojsky.parkme.network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.models.Reservation;
import com.example.sergewsevolojsky.parkme.models.Spots;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sergewsevolojsky on 14/06/16.
 */
public class SpotsNetworkManager {


// SPOT BY ID


    // LISTENER
    public interface SpotsIdResultListener {
        void onFindSpotsById(ArrayList<Spots> spots);

        void onFail();
    }


    // REQUEST
    public static void findSpotById(int id , final SpotsIdResultListener listener) {

        String url = UrlBuilder.getSpotByIdUrl(id);

        JacksonRequest<Spots[]> request = new JacksonRequest<Spots[]>(Request.Method.GET, url, new JacksonRequestListener<Spots[]>() {
            @Override
            public void onResponse(Spots[] response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null) {
                            listener.onFindSpotsById(new ArrayList<>(Arrays.asList(response)));
                        }
                    }
                }

            }

            @Override
            public JavaType getReturnType() {
                return ArrayType.construct(SimpleType.construct(Spots.class), null, null);
            }
        });

        MyApp.getInstance().getRequestQueue().add(request);
    }



    

// ALL SPOTS



    // LISTENER
    public interface SpotsResultListener {
        void onFindSpots(ArrayList<Spots> spots);

        void onFail();
    }



    // REQUEST
    public static void findSpots(int id , final SpotsResultListener listener) {

        String url = UrlBuilder.getSpotByIdUrl(id);

        JacksonRequest<Spots[]> request = new JacksonRequest<Spots[]>(Request.Method.GET, url, new JacksonRequestListener<Spots[]>() {
            @Override
            public void onResponse(Spots[] response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null) {
                            listener.onFindSpots(new ArrayList<>(Arrays.asList(response)));
                        }
                    }
                }

            }

            @Override
            public JavaType getReturnType() {
                return ArrayType.construct(SimpleType.construct(Spots.class), null, null);
            }
        });

        MyApp.getInstance().getRequestQueue().add(request);
    }





}
