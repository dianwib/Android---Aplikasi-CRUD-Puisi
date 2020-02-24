package com.example.projectskripsi;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Class Adapter ini Digunakan Untuk Mengatur Bagaimana Data akan Ditampilkan
public class AdapterPuisi extends RecyclerView.Adapter<AdapterPuisi.ViewHolder>{


    //Deklarasi Variable
    private ArrayList<Puisi> listPuisi;
    private Context context;
    //Membuat Interfece
    public interface dataListener{
        void onDeleteData(Puisi data, int position);
    }

    //Deklarasi objek dari Interfece
    dataListener listener;
    //Membuat Konstruktor, untuk menerima input dari Database
    public AdapterPuisi(ArrayList<Puisi> listPuisi, Context context) {
        this.listPuisi = listPuisi;
        this.context = context;
        listener = (FirebaseDBReadActivity)context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Judul, Nama, Tanggal;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View yang terpasang pada layout RecyclerView kita
            Judul = itemView.findViewById(R.id.judul);
            Nama = itemView.findViewById(R.id.nama);
            Tanggal = itemView.findViewById(R.id.tanggal);
            ListItem = itemView.findViewById(R.id.list_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_puisi, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String Judul = listPuisi.get(position).getJudul();
        final String Nama = listPuisi.get(position).getNama();
        final String Tanggal = listPuisi.get(position).getTanggal();

        //Memasukan Nilai/Value kedalam View (TextView: NIM, Nama, Jurusan)
        holder.Judul.setText(Judul);
        holder.Nama.setText("Oleh : "+Nama);
        holder.Tanggal.setText(Tanggal);

        holder.ListItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                final String[] action = {"Lihat","Edit", "Hapus"};
                AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                alert.setItems(action,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i){
                            case 0:
                        /*
                          Berpindah Activity pada halaman layout updateData
                          dan mengambil data pada listMahasiswa, berdasarkan posisinya
                          untuk dikirim pada activity selanjutnya
                        */
                        Bundle bundle = new Bundle();
                        bundle.putString("datajudul", listPuisi.get(position).getJudul());
                        bundle.putString("datanama", listPuisi.get(position).getNama());
                        bundle.putString("dataisi", listPuisi.get(position).getIsi());
                        bundle.putString("getPrimaryKey", listPuisi.get(position).getKey());
                        Intent intent = new Intent(v.getContext(), LihatPuisiDetil.class);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                                break;
                        /*
                          Berpindah Activity pada halaman layout updateData
                          dan mengambil data pada listMahasiswa, berdasarkan posisinya
                          untuk dikirim pada activity selanjutnya
                        */
                            case 1:
                                Bundle bundle_1 = new Bundle();
                            bundle_1.putString("datajudul", listPuisi.get(position).getJudul());
                            bundle_1.putString("datanama", listPuisi.get(position).getNama());
                            bundle_1.putString("dataisi", listPuisi.get(position).getIsi());
                            bundle_1.putString("getPrimaryKey", listPuisi.get(position).getKey());
                            Intent intent_1 = new Intent(v.getContext(), EditPuisiDetil.class);
                            intent_1.putExtras(bundle_1);
                            context.startActivity(intent_1);
                            break;

                            case 2:
                                //Pembahasan selanjutnya mengenai fungsi Delete
                                listener.onDeleteData(listPuisi.get(position), position);

                                break;
                        }
                    }
                });
                alert.create();
                alert.show();
                return true;
            }
        });
            }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listPuisi.size();
    }

}