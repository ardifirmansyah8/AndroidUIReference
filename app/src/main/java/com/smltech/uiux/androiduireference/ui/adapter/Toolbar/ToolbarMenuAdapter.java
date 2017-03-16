package com.smltech.uiux.androiduireference.ui.adapter.Toolbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.adapter.Recyclerview.Swipe.SwipeMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/9/2017.
 */

public class ToolbarMenuAdapter extends RecyclerView.Adapter<ToolbarMenuAdapter.ToolbarMenuHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;

    public ToolbarMenuAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback) {
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }

    @Override
    public ToolbarMenuAdapter.ToolbarMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_toolbar, parent, false);
        ToolbarMenuAdapter.ToolbarMenuHolder holder = new ToolbarMenuAdapter.ToolbarMenuHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ToolbarMenuAdapter.ToolbarMenuHolder holder, final int position) {
        holder.tvMenuSwipeName.setText(dataSet.get(position).getMenuName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rowCallback != null) {
                    rowCallback.onRowClick(dataSet.get(position).getMenuName());
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ToolbarMenuHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvMenuSwipeName)
        TextView tvMenuSwipeName;

        public ToolbarMenuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}