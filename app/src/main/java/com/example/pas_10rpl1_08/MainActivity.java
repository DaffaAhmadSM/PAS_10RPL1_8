package com.example.pas_10rpl1_08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements KontakAdapter.OnKontakListener {
    private static ArrayList<KontakItem> mItemList;
    private RecyclerView recyclerView;
    private KontakAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mItemList != null) {
            Toast.makeText(this,"Kontak Ditambahkan",Toast.LENGTH_SHORT).show();
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                mItemList.add(new KontakItem(bundle.getString("nama"), bundle.getString("noHp"), bundle.getInt("gambar"))); // <--- antara bundle.getInt() ato pake R.drawable.ic_baseline_person_24
            }
        } else {

            mItemList = new ArrayList<>();
            item();
        }

        adapter = new KontakAdapter(mItemList, this, this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        ((FloatingActionButton) findViewById(R.id.add_data_btn)).setOnClickListener((view)->{
            Intent intent = new Intent(this,AddDataActivity.class);
            startActivity(intent);
        });



    }

    private void item() {

        mItemList.add(new KontakItem("Ucup", "+62-896-5558-27", R.drawable.ic_baseline_person_24));
        mItemList.add(new KontakItem("Cicit", "+62-815-5558-62", R.drawable.ic_baseline_person_24));
        mItemList.add(new KontakItem("RasyidGemink", "+62-856-5558-27", R.drawable.ic_baseline_person_24));
        mItemList.add(new KontakItem("Udin", "+62-838-5556-45", R.drawable.ic_baseline_person_24));


    }

    @Override
    public void OnKontakClik(int position) {
        Toast.makeText(this,"Item Cliked" + position,Toast.LENGTH_SHORT).show();
        Intent move = new Intent(getApplicationContext(),DetailActivity.class);
        KontakItem kontakItem = mItemList.get(position);
        move.putExtra("namaKontak", kontakItem.getmNamaKontak());
        move.putExtra("nomorHp", kontakItem.getmNomorHP());
        startActivity(move);
    }


}




