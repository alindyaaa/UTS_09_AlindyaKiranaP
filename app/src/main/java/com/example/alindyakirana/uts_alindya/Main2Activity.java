package com.example.alindyakirana.uts_alindya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    SessionManagement sessionManagement;
    TextView txtUsername;
    Button btnLogout,btnDataKota;
    HashMap<String,String> loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtUsername = (TextView) findViewById(R.id.txtUsername);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnDataKota = (Button) findViewById(R.id.btnDataKota);

        sessionManagement = new SessionManagement(this);
        loginUser = sessionManagement.getUserInformation();

        Toast.makeText(this,sessionManagement.isLoggedIn()+"",Toast.LENGTH_LONG).show();

        txtUsername.setText(loginUser.get(sessionManagement.KEY_EMAIL));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.logoutUser();
            }
        });

        btnDataKota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });
    }
}