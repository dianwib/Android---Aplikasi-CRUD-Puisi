package com.example.projectskripsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PuisiBrianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puisi_brian);
    }
    public void fungsiback(View view) {
        Intent a =new Intent(PuisiBrianActivity.this,KumpusActivity.class);
        startActivity(a);
    }
}