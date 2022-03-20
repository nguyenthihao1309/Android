package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int manghinhbai[] = {
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
            R.drawable.cj, R.drawable.cq, R.drawable.ck,
            R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5,
            R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10,
            R.drawable.dj, R.drawable.dq, R.drawable.dk,
            R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5,
            R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
            R.drawable.hj, R.drawable.hq, R.drawable.hk,
            R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5,
            R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.sj, R.drawable.sq, R.drawable.sk};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv1 = findViewById(R.id.imageview1);
        ImageView iv2 = findViewById(R.id.imageview2);
        ImageView iv3 = findViewById(R.id.imageview3);
        TextView tvKq = findViewById(R.id.textview_ketqua);
        Button btRut = findViewById(R.id.button_rutlabai);

        btRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] baLaBai = layBaSoNgauNhien(0, 51);
                iv1.setImageResource(manghinhbai[baLaBai[0]]);
                iv2.setImageResource(manghinhbai[baLaBai[1]]);
                iv3.setImageResource(manghinhbai[baLaBai[2]]);
                tvKq.setText(tinhKetQua(baLaBai));
            }
        });

    }

    private String tinhKetQua(int[] arr) {
        String ketQua = "";
        if (tinhSoTay(arr) == 3)
            ketQua = "Kết quả 3 tây";
        else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            }
            if(tong%10==0)
                ketQua = "Kết quả bù, số tây là "+ tinhSoTay(arr);
            else
                ketQua = "Kết quả là "+(tong%10)+" nút, số tây là "+ tinhSoTay(arr);
        }
        return ketQua;
    }

    private int tinhSoTay(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 13 >= 10 && arr[i] > 10)
                k++;
        }
        return k;
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private boolean kiemTraTrung(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return true;
        }
        return false;
    }

    private int[] layBaSoNgauNhien(int min, int max) {
        int[] baSo = new int[3];
        int i = 0;
        baSo[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (!kiemTraTrung(k, baSo))
                baSo[i++] = k;
        } while (i < 3);
        return baSo;
    }
    //Hiển thị người chơi với máy, sau 10 máy thắng bao nhiêu, người chơi tahwngs bao nhiêu
    //không bấm, có ô edittext để người chơi hập vào 1p, 2p, để máy 1, máy 2 tự ddoognj chơi với nhau(countdowntimer- đếm thời gian ngược)
}