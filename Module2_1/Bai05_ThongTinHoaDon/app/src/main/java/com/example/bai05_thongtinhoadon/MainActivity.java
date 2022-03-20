package com.example.bai05_thongtinhoadon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<KhachHang> dsKhachHang = new ArrayList<>();
    CheckBox chk_vip;
    EditText et_soLuongSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_tenKhachHang = findViewById(R.id.editText_tenKhachHang);
        et_soLuongSach = findViewById(R.id.editText_soLuongSach);
        chk_vip = findViewById(R.id.checkbox_vip);
        TextView tv_thanhTien = findViewById(R.id.textView_thanhTien);
        Button bt_tinhThanhTien = findViewById(R.id.button_tinhTT);
        Button bt_tiep = findViewById(R.id.button_tiep);
        Button bt_thongKe = findViewById(R.id.button_thongKe);
        ImageButton imbt_thoat = findViewById(R.id.imageButton_thoat);
        EditText et_thTongSoKhachHang = findViewById(R.id.editText_tongKH);
        EditText et_soKhachVip = findViewById(R.id.editText_tongKHVip);
        EditText et_doanhThu = findViewById(R.id.editText_tongDoanhThu);

        bt_tinhThanhTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_thanhTien.setText(String.valueOf(tinhThanhTien()));
            }
        });

        bt_tiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhachHang khachHang = new KhachHang();
                khachHang.setTenKhachHang(et_tenKhachHang.getText().toString());
                if(chk_vip.isChecked()==true){
                    khachHang.setLoaiVip(true);
                }else{
                    khachHang.setLoaiVip(false);
                }
                khachHang.setSoLuongSach(Integer.parseInt(et_soLuongSach.getText().toString()));
                khachHang.setThanhTien(tinhThanhTien());
                dsKhachHang.add(khachHang);

                et_tenKhachHang.setText("");
                et_soLuongSach.setText("");
                chk_vip.setChecked(false);
                et_tenKhachHang.requestFocus();
                et_doanhThu.setText("");
                et_soKhachVip.setText("");
                et_thTongSoKhachHang.setText("");
            }
        });

        bt_thongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_thTongSoKhachHang.setText(String.valueOf(dsKhachHang.size()));
                int soLuongVip = 0;
                double tongDoanhThu = 0;
                for (KhachHang khachHang:dsKhachHang) {
                    if(khachHang.isLoaiVip()==true){
                        soLuongVip+=1;
                    }
                    tongDoanhThu+=khachHang.getThanhTien();
                }

                et_soKhachVip.setText(String.valueOf(soLuongVip));
                et_doanhThu.setText(String.valueOf(tongDoanhThu));
            }
        });

    }

    public double tinhThanhTien(){
        int soLuongSach = Integer.parseInt(et_soLuongSach.getText().toString());
        double tinhTien = 0;
        if (chk_vip.isChecked()) {
            tinhTien = soLuongSach * 20000 * 0.9;
        } else {
            tinhTien = soLuongSach * 20000;
        }
        return tinhTien;
    }

}