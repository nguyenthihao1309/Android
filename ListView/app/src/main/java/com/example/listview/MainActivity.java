package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] listItems;
    ArrayList<SanPham> sanPhams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gv_traicay = findViewById(R.id.gridview_traicay);
//        listItems = getResources().getStringArray(R.array.traicay_array);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        sanPhams = new ArrayList<>();
        sanPhams.add(new SanPham(1,"Vinamilk", R.drawable.vinamilk, 10000,"Mô tả 1"));
        sanPhams.add(new SanPham(2,"Aquatina", R.drawable.aquatina, 5000,"Mô tả 2"));
        sanPhams.add(new SanPham(3,"Lavie", R.drawable.lavie, 10000,"Mô tả 3"));
        sanPhams.add(new SanPham(4,"Pepsi", R.drawable.pepsi, 10000,"Mô tả 4"));
        sanPhams.add(new SanPham(5,"Vaseline", R.drawable.vaselinebody, 160000,"Mô tả 5"));
        sanPhams.add(new SanPham(6,"Bia Sài Gòn", R.drawable.biasaigon, 10000,"Mô tả 6"));
        MyArrayAdapter adapter = new MyArrayAdapter(this, R.layout.custom_gridview, sanPhams);

        gv_traicay.setAdapter(adapter);
        gv_traicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, sanPhams.get(i)+"", Toast.LENGTH_SHORT).show();
                SanPham sanPham =   sanPhams.get(i);
                int hinh  = sanPham.getHinhAnh();
                double gia = sanPham.getGiaSanPham();
                String ten = sanPham.getTenSanPham();
                String mota = sanPham.getThongTinChiTiet();

                Intent intent = new Intent(MainActivity.this, Activity2.class);

                intent.putExtra("hinh", hinh);
                intent.putExtra("ten", ten);
                intent.putExtra("gia", gia);
                intent.putExtra("mota", mota);
                startActivity(intent);
            }
        });

    /*    ListView listView = findViewById(R.id.listview_traicay);
        //Laáy ra danh sách item trong string.xml
        listItems = getResources().getStringArray(R.array.traicay_array);
        //sử dụng Adapter để đưa danh sách item vào listview
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String st = listItems[i];
                Toast.makeText(MainActivity.this, st, Toast.LENGTH_LONG).show();

            }
        });*/
/*        Spinner spinner = findViewById(R.id.spinner_traicay);
        //Laáy ra danh sách item trong string.xml
        listItems = getResources().getStringArray(R.array.traicay_array);
        //sử dụng Adapter để đưa danh sách item vào listview
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String st = listItems[i];
                Toast.makeText(MainActivity.this, st, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
    }
}