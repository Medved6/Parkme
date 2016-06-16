package com.example.sergewsevolojsky.parkme.network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.models.User;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergewsevolojsky on 09/06/16.
 */
public class UserNetworkManager {


// ALL USERS


    // LISTENER
    public interface UserResultListener {
        void onFindUsers(ArrayList<User> users);

        void onFail();
    }


    //METHOD
    public static void findUsers(final UserResultListener listener) {


        String url = UrlBuilder.getUserUrl();
        JacksonRequest<User[]> request = new JacksonRequest<>(Request.Method.GET, url, new JacksonRequestListener<User[]>() {
            @Override
            public void onResponse(User[] response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null) {
                            listener.onFindUsers(new ArrayList<>(Arrays.asList(response)));
                        }
                    }
                }

            }

            @Override
            public JavaType getReturnType() {
                return ArrayType.construct(SimpleType.construct(User.class), null, null);
            }
        });

        MyApp.getInstance().getRequestQueue().add(request);
    }







// TEST LOGIN USER


    // LISTENER
    public interface UserLoginResultListener {
        void onFindUsersLogin(ArrayList<User> users);

        void onFail();
    }


    //METHOD
    public static void findUsersLogin(String email, String password, final UserLoginResultListener listener) {


        String url = UrlBuilder.getUserLoginUrl(email, password);
        JacksonRequest<User[]> request = new JacksonRequest<>(Request.Method.GET, url, new JacksonRequestListener<User[]>() {
            @Override
            public void onResponse(User[] response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null) {
                            listener.onFindUsersLogin(new ArrayList<>(Arrays.asList(response)));
                        }
                    }
                }

            }

            @Override
            public JavaType getReturnType() {
                return ArrayType.construct(SimpleType.construct(User.class), null, null);
            }
        });

        MyApp.getInstance().getRequestQueue().add(request);
    }








// USER REGISTER


    // LISTENER
    public interface UserRegisterResultListener {
        void onRegisterUsers(ArrayList<User> users);

        void onFail();
    }


    //METHOD
    public static void registerUsers(final UserRegisterResultListener listener) {


        Map<String,String> params = new HashMap<String, String>();
        params.put("Content-Type","application/x-www-form-urlencoded");
        params.put("name","Flora Nalle");


        //String url = UrlBuilder.getUserLoginUrl(email, password);
        JacksonRequest<User[]> request = new JacksonRequest<>(Request.Method.POST, "http://37.139.18.66/users", params, new JacksonRequestListener<User[]>() {
            @Override
            public void onResponse(User[] response, int statusCode, VolleyError error) {

                if (error != null) {
                    if (listener != null) {
                        VolleyLog.e("Error: ", error.getMessage());
                        listener.onFail();
                    }
                } else {
                    if (response != null) {
                        if (listener != null) {
                            listener.onRegisterUsers(new ArrayList<>(Arrays.asList(response)));
                        }
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return ArrayType.construct(SimpleType.construct(User.class), null, null);
            }

        });

        MyApp.getInstance().getRequestQueue().add(request);
    }





}
