package com.example.lab_06_fagment_figma;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FragmentShoesPortrait extends Fragment {
    ArrayList<Shoe> shoes;
    AdapterShoe adapterShoe;
    TruyenShoes truyenShoes;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_shoe, container, false);
        listView = view.findViewById(R.id.listview);
        truyenShoes = (TruyenShoes) getActivity();

        shoes = new ArrayList<>();
        addSanPham();
        adapterShoe = new AdapterShoe(getActivity(), R.layout.layout_item_sanpham, shoes);
        listView.setAdapter(adapterShoe);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                v.setSelected(true);
                truyenShoes.dataShoe(shoes.get(i));
            }
        });

        return view;
    }
    private void addSanPham(){

        shoes.add(new Shoe("Nike shoes-discount 50%","",R.drawable.shoes_nike));
        shoes.add(new Shoe("Adidas shoes-discount 80%","",R.drawable.shoes_adidas));
        shoes.add(new Shoe("Nike Bicycle-discount 30%","",R.drawable.shoes_nike_green));
        shoes.add(new Shoe("Yonex shoes-discount 50%","",R.drawable.shoes_yonex));
        shoes.add(new Shoe("Victor shoes-discount 50%","",R.drawable.shoes_victor));
        shoes.add(new Shoe("Lining shoes-discount 50%","",R.drawable.shoes_lining));
        shoes.add(new Shoe("Binh Minh shoes-discount 90%","",R.drawable.color_binhminh));
    }
}
