package com.example.sergewsevolojsky.parkme.network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.models.User;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sergewsevolojsky on 09/06/16.
 */
public class UserNetworkManager {


    public interface UserResultListener {
        void onFindUsers(ArrayList<User> users);

        void onFail();
    }

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


}
