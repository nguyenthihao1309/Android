package com.example.bai03_chuyendoinam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_namDuong = findViewById(R.id.editText_namDuong);
        TextView tv_ketQuaNamAm = findViewById(R.id.textView_ketQuaNamAm);
        Button bt_Chuyen = findViewById(R.id.button_chuyenDoiNam);

        bt_Chuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int namDuong = Integer.parseInt(et_namDuong.getText().toString());
                String ketQuaNamAm = chuyenDoiNam(namDuong);
                tv_ketQuaNamAm.setText(ketQuaNamAm);
            }
        });
    }

    private String chuyenDoiNam(int namDuong){
        String can ="", chi="";
        switch (namDuong%10){
            case 1:
                can = "Tân";
                break;
            case 2:
                can = "Nhâm";
                break;
            case 3:
                can = "Quý";
                break;
            case 4:
                can = "Giáp";
                break;
            case 5:
                can = "Ất";
                break;
            case 6:
                can = "Bính";
                break;
            case 7:
                can = "Đinh";
                break;
            case 8:
                can = "Mậu";
                break;
            case 9:
                can = "Kỷ";
                break;
            case 0:
                can = "Canh";
                break;
        }

        switch (namDuong%12){
            case 0:
                chi = "Thân";
                break;
            case 1:
                chi = "Dậu";
                break;
            case 2:
                chi = "Tuất";
                break;
            case 3:
                chi = "Hợi";
                break;
            case 4:
                chi = "Tý";
                break;
            case 5:
                chi = "Sửu";
                break;
            case 6:
                chi = "Dần";
                break;
            case 7:
                chi = "Mẹo";
                break;
            case 8:
                chi = "Thìn";
                break;
            case 9:
                chi = "Tỵ";
                break;
            case 10:
                chi = "Ngọ";
                break;
            case 11:
                chi = "Mùi";
                break;
        }


        return String.format("%s %s", can, chi);

    }
}