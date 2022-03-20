package com.example.bai01_quanlynhanvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> arrNhanVien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhanVien = null;
    Button btNhap;
    ImageButton imgBtXoa;
    EditText etMa, etTen;
    RadioGroup rgGioiTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btNhap = findViewById(R.id.button_nhap);
        imgBtXoa = findViewById(R.id.imagebutton_xoa);
        etMa = findViewById(R.id.edittext_manhanvien);
        etTen = findViewById(R.id.edittext_tennhanvien);
        rgGioiTinh = findViewById(R.id.radiogroup_gioitinh);
        lvNhanVien = findViewById(R.id.listview_nhanvien);

        arrNhanVien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout, arrNhanVien);
        lvNhanVien.setAdapter(adapter);

        btNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNhap();
            }
        });

        imgBtXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXoa();
            }
        });

    }

    public  void xuLyNhap(){
        boolean gioiTinh = false;
        if(rgGioiTinh.getCheckedRadioButtonId()==R.id.radiobutton_nu){
            gioiTinh = true;
        }
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(etMa.getText().toString().trim());
        nhanVien.setName(etTen.getText().toString().trim());
        nhanVien.setGender(gioiTinh);
        arrNhanVien.add(nhanVien);
        adapter.notifyDataSetChanged();

        etMa.setText("");
        etTen.setText("");
        etMa.requestFocus();
    }

    public  void xuLyXoa(){
        for (int i= lvNhanVien.getChildCount()-1; i>=0; i--){
            View view = lvNhanVien.getChildAt(i);
            CheckBox chk = view.findViewById(R.id.checkbox_item);
            if(chk.isChecked()){
                arrNhanVien.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }
}