package com.example.bai02_quanlysanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinDm;
    EditText etMaSp, etTenSp;
    Button btnNhap;
    ListView lvSp;

    ArrayList<Catalog> arrSpinDM = new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpinDM = null;

    ArrayList<Product> arrListviewSP = new ArrayList<Product>();
    ArrayAdapter<Product> adapterListviewSP = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetsControl();
        fakeDataCatalog();
        addEventsForFormWidgets();
    }

    private void getWidgetsControl() {
        spinDm = findViewById(R.id.spinner_danhmuc);
        etMaSp = findViewById(R.id.edittext_ma);
        etTenSp = findViewById(R.id.edittext_ten);
        btnNhap = findViewById(R.id.button_nhap);
        lvSp = findViewById(R.id.listview_sanpham);

        adapterSpinDM = new ArrayAdapter<Catalog>(this, android.R.layout.simple_spinner_item, arrSpinDM);
        adapterSpinDM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDm.setAdapter(adapterSpinDM);

        adapterListviewSP = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, arrListviewSP);
        lvSp.setAdapter(adapterListviewSP);
    }

    private void fakeDataCatalog() {
        Catalog catalog1 = new Catalog("1", "SamSung");
        Catalog catalog2 = new Catalog("2", "Iphone");
        Catalog catalog3 = new Catalog("3", "IPad");
        arrSpinDM.add(catalog1);
        arrSpinDM.add(catalog2);
        arrSpinDM.add(catalog3);
        adapterSpinDM.notifyDataSetChanged();
    }

    private void addProductForCatalog() {
        Product p = new Product();
        p.setId(etMaSp.getText().toString().trim());
        p.setName(etTenSp.getText().toString().trim());
        Catalog cat = (Catalog) spinDm.getSelectedItem();
        cat.addProduct(p);
        loadListProductByCatalog(cat);
    }

    private void loadListProductByCatalog(Catalog c) {
        arrListviewSP.clear();
        arrListviewSP.addAll(c.getListProduct());
        adapterListviewSP.notifyDataSetChanged();
    }

    private void addEventsForFormWidgets() {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProductForCatalog();
                etMaSp.setText("");
                etTenSp.setText("");
                etMaSp.requestFocus();
            }
        });
        spinDm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadListProductByCatalog(arrSpinDM.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}