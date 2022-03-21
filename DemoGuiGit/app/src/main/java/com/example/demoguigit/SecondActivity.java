package com.example.demoguigit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView imgVSanPhamSecond = findViewById(R.id.imageView_second_main);
        ImageView imgVMauBac = findViewById(R.id.imageView_bac);
        ImageView imgVMauDo = findViewById(R.id.imageView_do);
        ImageView imgVMauXanhDam = findViewById(R.id.imageView_xanhdam);
        ImageView imgVMauDen = findViewById(R.id.imageView_den);
        Button btnXong = findViewById(R.id.button_xong);
        TextView tvMau = findViewById(R.id.textView_mau_second);

        imgVMauBac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgVSanPhamSecond.setImageResource(R.drawable.vs_bac);
                tvMau.setText("bạc");
                index =R.drawable.vs_bac;
            }
        });
        imgVMauDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgVSanPhamSecond.setImageResource(R.drawable.vsmart_black_star);
                tvMau.setText("đen");
                index = R.drawable.vsmart_black_star;
            }
        });
        imgVMauDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgVSanPhamSecond.setImageResource(R.drawable.vs_red_a);
                tvMau.setText("đỏ");
                index=R.drawable.vs_red_a;
            }
        });
        imgVMauXanhDam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgVSanPhamSecond.setImageResource(R.drawable.vsmart_live_xanh);
                tvMau.setText("xanh");
                index = R.drawable.vsmart_live_xanh;
            }
        });

        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("index", index);
                finish();
            }
        });

    }
}