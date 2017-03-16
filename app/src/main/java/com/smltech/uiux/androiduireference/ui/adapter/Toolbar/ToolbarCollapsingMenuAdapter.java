package com.smltech.uiux.androiduireference.ui.adapter.Toolbar;

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
 * Created by Fauziah on 3/9/2017.
 */

public class ToolbarCollapsingMenuAdapter extends RecyclerView.Adapter<ToolbarCollapsingMenuAdapter.CollapsingMenuHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;

    public ToolbarCollapsingMenuAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback) {
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }

    @Override
    public CollapsingMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_toolbar, parent, false);
        CollapsingMenuHolder holder = new CollapsingMenuHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ToolbarCollapsingMenuAdapter.CollapsingMenuHolder holder, final int position) {
        holder.tvMenuCollapsingName.setText(dataSet.get(position).getMenuName());
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

    public class CollapsingMenuHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvMenuCollapsingName)
        TextView tvMenuCollapsingName;

        public CollapsingMenuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}