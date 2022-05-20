package com.example.testlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SettingOptionsFragment.OnOptionClickListener{
    private boolean isTwoPane;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

//        if (findViewById(R.id.detailContainer) != null) {
//            isTwoPane = true;
//        } else {
//            isTwoPane = false;
//        }

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container, new SettingOptionsFragment())
                    .commit();
        }

        //Load Display Settings Fragment by default in the details pane
//        if (isTwoPane) {
//            fragmentManager.beginTransaction()
//                    .replace(R.id.detailContainer, new DisplaySettingsFragment())
//                    .commit();
//        }
    }

    @Override
    public void onOptionSelected(String option) {

        switch (option) {
            case "network": {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new NetworkSettingsFragment())
                        .commit();
                break;
            }
            case "display": {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new DisplaySettingsFragment())
                        .commit();
                break;
            }
            case "storage": {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new StorageSettingsFragment())
                        .commit();
                break;
            }

        }
    }
}