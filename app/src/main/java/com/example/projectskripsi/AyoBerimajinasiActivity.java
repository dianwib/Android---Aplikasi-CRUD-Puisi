package com.example.projectskripsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AyoBerimajinasiActivity extends AppCompatActivity {

    private Button btCreateDB;
    private Button btViewDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayo_berimajinasi);

        btCreateDB = (Button) findViewById(R.id.bt_createdata);
        btViewDB = (Button) findViewById(R.id.bt_viewdata);


        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // kelas yang akan dijalankan ketika tombol Create/Insert Data diklik
                startActivity(FirebaseDBCreateActivity.getActIntent(AyoBerimajinasiActivity.this));
            }
        });

        btViewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a =new Intent(AyoBerimajinasiActivity.this,FirebaseDBReadActivity.class);
                startActivity(a);
            }
        });

    }
    public void fungsiback(View view) { Intent a =new Intent(AyoBerimajinasiActivity.this,MainActivity.class);
        startActivity(a);
    }

}