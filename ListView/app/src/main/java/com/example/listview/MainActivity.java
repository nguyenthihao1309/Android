package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Spinner spinner = findViewById(R.id.spinner_traicay);
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
        });
    }
}