package com.smltech.uiux.androiduireference.ui.adapter.MaterialScrollBar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/27/2017.
 */

public class MaterialScroolBarMenuAdapter extends RecyclerView.Adapter<MaterialScroolBarMenuAdapter.MaterialScrollBarMenuHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;
    public MaterialScroolBarMenuAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback) {
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;

    }

    @Override
    public MaterialScrollBarMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_material_scroll_bar, parent, false);
        MaterialScrollBarMenuHolder holder = new MaterialScrollBarMenuHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MaterialScrollBarMenuHolder holder, final int position) {
        holder.tvMenuScrollViewName.setText(dataSet.get(position).getMenuName());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (rowCallback !=null){
                    rowCallback.onRowClick(dataSet.get(position).getMenuName());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MaterialScrollBarMenuHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvMenuScrollViewName)
        TextView tvMenuScrollViewName;
        public MaterialScrollBarMenuHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
