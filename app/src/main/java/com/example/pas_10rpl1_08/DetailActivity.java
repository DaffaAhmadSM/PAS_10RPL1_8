package com.example.pas_10rpl1_08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Bundle bundle;
    String namaKontak;
    String nomorHp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tv_namaKontak = findViewById(R.id.detail_nama_kontak);
        TextView tv_nomorKontak = findViewById(R.id.detail_nomor_hp);
        bundle = getIntent().getExtras();
        if(bundle != null ){
            namaKontak = bundle.getString("namaKontak");
            nomorHp = bundle.getString("nomorHp");
        }
        tv_namaKontak.setText("Nama: " + namaKontak);
        tv_nomorKontak.setText("Nomor HP: " + nomorHp);
    }
}