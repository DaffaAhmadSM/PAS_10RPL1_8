package com.example.pas_10rpl1_08;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.ViewHolder> implements Serializable {


    private ArrayList<KontakItem> mItemList;
    private Context context;
    private OnKontakListener mOnKontakListener;


    public KontakAdapter(ArrayList<KontakItem> mItemList, OnKontakListener onKontakListener ,Context context) {
        this.mItemList = mItemList;
        this.context = context;
        this.mOnKontakListener = onKontakListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mOnKontakListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mImage.setImageResource(mItemList.get(position).getmImage());
        holder.mNamaKontak.setText(mItemList.get(position).getmNamaKontak());
        holder.mNomorHP.setText(mItemList.get(position).getmNomorHP());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }


//    public void addItem(KontakItem kontakItem){
//        mItemList.add(kontakItem);
//        notifyDataSetChanged();
//
//    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener, View.OnClickListener {

        CircleImageView mImage;
        TextView mNamaKontak;
        TextView mNomorHP;
        LinearLayout parentLayout;
        OnKontakListener onKontakListener;

        public ViewHolder(@NonNull View itemView, OnKontakListener onKontakListener) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mNamaKontak = itemView.findViewById(R.id.nama_kontak);
            mNomorHP = itemView.findViewById(R.id.nomor_hp);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            this.onKontakListener = onKontakListener;

            itemView.setOnCreateContextMenuListener(this::onCreateContextMenu);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(R.menu.context, R.id.Edit, 1, "Edit").setOnMenuItemClickListener(this::onMenuItemClick);
        menu.add(R.menu.context, R.id.Delete, 1, "Delete").setOnMenuItemClickListener(this::onMenuItemClick);

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.Edit:
                    Toast.makeText(context,"Item Edit",Toast.LENGTH_SHORT).show();
                     return true;
                case R.id.Delete:
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Are you sure you want to delete data?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Toast.makeText(context, "Item " + getAdapterPosition() +" Deleted", Toast.LENGTH_SHORT).show();
                                            mItemList.remove(getAdapterPosition());
                                            notifyDataSetChanged();
                                        }
                                    })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .setTitle("Delete data")
                            .setIcon(R.mipmap.ic_launcher);
                    AlertDialog alert = builder.create();
                    alert.show();





                    return true;
            }
            return false;
        }

        @Override
        public void onClick(View v) {
            onKontakListener.OnKontakClik(getAdapterPosition());
        }


    }

    public  interface OnKontakListener{
        void OnKontakClik(int position);
    }
}

