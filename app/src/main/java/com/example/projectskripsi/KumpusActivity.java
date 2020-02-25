package com.example.projectskripsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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

    public void joko(View view) {
        Intent a =new Intent(KumpusActivity.this,PuisiJokoActivity.class);
        startActivity(a);
    }

    public void rendra(View view) {
        Intent a =new Intent(KumpusActivity.this,PuisiRendraActivity.class);
        startActivity(a);
    }

    public void sapardi(View view) {
        Intent a =new Intent(KumpusActivity.this,PuisiSapardiActivity.class);
        startActivity(a);}

    public void taufiq(View view) {
        Intent a =new Intent(KumpusActivity.this,PuisiTaufiqActivity.class);
        startActivity(a);}
}
