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


}
