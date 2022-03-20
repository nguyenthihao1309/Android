package com.example.bai06_listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv_name;
    private String[] listName;
    private ArrayAdapter<String> adapter;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        lv_name = findViewById(R.id.listview_name);
        listName = context.getResources().getStringArray(R.array.listview_name);
        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listName);
        lv_name.setAdapter(adapter);

        lv_name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, listName[i] +" ở vị trí "+i,Toast.LENGTH_LONG).show();
            }
        });
    }
}