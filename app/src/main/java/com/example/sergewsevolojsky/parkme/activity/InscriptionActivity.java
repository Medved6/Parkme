package com.example.sergewsevolojsky.parkme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.R;

public class InscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        Button mEmailSignInButton = (Button) findViewById(R.id.RegistrationValidateButton);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before_registration();
            }});


        TextView toRegister = (TextView) findViewById(R.id.go_login);
        toRegister.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLogin();
            }}));
    }



    private void before_registration() {


        register();

    }



    private void register() {

        MyApp.getInstance().sessionID = true;

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    private void goLogin() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
}
