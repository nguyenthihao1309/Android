package com.example.phuongtrinhbac2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_KetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_KetQua = findViewById(R.id.textView_KetQuaPT);
        Button btnGiai = findViewById(R.id.button_Giai);
        Button btnGiai1 = findViewById(R.id.button_Giai1);
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, 9999);
            }
        });
        btnGiai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PTBac1Activity.class);
                startActivityForResult(intent, 8888);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9999 && resultCode== RESULT_OK) {
            String result = data.getStringExtra("nghiem").toString();
            tv_KetQua.setText(result);
        }
        if (requestCode == 8888 && resultCode== RESULT_OK) {
            String result = data.getStringExtra("nghiem1").toString();
            tv_KetQua.setText(result);
        }
    }
}