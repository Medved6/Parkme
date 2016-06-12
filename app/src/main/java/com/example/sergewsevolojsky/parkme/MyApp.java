package com.example.sergewsevolojsky.parkme;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.sergewsevolojsky.parkme.activity.LoginActivity;
import com.example.sergewsevolojsky.parkme.activity.ReservationsActivity;

/**
 * Created by sergewsevolojsky on 07/06/16.
 */
public class MyApp extends Application {

    private static Context context;
    public boolean sessionID = false;

    private static MyApp instance;

    public RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        MyApp.instance = this;
        MyApp.context = getApplicationContext();


       requestQueue = Volley.newRequestQueue(context);
        requestQueue.start();
    }

    public static MyApp getInstance() {
        return instance;
    }
}
