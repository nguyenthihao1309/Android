package com.example.bai04_thongtincanhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tv_hienThi = findViewById(R.id.textView_hienThi);

        String ketQua = "";

        ketQua += "Họ và tên: " + getIntent().getExtras().getString("hoten") + "\n";
        ketQua += "CMND: " + getIntent().getExtras().getString("cmnd") + "\n";
        ketQua += "Bằng cấp: " + getIntent().getExtras().getString("bangcap") + "\n";
        ketQua += "Sở thích: " + getIntent().getExtras().getString("sothich") + "\n";
        ketQua += "Thông tin bổ sung: " + getIntent().getExtras().getString("thongtinbosung");

        tv_hienThi.setText(ketQua);

    }
}