package com.example.lab_06_fagment_figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ActivityInfoPortrait extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_portrait);

        Intent intent = getIntent();
        Shoe shoe = (Shoe) intent.getSerializableExtra("thongTinShoe");
        FragmentInfo info = (FragmentInfo) getFragmentManager().findFragmentById(R.id.fragment_portrait_info);
        info.setInfo(shoe);

    }
}