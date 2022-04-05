package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TruyenSanPham {
    String[] listItems;
    ArrayList<SanPham> sanPhams;
    GridView gridViewSP;
    Button btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThoat = findViewById(R.id.button_thoat);

        Configuration configuration = getResources().getConfiguration();
        if (btnThoat!=null && configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            btnThoat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            }

//

//        addSanPham();
//
//        gridViewSP = findViewById(R.id.gridview);
//        gridViewSP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(MainActivity.this, Activity2.class);
//                intent.putExtra("thongTinSanPham", sanPhams.get(i));
//                startActivity(intent);
//            }
//        });
 /*       GridView gv_traicay = findViewById(R.id.gridview_traicay);
//        listItems = getResources().getStringArray(R.array.traicay_array);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        sanPhams = new ArrayList<>();
        addSanPham();
        MyArrayAdapterGridView adapter = new MyArrayAdapterGridView(this, R.layout.layout_gridview_item, sanPhams);

        gv_traicay.setAdapter(adapter);
        gv_traicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, sanPhams.get(i)+"", Toast.LENGTH_SHORT).show();
                SanPham sanPham = sanPhams.get(i);
                int hinh = sanPham.getHinhAnh();
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
        });*/
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

    @Override
    public void dataSanPham(SanPham sanpham) {
        FragmentSanPhamInfo faFragmentSanPhamInfo = (FragmentSanPhamInfo) getFragmentManager().findFragmentById(R.id.fragmentInfo);
        Configuration configuration = getResources().getConfiguration();

        if (faFragmentSanPhamInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            faFragmentSanPhamInfo.setInfo(sanpham);
        } else {
            Intent intent = new Intent(MainActivity.this, ActivitySanPhamInfo.class);
            intent.putExtra("thongTinSanPham", sanpham);
            startActivity(intent);
        }

    }

    @Override
    public void getSanPham(SanPham sanPham) {
        FragmentSanPhamInfo faFragmentSanPhamInfo = (FragmentSanPhamInfo) getFragmentManager().findFragmentById(R.id.fragmentInfo);
        Configuration configuration = getResources().getConfiguration();

        if (faFragmentSanPhamInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            faFragmentSanPhamInfo.setInfo(sanPham);
        }
    }
}