package com.smltech.uiux.androiduireference.ui.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ryanzulham on 12/31/16.
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MainMenuHolder>{

    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;


    public MainMenuAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback) {
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }

    @Override
    public MainMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main, parent, false);
        MainMenuHolder holder = new MainMenuHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MainMenuAdapter.MainMenuHolder holder, final int position) {
        holder.tvMenuName.setText(dataSet.get(position).getMenuName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rowCallback != null){
                    rowCallback.onRowClick(dataSet.get(position).getMenuName());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MainMenuHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvMenuName)
        TextView tvMenuName;

        public MainMenuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
