package com.example.projectskripsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class KumpusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumpus);
    }

    public void fungsiback(View view) { Intent a =new Intent(KumpusActivity.this,MainActivity.class);
        startActivity(a);
    }


    public void brian(View view) {
        Intent a =new Intent(KumpusActivity.this,PuisiBrianActivity.class);
        startActivity(a);
    }

    public void bernard(View view) {
        Intent a =new Intent(KumpusActivity.this,PuisiBernardActivity.class);
        startActivity(a);
    }

    public void aan(View view) {
        Intent a =new Intent(KumpusActivity.this,PuisiAanActivity.class);
        startActivity(a);
    }
}
