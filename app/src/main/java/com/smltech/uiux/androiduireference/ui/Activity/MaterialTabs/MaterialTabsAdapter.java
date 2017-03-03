package com.smltech.uiux.androiduireference.ui.Activity.MaterialTabs;

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
 * Created by Fauziah on 3/3/2017.
 */

public class MaterialTabsAdapter extends RecyclerView.Adapter<MaterialTabsAdapter.MaterialTabsHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;

    public MaterialTabsAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback) {
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }

    @Override
    public MaterialTabsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.materialtabs_row, parent, false);
        MaterialTabsHolder holder = new MaterialTabsHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MaterialTabsHolder holder, final int position) {
        holder.tvMenuMaterialTabsName.setText(dataSet.get(position).getMenuName());
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

    public class MaterialTabsHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvMenuMaterialTabsName)
        TextView tvMenuMaterialTabsName;

        public MaterialTabsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}