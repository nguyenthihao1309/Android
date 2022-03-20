package com.example.bai05_quanlynhanvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etId, etName;
    Button btNhap;
    RadioGroup rgLoai;
    ListView lvDanhSach;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> arrayAdapter = null;
    Employee employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.edittext_manhanvien);
        etName = findViewById(R.id.edittext_tennhanvien);
        btNhap = findViewById(R.id.button_nhapnhanvien);
        rgLoai = findViewById(R.id.radiogroup_loai);
        lvDanhSach = findViewById(R.id.listview_nhanvien);

        arrayAdapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        lvDanhSach.setAdapter(arrayAdapter);

        btNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhap();

            }
        });
    }

    public void nhap(){
        if(rgLoai.getCheckedRadioButtonId()==R.id.radiobutton_chinhthuc){
            employee = new EmployeeFullTime();
        }else{
            employee = new EmployeePartTime();
        }
        employee.setId(etId.getText().toString().trim());
        employee.setName(etName.getText().toString().trim());

        arrEmployee.add(employee);
        arrayAdapter.notifyDataSetChanged();
    }
}