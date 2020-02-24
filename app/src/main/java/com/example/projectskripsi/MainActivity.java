package com.example.projectskripsi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
LinearLayout linearLayout;
Button btn_keluar,btn_kumpus,btn_materi,btn_draft,btn_musikalisasi,btn_musik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_draft=findViewById(R.id.btn_draf);
        btn_kumpus=findViewById(R.id.btn_kumpus);
        btn_materi=findViewById(R.id.btn_materi);
        btn_musik=findViewById(R.id.btn_musik);
        btn_musikalisasi=findViewById(R.id.btn_musikalisasi);
        btn_keluar=findViewById(R.id.btn_keluar);


        btn_materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a =new Intent(MainActivity.this,DaftarMateriActivity.class);
                startActivity(a);
            }
        });
        btn_draft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a =new Intent(MainActivity.this,AyoBerimajinasiActivity.class);
                startActivity(a);
            }
        });
        btn_musikalisasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a =new Intent(MainActivity.this,MusikalisasiActivity.class);
                startActivity(a);
            }
        });
        btn_musik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a =new Intent(MainActivity.this,MusikActivity.class);
                startActivity(a);
            }
        });

        btn_kumpus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a =new Intent(MainActivity.this,KumpusActivity.class);
                startActivity(a);
            }
        });
        btn_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Keluar Aplikasi?");
                alertDialogBuilder
                        .setMessage("Apakah anda yakin keluar!")
                        .setCancelable(false)
                        .setPositiveButton("Ya",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        moveTaskToBack(true);
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);
                                    }
                                })

                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }
}
