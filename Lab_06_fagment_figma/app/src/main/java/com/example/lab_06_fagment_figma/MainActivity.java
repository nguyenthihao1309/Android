package com.example.lab_06_fagment_figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TruyenShoes{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void dataShoe(Shoe shoe) {
        FragmentInfo infoLandscape = (FragmentInfo) getFragmentManager().findFragmentById(R.id.fragment_landscape_info);
        Configuration configuration = getResources().getConfiguration();

        if(infoLandscape!=null&& configuration.orientation==configuration.ORIENTATION_LANDSCAPE){
            infoLandscape.setInfo(shoe);
        }else{
            Intent intent = new Intent(MainActivity.this, ActivityInfoPortrait.class);
            intent.putExtra("thongTinShoe", shoe);
            startActivity(intent);
        }

    }
}