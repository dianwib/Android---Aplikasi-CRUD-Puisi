package com.example.projectskripsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Materi3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi3);
    }public void fungsiback(View view) { Intent a =new Intent(Materi3Activity.this,DaftarMateriActivity.class);
        startActivity(a);
    }
}
