package com.example.listview;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class FragmentSanPhamInfo2 extends Fragment {
    TextView tvTen, tvGia, tvMoTa;
    ImageView imgAnh;
    View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sanpham_info_2, container, false);
        anhXa();

        return view;
    }

    public void setInfo(SanPham s) {
        tvTen.setText(s.getTenSanPham());
        DecimalFormat df = new DecimalFormat("###,###,### VNĐ");
        tvGia.setText(df.format(s.getGiaSanPham()));
        imgAnh.setImageResource(s.getHinhAnh());
        tvMoTa.setText(s.getThongTinChiTiet());
    }

    private void anhXa() {
        tvGia = view.findViewById(R.id.tv_guiGia);
        tvTen = view.findViewById(R.id.tv_guiTen);
        tvMoTa = view.findViewById(R.id.textview_thongtinchitiet);
        imgAnh = view.findViewById(R.id.imageview_anhsanpham);
    }
}
