package com.example.projectskripsi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditPuisiDetil extends AppCompatActivity {
    TextView judul,isi,pengarang;
    private Button update;
    private DatabaseReference database;
    private FirebaseAuth auth;
    private String cekjudul, cekisi, ceknama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_puisi_detil);
        judul = (TextView) findViewById(R.id.et_judulbarang_baru);
        isi = (TextView) findViewById(R.id.et_isibarang_baru);
        pengarang = (TextView) findViewById(R.id.et_namabarang_baru);
        update=(Button) findViewById(R.id.bt_update);

        judul.setText(getIntent().getExtras().getString("datajudul"));
        isi.setText(getIntent().getExtras().getString("dataisi"));
        pengarang.setText("'"+getIntent().getExtras().getString("dataIsi")+"'");

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();
        getData();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Mendapatkan Data Puisi yang akan dicek
                cekjudul = judul.getText().toString();
                cekisi = isi.getText().toString();
                ceknama = pengarang.getText().toString();

                //Mengecek agar tidak ada data yang kosong, saat proses update
                if(isEmpty(cekjudul) || isEmpty(cekisi) || isEmpty(ceknama)){
                    Toast.makeText(EditPuisiDetil.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                }else {
                    /*
                      Menjalankan proses update data.
                      Method Setter digunakan untuk mendapakan data baru yang diinputkan User.
                    */
                    Puisi setPuisi = new Puisi();
                    setPuisi.setJudul(judul.getText().toString());
                    setPuisi.setIsi(isi.getText().toString());
                    setPuisi.setNama(pengarang.getText().toString());
                    setPuisi.setTanggal(new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date()));
                    updatePuisi(setPuisi);
                }
            }
        });
    }

    // Mengecek apakah ada data yang kosong, sebelum diupdate
    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    //Menampilkan data yang akan di update
    private void getData(){
        //Menampilkan data dari item yang dipilih sebelumnya
        final String getjudul = getIntent().getExtras().getString("datajudul");
        final String getIsi = getIntent().getExtras().getString("dataisi");
        final String getNama = getIntent().getExtras().getString("datanama");
        judul.setText(getjudul);
        isi.setText(getIsi);
        pengarang.setText(getNama);
    }

    //Proses Update data yang sudah ditentukan
    private void updatePuisi(Puisi Puisi){

        String getKey = getIntent().getExtras().getString("getPrimaryKey");
        database.child("puisi")
                .child(getKey)
                .setValue(Puisi)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        judul.setText("");
                        isi.setText("");
                        pengarang.setText("");
                        Toast.makeText(EditPuisiDetil.this, "Data Berhasil diubah", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }


    public void fungsiback(View view) { Intent a =new Intent(EditPuisiDetil.this,FirebaseDBReadActivity.class);
        startActivity(a);
    }
}
