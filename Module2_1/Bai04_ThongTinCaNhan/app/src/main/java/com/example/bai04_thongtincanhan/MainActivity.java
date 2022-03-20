package com.example.bai04_thongtincanhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_hoTen = findViewById(R.id.editText_hoTen);
        EditText et_cmnd = findViewById(R.id.editText_cmnd);
        RadioButton rb_trungCap = findViewById(R.id.radio_trungCap);
        RadioButton rb_caoDang = findViewById(R.id.radio_caoDang);
        RadioButton rb_daiHoc = findViewById(R.id.radio_daiHoc);
        CheckBox cb_docBao = findViewById(R.id.checkbox_docBao);
        CheckBox cb_docSach = findViewById(R.id.checkbox_docSach);
        CheckBox cb_docCoding = findViewById(R.id.checkbox_docCoding);
        EditText et_thongTinBoSung = findViewById(R.id.editText_thongTinBoSung);
        Button bt_gui = findViewById(R.id.button_guiThongTin);
        RadioGroup rg_bangCap = findViewById(R.id.radioGroup_BangCap);


        bt_gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String hoTen = et_hoTen.getText().toString();
                String cmnd = et_cmnd.getText().toString();
                String bangCap = "";
                if (rb_caoDang.isChecked()) {
                    bangCap = rb_caoDang.getText().toString();
                } else if (rb_daiHoc.isChecked()) {
                    bangCap = rb_daiHoc.getText().toString();
                } else if (rb_trungCap.isChecked()) {
                    bangCap = rb_trungCap.getText().toString();
                }
                String soThich = "";
                if (cb_docBao.isChecked()) {
                    soThich += cb_docBao.getText().toString() + ", ";
                }
                if (cb_docSach.isChecked()) {
                    soThich += cb_docSach.getText().toString() + ", ";
                }
                if (cb_docCoding.isChecked()) {
                    soThich += cb_docCoding.getText().toString();
                }

                String thongTinBoSung = et_thongTinBoSung.getText().toString();



                intent.putExtra("hoten", hoTen);
                intent.putExtra("cmnd", cmnd);
                intent.putExtra("bangcap", bangCap);
                intent.putExtra("sothich", soThich);
                intent.putExtra("thongtinbosung", thongTinBoSung);

                startActivity(intent);
            }
        });
    }
}