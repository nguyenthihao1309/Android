package com.example.bai01_quanlynhanvien;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {

    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutId;

    public MyArrayAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<NhanVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.myArray = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);
        if(myArray.size()>0&& position>=0){
            final TextView tvDisplay = convertView.findViewById(R.id.textview_item);
            final  NhanVien nhanVien = myArray.get(position);
            tvDisplay.setText(nhanVien.toString());
            final ImageView imgItem = convertView.findViewById(R.id.imageview_item);
            if(nhanVien.isGender()){
                imgItem.setImageResource(R.drawable.ic_female_user_24);
            }else{
                imgItem.setImageResource(R.drawable.ic_male_user_24);
            }
        }
        return  convertView;
    }
}
