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
 * Created by Fauziah on 2/14/2017.
 */

public class SwipeMenuAdapter extends RecyclerView.Adapter<SwipeMenuAdapter.SwipeMenuHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;

    public SwipeMenuAdapter (ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback){
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }

    @Override
    public SwipeMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_swipe_recyclerview, parent, false);
        SwipeMenuHolder holder = new SwipeMenuHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(SwipeMenuAdapter. SwipeMenuHolder holder, final int position) {
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

    public class SwipeMenuHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tvMenuSwipeName)
        TextView tvMenuSwipeName;

        public SwipeMenuHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
