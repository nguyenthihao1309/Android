package com.example.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);// this: chỉ activity hiện tại
        myDialog.setTitle("Thông báo");
        //myDialog.setMessage("Hi Hi Hi Hi");
       // myDialog.setIcon(R.drawable.ic_warning_48);

        final CharSequence[] myItems = {"Đỏ", "Cam", "Vàng"};
        final  boolean[] checked = {false, false, false};
        myDialog.setMultiChoiceItems(myItems, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                checked[i] = b;

            }
        });
   
//        String st = "";
//        for(int j = 0; i< myItems.length; j++){
//            if(checked[j])
//                st+= myItems[j].toString()+", ";
//        }
//        Toast.makeText(MainActivity.this, st, Toast.LENGTH_LONG).show();
        /*
        myDialog.setSingleChoiceItems(myItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, myItems[i].toString(), Toast.LENGTH_LONG).show();
            }
        });*/
/*
        myDialog.setItems(myItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, myItems[i].toString(), Toast.LENGTH_LONG).show();
            }
        });*/
/*
        myDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn nút OK", Toast.LENGTH_LONG).show();

            }
        });
        myDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn nút Cancel", Toast.LENGTH_LONG).show();
            }
        });*/
        AlertDialog dialog = myDialog.create();
        dialog.show();
    }
}