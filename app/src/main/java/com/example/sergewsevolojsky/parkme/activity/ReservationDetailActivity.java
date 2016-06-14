package com.example.sergewsevolojsky.parkme.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.models.Spots;

public class ReservationDetailActivity extends AppCompatActivity {

    public static final String ARGUMENT_MOVIE = "MOVIE_DETAIL";

    Spots spot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_detail);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Bundle intent = getIntent().getExtras();
        spot = intent.getParcelable(ARGUMENT_MOVIE);

        String adress = spot.getStreetNumber()+" "+spot.getStreet()+ spot.getCity();
        getSupportActionBar().setTitle(adress);


    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, ReservationsActivity.class);
                startActivity(intent);
        }
        return (super.onOptionsItemSelected(item));
    }
}
