package com.example.alindyakirana.uts_alindya;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSessionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.editUsername);
        edtPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.buttonLogin);

        final SessionManagement sm = new SessionManagement(this);

        if (sm.isLoggedIn()) {
            goToActivity();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();

                if (email.matches("") || email.trim().isEmpty() || password.matches("") || password.trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Email / Password tidak boleh tidak terisi", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    sm.createLoginSession(email, password);
                    goToActivity();
                }
            }
        });

    }

    private void goToActivity() {
        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(i);
    }
}
