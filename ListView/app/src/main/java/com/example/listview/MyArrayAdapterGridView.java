package com.example.listview;

import android.app.Activity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MyArrayAdapterGridView extends ArrayAdapter<SanPham> {
    Activity context = null;
    ArrayList<SanPham> myArray = null;
    int layoutId;
    GridView  gridView;

    public MyArrayAdapterGridView(Activity context, int textViewResourceId, ArrayList<SanPham> obj, GridView gridView) {
        super(context, textViewResourceId, obj);
        this.context = context;
        this.layoutId = textViewResourceId;
        this.myArray = obj;
        this.gridView = gridView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if (myArray.size() > 0 && position >= 0) {
            final ImageView imgvHienThi = convertView.findViewById(R.id.imageview_hinhsanpham);
            final TextView tvGia = convertView.findViewById(R.id.textview_giasanpham);
            final TextView tvTen = convertView.findViewById(R.id.textview_tensanpham);
            final SanPham sanPham = myArray.get(position);

            if(gridView.getNumColumns()==4){
                tvGia.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
                tvTen.setTextSize(TypedValue.COMPLEX_UNIT_SP,12 );
                gridView.setHorizontalSpacing(10);
            }
            imgvHienThi.setImageResource(sanPham.getHinhAnh());
            tvTen.setText(sanPham.getTenSanPham());
            DecimalFormat df = new DecimalFormat("###,###,### VNĐ");
            tvGia.setText(df.format(sanPham.getGiaSanPham()));
        }
        return convertView;
    }
}
