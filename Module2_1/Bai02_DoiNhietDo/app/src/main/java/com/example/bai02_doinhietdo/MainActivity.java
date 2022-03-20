package com.example.bai02_doinhietdo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_fahrenheit = findViewById(R.id.editText_fahrenheit);
        EditText et_cellsius = findViewById(R.id.editText_cellsius);
        Button bt_toFahrenheit = findViewById(R.id.button_tofahrenheit);
        Button bt_toCellsius = findViewById(R.id.button_toCellsius);
        Button bt_clear = findViewById(R.id.button_clear);

        bt_toCellsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double fah = Double.parseDouble(et_fahrenheit.getText().toString());
                Double toCell = (fah - 32) * 5 / 9;
                et_cellsius.setText(String.valueOf(toCell));

            }
        });

        bt_toFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double cell = Double.parseDouble(et_cellsius.getText().toString());
                Double toFah = cell * 9 / 5 + 32;
                et_fahrenheit.setText(String.valueOf(toFah));
            }
        });

        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_cellsius.setText("");
                et_fahrenheit.setText("");
            }
        });
    }
}