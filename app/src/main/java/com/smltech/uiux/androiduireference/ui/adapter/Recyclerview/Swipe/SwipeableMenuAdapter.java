package com.smltech.uiux.androiduireference.ui.adapter.Recyclerview.Swipe;

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
 * Created by Fauziah on 2/16/2017.
 */

public class SwipeableMenuAdapter extends RecyclerView.Adapter<SwipeableMenuAdapter.SwipeableMenuHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;
    public SwipeableMenuAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback){
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }

    @Override
    public SwipeableMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_swipe_recyclerview, parent, false);
        SwipeableMenuHolder holder = new SwipeableMenuHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(SwipeableMenuAdapter. SwipeableMenuHolder holder, final int position) {
        holder.tvMenuSwipeName.setText(dataSet.get(position).getMenuName());
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

    public class SwipeableMenuHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tvMenuSwipeName)
        TextView tvMenuSwipeName;

        public SwipeableMenuHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }}
    }
