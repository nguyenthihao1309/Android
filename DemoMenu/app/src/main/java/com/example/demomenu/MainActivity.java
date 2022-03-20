package com.example.demomenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnXemSinhVien: {
                Toast.makeText(this, "bạn đã chọn mục xem sinh viên", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.mnXemLopHoc:{
                Toast.makeText(this, "bạn đã chọn mục xem lớp học", Toast.LENGTH_LONG).show();
                break;}
        }
        return super.onOptionsItemSelected(item);
    }
}