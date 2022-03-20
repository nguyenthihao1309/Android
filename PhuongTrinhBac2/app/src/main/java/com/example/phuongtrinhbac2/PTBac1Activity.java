package com.example.phuongtrinhbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PTBac1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptbac1);
        EditText et_SoA = findViewById(R.id.editText_soA_1);
        EditText et_SoB = findViewById(R.id.editText_soB_1);
        Button btnSubmit = findViewById(R.id.button_Submit_1);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Float a = Float.parseFloat(et_SoA.getText().toString());
                Float b = Float.parseFloat(et_SoB.getText().toString());

                intent.putExtra("nghiem1", giaiPhuongTrinhBac1(a, b));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private String giaiPhuongTrinhBac1(float a, float b) {
        String ketQua = "";
        if (a == 0) {
            if (b == 0)
                ketQua = "Phương trình vô số nghiệm";
            else
                ketQua = "Phương trình vô nghiệm";
        } else {
            ketQua = "Phương trình có một nghiệm: "
                    + "x = " + (-b / a);
        }
        return ketQua;
    }
}