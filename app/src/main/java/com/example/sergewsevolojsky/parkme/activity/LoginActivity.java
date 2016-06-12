package com.example.sergewsevolojsky.parkme.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.models.User;
import com.example.sergewsevolojsky.parkme.network.UserNetworkManager;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private View PseudoEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);


        Button mEmailSignInButton = (Button) findViewById(R.id.LoginValidateButton);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }});


        TextView toRegister = (TextView) findViewById(R.id.go_register);
        toRegister.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               goRegister();
            }}));
    }



    private void login() {

        BeforeLogin();

        MyApp.getInstance().sessionID = true;

        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);

    }

    private void BeforeLogin() {


        UserNetworkManager.findUsers(new UserNetworkManager.UserResultListener() {
            @Override
            public void onFindUsers(ArrayList<User> usersResult) {
                Log.e("USERS",usersResult.toString());
                Toast.makeText(LoginActivity.this, usersResult.get(0).getName(), Toast.LENGTH_SHORT).show();
              }

            @Override
            public void onFail() {
                Toast.makeText(LoginActivity.this, "no", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void goRegister() {

        Intent intent = new Intent(this, InscriptionActivity.class);
        startActivity(intent);

    }

}
