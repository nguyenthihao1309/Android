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
            ketQua = "K???t qu??? 3 t??y";
        else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            }
            if(tong%10==0)
                ketQua = "K???t qu??? b??, s??? t??y l?? "+ tinhSoTay(arr);
            else
                ketQua = "K???t qu??? l?? "+(tong%10)+" n??t, s??? t??y l?? "+ tinhSoTay(arr);
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
    //Hi???n th??? ng?????i ch??i v???i m??y, sau 10 m??y th???ng bao nhi??u, ng?????i ch??i tahwngs bao nhi??u
    //kh??ng b???m, c?? ?? edittext ????? ng?????i ch??i h???p v??o 1p, 2p, ????? m??y 1, m??y 2 t??? ddoognj ch??i v???i nhau(countdowntimer- ?????m th???i gian ng?????c)
}