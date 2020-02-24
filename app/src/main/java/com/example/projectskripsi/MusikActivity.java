package com.example.projectskripsi;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MusikActivity extends AppCompatActivity {
    MediaController media_Controler;
    DisplayMetrics dm;

    VideoView video;
    TextView txtJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musik);

        video=(VideoView)findViewById(R.id.videoView);
        txtJudul=(TextView)findViewById(R.id.textViewJudulVideo);
        media_Controler =new MediaController(this);
        dm=new DisplayMetrics();


        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int h=dm.heightPixels;
        int w=dm.widthPixels;



        video.setMinimumHeight(h);;
        video.setMinimumWidth(w);


        video.setMediaController(media_Controler);
    }



    public void muatvideo(String judul, String nama_file){
        txtJudul.setText(judul);
        video.setVideoPath("android.resource://"+getPackageName()+"/raw/"+nama_file);
        video.start();
    }



    public void fungsiback(View view) { Intent a =new Intent(MusikActivity.this,MainActivity.class);
        startActivity(a);
    }



    public void musik2(View view) {
        muatvideo("Berdua Saja - Payung Teduh","berduasaja");

    }

    public void musik1(View view) {
        muatvideo("Di Ujung Malam - Payung Teduh","diujungmalam");

    }
    public void musik0(View view) {
        muatvideo("Resah - Payung Teduh","resah");

    }

    public void musik3(View view) {
        muatvideo("Akad - Payung Teduh","akad");

    }
}
