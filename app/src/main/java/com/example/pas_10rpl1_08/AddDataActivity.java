package com.example.pas_10rpl1_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        ((Button)findViewById(R.id.add_data_button)).setOnClickListener(view ->{
            TextView nama = findViewById(R.id.add_data_nama);
            if (nama.getText().toString() == null || nama.getText().toString().isEmpty()){
                Toast.makeText(this, "Nama Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                return;
            }

            TextView nomorHp = findViewById(R.id.add_data_nomorhp);
            if (nomorHp.getText().toString() == null || nomorHp.getText().toString().isEmpty()){
                Toast.makeText(this, "Nomor Hp Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                return;
            }

            Bundle bundle = new Bundle();
            bundle.putString("nama", nama.getText().toString());
            bundle.putString("noHp", nomorHp.getText().toString());
            bundle.putInt("gambar", R.drawable.ic_baseline_person_24);
            Intent intent = new Intent(this, MainActivity.class).putExtras(bundle);
            startActivity(intent);
        } );

    }

}