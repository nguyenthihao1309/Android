package com.example.lab_06_fagment_figma;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class FragmentInfo extends Fragment {
    ImageView imgvAnh;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_shoe, container, false);
        anhXa();

        return view;
    }

    public void setInfo(Shoe shoe) {
        imgvAnh.setImageResource(shoe.getImage());
    }

    private void anhXa() {
        imgvAnh = view.findViewById(R.id.imageview_nhan_hinhsp);
    }
}
