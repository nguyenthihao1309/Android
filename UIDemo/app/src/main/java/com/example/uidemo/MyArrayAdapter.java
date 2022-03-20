package com.example.uidemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity activity =null;
    ArrayList<NhanVien> nhanViens = null;
    int layoutId;

    public MyArrayAdapter(Activity activity, ArrayList<NhanVien> nhanViens, int layoutId) {
        super(activity, layoutId, nhanViens);
        this.activity = activity;
        this.nhanViens = nhanViens;
        this.layoutId = layoutId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if(nhanViens.size()>0&& position>=0){
            final TextView txtHienThi = convertView.findViewById(R.id.textview_item_nhanvien);
            final  NhanVien nhanVien = nhanViens.get(position);

            txtHienThi.setText(nhanVien.toString());

            final ImageView imgviewAnhDaiDien= convertView.findViewById(R.id.img_item_nhanvien);
            imgviewAnhDaiDien.setImageURI(nhanVien.getHinhDaiDien());

        }
        return convertView;
    }
}
