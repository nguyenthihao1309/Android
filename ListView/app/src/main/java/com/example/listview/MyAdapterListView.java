package com.example.listview;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class MyAdapterListView extends BaseAdapter {

    private Context context;
    private int layout;
    private List<SanPham> sanPhams;
    private GridView gridView;

    public MyAdapterListView(Context context, int layout, List<SanPham> sanPhams, GridView gridView) {
        this.context = context;
        this.layout = layout;
        this.sanPhams = sanPhams;
        this.gridView =gridView;
    }

    @Override
    public int getCount() {
        return sanPhams.size();
    }

    @Override
    public Object getItem(int i) {
        return sanPhams.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView tvTenSP, tvGiaSP;
        ImageView imgAnhSP;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.tvTenSP = view.findViewById(R.id.textview_tensanpham_landscape);
            viewHolder.tvGiaSP = view.findViewById(R.id.textview_giasanpham_landscape);
            viewHolder.imgAnhSP = view.findViewById(R.id.imageview_anhsanpham_landscape);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        if(gridView.getNumColumns()==2) {
            viewHolder.tvGiaSP.setTextSize(TypedValue.COMPLEX_UNIT_SP,10 );
            viewHolder.tvTenSP.setTextSize(TypedValue.COMPLEX_UNIT_SP,12 );
            viewHolder.imgAnhSP.getLayoutParams().height=120;

        }
        if (gridView.getNumColumns()==3){
            viewHolder.tvGiaSP.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
            viewHolder.tvTenSP.setTextSize(TypedValue.COMPLEX_UNIT_SP,8 );
            viewHolder.imgAnhSP.getLayoutParams().height=100;
        }
        if(gridView.getNumColumns()==4){
            viewHolder.tvGiaSP.setTextSize(TypedValue.COMPLEX_UNIT_SP, 6);
            viewHolder.tvTenSP.setTextSize(TypedValue.COMPLEX_UNIT_SP,6 );
            viewHolder.imgAnhSP.getLayoutParams().height=100;
        }

        SanPham sanPham = sanPhams.get(i);
        viewHolder.tvTenSP.setText(sanPham.getTenSanPham());
        DecimalFormat df = new DecimalFormat("###,###,### VNĐ");
        viewHolder.tvGiaSP.setText(df.format(sanPham.getGiaSanPham()));
        viewHolder.imgAnhSP.setImageResource(sanPham.getHinhAnh());

        return view;
    }
}
