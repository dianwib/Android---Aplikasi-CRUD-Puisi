package com.example.projectskripsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DaftarMateriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_materi);
    }

    public void fungsiback(View view) {
        Intent a = new Intent(DaftarMateriActivity.this, MainActivity.class);
        startActivity(a);
    }

    public void materi0(View view) {
        Intent a = new Intent(DaftarMateriActivity.this, MateriActivity.class);
        startActivity(a);
    }

    public void materi2(View view) {
        Intent a = new Intent(DaftarMateriActivity.this, Materi1Activity.class);
        startActivity(a);
    }
    public void materi3(View view) {
        Intent a = new Intent(DaftarMateriActivity.this, Materi3Activity.class);
        startActivity(a);
    }

    public void materi1(View view) {

        Intent a = new Intent(DaftarMateriActivity.this, Materi2Activity.class);
        startActivity(a);
    }
}
