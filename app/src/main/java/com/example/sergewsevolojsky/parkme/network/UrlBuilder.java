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

    public static String getUserLoginUrl(String email, String password) {
        return String.format("%s/users?email=%s&password=%s",BASE_url,email,password);
    }


    public static String getReservationsByStatusUrl(int id, int status){
        return String.format("%s/reservation?userId=%s&status=%s",BASE_url,id,status);
    }


    public static String getSpotByIdUrl(int id){
        return String.format("%s/spots?id=%s",BASE_url,id);
    }

    public static String getSpotsUrl(float lat, float lon){
        return String.format("%s/search?lat=%s&lon=%s",BASE_url,lat,lon);
    }


    public static String getSearchUrl(){
        return String.format("%s/spots",BASE_url);
    }



}
