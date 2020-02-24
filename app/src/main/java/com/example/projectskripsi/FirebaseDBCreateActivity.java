package com.example.projectskripsi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Herdi_WORK on 08.08.17.
 */

public class FirebaseDBCreateActivity extends AppCompatActivity {

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    // variable fields EditText dan Button
    private Button btSubmit;
    private EditText etNama;
    private EditText etIsi;
    private EditText etJudul;
    private String etTanggal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_dbcreate);

        // inisialisasi fields EditText dan Button
        etNama = (EditText) findViewById(R.id.et_namabarang);

        etJudul = (EditText) findViewById(R.id.et_judulbarang);
        etIsi = (EditText) findViewById(R.id.et_isibarang);
        etTanggal = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        btSubmit = (Button) findViewById(R.id.bt_submit);


        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        // kode yang dipanggil ketika tombol Submit diklik
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEmpty(etNama.getText().toString()) && !isEmpty(etIsi.getText().toString()))
                    submitPuisi(new Puisi(etNama.getText().toString(),etJudul.getText().toString(), etIsi.getText().toString(), etTanggal));
                else
                    Snackbar.make(findViewById(R.id.bt_submit), "Data puisi tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        etNama.getWindowToken(), 0);
            }
        });

    }

    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void updatePuisi(Puisi puisi) {
        // kodingan untuk next tutorial ya :p
    }

    private void submitPuisi(Puisi puisi) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("puisi").push().setValue(puisi).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNama.setText("");
                etJudul.setText("");
                etIsi.setText("");
                Snackbar.make(findViewById(R.id.bt_submit), "Puisi berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, FirebaseDBCreateActivity.class);
    }

    public void fungsireset(View view) {
        etNama.setText("");
        etJudul.setText("");
        etIsi.setText("");
    }

    public void fungsiback(View view) { Intent a =new Intent(FirebaseDBCreateActivity.this,AyoBerimajinasiActivity.class);
        startActivity(a);
    }
}