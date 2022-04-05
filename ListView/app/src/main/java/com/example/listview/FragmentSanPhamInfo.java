package com.example.listview;

import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class FragmentSanPhamInfo extends Fragment {
    TextView tvTen, tvGia, tvMoTa;
    ImageView imgAnh;
    View view;
    FragmentSanPhamListView fragmentSanPhamListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sanpham_info, container, false);
        anhXa();

        return view;
    }
    public void setInfo(SanPham s){
        tvTen.setText(s.getTenSanPham());
        DecimalFormat df = new DecimalFormat("###,###,### VNĐ");
        tvGia.setText(df.format(s.getGiaSanPham()));
        imgAnh.setImageResource(s.getHinhAnh());
        tvMoTa.setText(s.getThongTinChiTiet());
    }

    private void anhXa(){
        tvGia = view.findViewById(R.id.textview_gia_info);
        tvTen = view.findViewById(R.id.textview_ten_info);
        tvMoTa = view.findViewById(R.id.textview_thongtin_info);
        imgAnh = view.findViewById(R.id.imageview_hinhsanpham_info);
    }


}
