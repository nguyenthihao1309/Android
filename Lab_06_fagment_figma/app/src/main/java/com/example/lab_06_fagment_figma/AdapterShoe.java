package com.example.lab_06_fagment_figma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterShoe extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Shoe> shoes;

    public AdapterShoe(Context context, int layout, List<Shoe> shoes) {
        this.context = context;
        this.layout = layout;
        this.shoes = shoes;
    }

    @Override
    public int getCount() {
        return shoes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private  class ViewHolder{
        TextView tvName;
        ImageView imgvAvt;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.tvName = view.findViewById(R.id.textview_itemlist_motasp);
            holder.imgvAvt = view.findViewById(R.id.textview_itemlist_hinh);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Shoe shoe = shoes.get(i);
        holder.tvName.setText(shoe.getName());
        holder.imgvAvt.setImageResource(shoe.getImage());
        return view;
    }
}
