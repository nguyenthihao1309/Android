package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivitySanPhamInfo extends AppCompatActivity {
    ImageView imgvAnhSp, imgvGioHang;
    TextView tvTen, tvGia, tvThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham_info);

        Intent intent = getIntent();
        SanPham sanPham = (SanPham) intent.getSerializableExtra("thongTinSanPham");
        FragmentSanPhamInfo2 sanPhamInfo2 = (FragmentSanPhamInfo2) getFragmentManager().findFragmentById(R.id.fragment2);
        sanPhamInfo2.setInfo(sanPham);

    }
}