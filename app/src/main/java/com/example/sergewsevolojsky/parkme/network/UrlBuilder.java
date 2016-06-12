package com.example.sergewsevolojsky.parkme.network;

import java.text.Format;

/**
 * Created by sergewsevolojsky on 09/06/16.
 */
public class UrlBuilder {


    private final static String BASE_url = "http://37.139.18.66";


    public static String getUserUrl() {
        return String.format("%s/users",BASE_url);
    }

    public static String getSpotsUrl(){
        return String.format("%s/spots",BASE_url);
    }

    public static String getReservationsByStatusUrl(int position, int status){
        return String.format("%s/reservation?userId=0&status=0",BASE_url);
    }

    public static String getSpotByIdUrl(int id){
        return String.format("%s/spots/%s",BASE_url,id);
    }


}
