package com.example.projectskripsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
ImageView logo,masuk;
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logo=findViewById(R.id.imageView);

        masuk=findViewById(R.id.imageView2);
        txt=findViewById(R.id.textView2);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a =new Intent(LoginActivity.this,MainActivity.class);
                startActivity(a);
            }
        });
    }
}
