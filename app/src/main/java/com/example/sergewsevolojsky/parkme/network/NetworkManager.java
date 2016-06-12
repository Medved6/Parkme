package com.example.sergewsevolojsky.parkme.network;

import android.os.Message;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.models.User;
import com.example.sergewsevolojsky.parkme.models.UserResult;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

/**
 * Created by sergewsevolojsky on 09/06/16.
 */
public class NetworkManager {


    public interface UserResultListener {
        void onFindUsers(User[] users);
        void onFail();
    }

    public static void findUsers(final UserResultListener listener) {
        //String url = "http://37.139.18.66/test";
        //String url = "http://swapi.co/api/people/1/";
        String url = UrlBuilder.getUserUrl();
        //String url = "http://medvedprod.fr/json/users.json";
        //String url = "https://dl.dropboxusercontent.com/s/s8jcxvttnjuw2a1/users.json";

        JacksonRequest<UserResult> request =
                new JacksonRequest<UserResult>(
                        Request.Method.GET,
                        url,
                        new JacksonRequestListener<UserResult>() {
                            @Override
                            public void onResponse(UserResult response, int statusCode, VolleyError error) {

                                if (error != null) {
                                    if (listener != null) {
                                        VolleyLog.e("Error: ", error.getMessage());
                                        listener.onFail();
                                    }
                                } else {
                                    if (response != null) {
                                        if (listener != null) {
                                            listener.onFindUsers(response.getUsers());
                                        }
                                    }
                                }

                            }

                            @Override
                            public JavaType getReturnType() {
                                return ArrayType.construct(SimpleType.construct(User.class), null, null);
                            }
                        }
                );

        MyApp
                .getInstance()
                .requestQueue
                .add(request);
    }


}
