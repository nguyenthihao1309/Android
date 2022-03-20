package com.example.baitapgamebaicao1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnBatDau;
    private TextView tvKetQuaMay;
    private TextView tvKetQuaBan;
    private TextView tvSoTranMay;
    private TextView tvSoTranBan;
    private ImageView imvMay1;
    private ImageView imvMay2;
    private ImageView imvMay3;
    private ImageView imvBan1;
    private ImageView imvBan2;
    private ImageView imvBan3;
    private int soTranMay = 0;
    private int soTranBan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
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

        //Hiển thị người chơi với máy, sau 10 máy thắng bao nhiêu, người chơi thắng bao nhiêu


        btnBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBatDau.setVisibility(View.INVISIBLE);
                CountDownTimer Timer = new CountDownTimer(10000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int[] mang6So = lay6SoNgauNhien(0, 51);
                        int[] mangBan = {mang6So[1], mang6So[3], mang6So[5]};
                        int[] mangMay = {mang6So[0], mang6So[2], mang6So[4]};
                        imvBan1.setImageResource(manghinhbai[mang6So[1]]);
                        imvBan2.setImageResource(manghinhbai[mang6So[3]]);
                        imvBan3.setImageResource(manghinhbai[mang6So[5]]);
                        imvMay1.setImageResource(manghinhbai[mang6So[0]]);
                        imvMay2.setImageResource(manghinhbai[mang6So[2]]);
                        imvMay3.setImageResource(manghinhbai[mang6So[4]]);
                        tvKetQuaBan.setText(tinhKetQua(mangBan));
                        tvKetQuaMay.setText(tinhKetQua(mangMay));

                        if (kiemTraWin(mangBan, mangMay)) {
                            tvSoTranBan.setText("Win: " + (++soTranBan));
                        } else {
                            tvSoTranMay.setText("Win: " + (++soTranMay));
                        }

                    }

                    public void onFinish() {
                        int[] mang6So = lay6SoNgauNhien(0, 51);
                        int[] mangBan = {mang6So[1], mang6So[3], mang6So[5]};
                        int[] mangMay = {mang6So[0], mang6So[2], mang6So[4]};
                        imvBan1.setImageResource(manghinhbai[mang6So[1]]);
                        imvBan2.setImageResource(manghinhbai[mang6So[3]]);
                        imvBan3.setImageResource(manghinhbai[mang6So[5]]);
                        imvMay1.setImageResource(manghinhbai[mang6So[0]]);
                        imvMay2.setImageResource(manghinhbai[mang6So[2]]);
                        imvMay3.setImageResource(manghinhbai[mang6So[4]]);
                        tvKetQuaBan.setText(tinhKetQua(mangBan));
                        tvKetQuaMay.setText(tinhKetQua(mangMay));

                        if (kiemTraWin(mangBan, mangMay)) {
                            tvSoTranBan.setText("Win: " + (++soTranBan));
                        } else {
                            tvSoTranMay.setText("Win: " + (++soTranMay));
                        }
                        btnBatDau.setVisibility(View.VISIBLE);
                        soTranBan = 0;
                        soTranMay = 0;
                    }
                }.start();

            }
        });

    }

    public int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public boolean kiemTraTrung(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return true;
        }
        return false;
    }

    private boolean kiemTraWin(int[] a, int[] b) {
        if (demSoTay(a) == 3 && demSoTay(b) < 3) {
            return true;
        }
        if (demSoTay(b) == 3 && demSoTay(a) < 3) {
            return false;
        }
        if (demSoTay(a) == 3 && demSoTay(b) == 3) {
            if (timMax(a) > timMax(b)) {
                return true;
            } else return false;
        } else {
            int tongA = 0;
            int tongB = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 13 < 10)
                    tongA += a[i] % 13 + 1;
                if (b[i] % 13 < 10)
                    tongB += b[i] % 13 + 1;
            }
            if (tongA % 10 > tongB % 10) {
                return true;
            } else if (tongA % 10 < tongB % 10) {
                return false;
            } else {
                if (demSoTay(a) > demSoTay(b)) {
                    return true;
                } else if (demSoTay(a) < demSoTay(b)) {
                    return false;
                } else {
                    if (timMax(a) > timMax(b)) {
                        return true;
                    } else return false;
                }
            }
        }
    }

    private int timMax(int[] a) {
        int max = a[0];
        max = a[1] > a[0] ? a[1] : a[0];
        max = max > a[2] ? max : a[2];
        return max;
    }

    public int[] lay6SoNgauNhien(int min, int max) {
        int[] sauso = new int[6];
        int i = 0;
        sauso[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (!kiemTraTrung(k, sauso)) {
                sauso[i++] = k;
            }
        } while (i < 6);
        return sauso;
    }

    private int demSoTay(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 13 > 9)
                k++;
        }
        return k;

    }

    private String tinhKetQua(int[] arr) {
        String kq = "";
        if (demSoTay(arr) == 3) {
            return "3 tay";
        } else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            }
            if (tong % 10 == 0) {
                kq = "Bù, Số tây: " + demSoTay(arr);
            } else {
                kq = "kết quả là " + tong % 10 + " nút," + " số tây là: " + demSoTay(arr);
            }
        }
        return kq;

    }

    private void anhXa() {
        btnBatDau = findViewById(R.id.imbPlay);
        tvKetQuaMay = findViewById(R.id.tvKetQuaMay);
        tvKetQuaBan = findViewById(R.id.tvKetQuaBan);
        imvBan1 = findViewById(R.id.imvLa1);
        imvBan2 = findViewById(R.id.imvLa2);
        imvBan3 = findViewById(R.id.imvLa3);
        imvMay1 = findViewById(R.id.imvMay1);
        imvMay2 = findViewById(R.id.imvMay2);
        imvMay3 = findViewById(R.id.imvMay3);
        tvSoTranBan = findViewById(R.id.tvSoTranBan);
        tvSoTranMay = findViewById(R.id.tvSoTranMay);

    }

}