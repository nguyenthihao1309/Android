package com.example.bai04_listview_listactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listName;
    TextView tv_ketQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNhap = findViewById(R.id.edittext_nhapten);
        Button btnNhap = findViewById(R.id.button_nhap);
        tv_ketQua = findViewById(R.id.textview_hienthi);

        listName = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listName);
        setListAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNhap.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập vào tên.", Toast.LENGTH_LONG).show();
                }else{
                    listName.add(etNhap.getText().toString().trim());
                    adapter.notifyDataSetChanged();
                }

            }
        });

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        tv_ketQua.setText("Position: "+position+"| Value: "+getListAdapter().getItem(position));
    }
}