package com.example.sergewsevolojsky.parkme.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergewsevolojsky.parkme.MyApp;
import com.example.sergewsevolojsky.parkme.R;
import com.example.sergewsevolojsky.parkme.models.User;
import com.example.sergewsevolojsky.parkme.network.UserNetworkManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.EmailEditText)
    EditText emailEditText;

    @BindView(R.id.PasswordEditText)
    EditText passwordEditText;



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




    }

    private void BeforeLogin() {


        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(checkEmpty(email,password)){


            UserNetworkManager.findUsersLogin(email, password, new UserNetworkManager.UserLoginResultListener() {
                @Override
                public void onFindUsersLogin(ArrayList<User> user) {

                    if( !user.isEmpty()){


                        SharedPreferences userDetails = getApplicationContext().getSharedPreferences("userdetails", MODE_PRIVATE);
                        SharedPreferences.Editor edit = userDetails.edit();
                        edit.clear();
                        edit.putInt("id", Integer.parseInt(user.get(0).getId()));
                        edit.putString("name", user.get(0).getName().toString().trim());
                        edit.putString("email", user.get(0).getMail().toString().trim());
                        edit.apply();



                        //Toast.makeText(LoginActivity.this, user.get(0).getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "UNKNOWN USER", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFail() {
                    Toast.makeText(LoginActivity.this, "no", Toast.LENGTH_SHORT).show();
                }
            });

        } else {

            Toast.makeText(LoginActivity.this, "EMPTY FIELDS", Toast.LENGTH_SHORT).show();
        }



    }




    private boolean checkEmpty(String email, String password){
        return !email.isEmpty() || !password.isEmpty();
    }




    private void goRegister() {

        Intent intent = new Intent(this, InscriptionActivity.class);
        startActivity(intent);

    }

}
