package com.example.projectskripsi;
import java.io.Serializable;


public class Puisi implements Serializable{

    private String nama;
    private String judul;
    private String isi;
    private String tanggal;
    private String key;



    public Puisi(){

    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }


    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+judul +"\n" +
                " "+isi +"\n" +
                " "+tanggal;
    }

    public Puisi(String nm, String jdl, String is,String tgl){
        nama = nm;
        judul = jdl;
        isi = is;
        tanggal=tgl;
    }
}