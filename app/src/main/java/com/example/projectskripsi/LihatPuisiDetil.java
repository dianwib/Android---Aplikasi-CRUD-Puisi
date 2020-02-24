package com.example.projectskripsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LihatPuisiDetil extends AppCompatActivity {
TextView judul,isi,pengarang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_puisi_detil);
        judul = (TextView) findViewById(R.id.detilpuisijudul);
        isi = (TextView) findViewById(R.id.detilpuisiisi);
        pengarang = (TextView) findViewById(R.id.detilpuisipengarang);
        judul.setText(getIntent().getExtras().getString("datajudul"));
        isi.setText(getIntent().getExtras().getString("dataisi"));
        pengarang.setText("'"+getIntent().getExtras().getString("datanama")+"'");

    }

    public void fungsiback(View view) { Intent a =new Intent(LihatPuisiDetil.this,FirebaseDBReadActivity.class);
        startActivity(a);
    }
}
