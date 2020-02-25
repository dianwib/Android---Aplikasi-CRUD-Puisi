package com.example.projectskripsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PuisiTaufiqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puisi_taufiq);
    }
    public void fungsiback(View view) {
        Intent a =new Intent(PuisiTaufiqActivity.this,KumpusActivity.class);
        startActivity(a);
    }
}
