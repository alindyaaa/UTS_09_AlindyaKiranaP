package com.example.alindyakirana.uts_alindya;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    DatabaseKota databaseKota;
    Cursor cursor;
    EditText edtNama;
    Button btnInput,btnLihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edtNama = findViewById(R.id.edtNama);
        btnInput = findViewById(R.id.btnInput);
        btnLihat = findViewById(R.id.btnLihat);
        databaseKota = new DatabaseKota(this);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edtNama.getText().toString();
                SQLiteDatabase db = databaseKota.getWritableDatabase();
                db.execSQL("insert into kota (nama) values ('"+nama+"')");
                Toast.makeText(Main3Activity.this,"Input Berhasil dengan nama = "+nama,Toast.LENGTH_LONG).show();
            }
        });
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(i);
            }
        });
    }
}
