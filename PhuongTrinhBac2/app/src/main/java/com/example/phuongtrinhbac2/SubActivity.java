package com.example.phuongtrinhbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        EditText et_SoA = findViewById(R.id.editText_soA);
        EditText et_SoB = findViewById(R.id.editText_soB);
        EditText et_SoC = findViewById(R.id.editText_soC);
        Button btnSubmit = findViewById(R.id.button_Submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Float a = Float.parseFloat(et_SoA.getText().toString());
                Float b = Float.parseFloat(et_SoB.getText().toString());
                Float c = Float.parseFloat(et_SoC.getText().toString());
                //String ketQua = giaiPhuongTrinhBac2(a, b, c);
               // System.out.println("Ket qua: " + ketQua);
                PhuongTrinhBac2 hai = new PhuongTrinhBac2(a,b,c);
                intent.putExtra("nghiem", hai.tinhPhuongTrinhBac2());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private String giaiPhuongTrinhBac2(float a, float b, float c) {
        String ketQua = "";
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    ketQua = "Phương trình vô số nghiệm";
                else
                    ketQua = "Phương trình vô nghiệm";
            } else {
                ketQua = "Phương trình có một nghiệm: "
                        + "x = " + (-c / b);
            }
        } else {
            // tính delta
            float delta = b * b - 4 * a * c;
            float x1;
            float x2;
            // tính nghiệm
            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                ketQua = "Phương trình có 2 nghiệm là: " + "x1 = " + x1 + " và x2 = " + x2;
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                ketQua = "Phương trình có nghiệm kép: " + "x1 = x2 = " + x1;
            } else {
                ketQua = "Phương trình vô nghiệm!";
            }
        }
        return ketQua;
    }
}

