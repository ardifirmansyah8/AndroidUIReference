package com.smltech.uiux.androiduireference.ui.adapter.recyclerview;

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
 * Created by Fauziah on 2/21/2017.
 */

public class SwipeOnLongPressMenuAdapter extends RecyclerView.Adapter<SwipeOnLongPressMenuAdapter.SwipeOnLongPressHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;

    public SwipeOnLongPressMenuAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback) {
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }

    @Override
    public SwipeOnLongPressMenuAdapter.SwipeOnLongPressHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_swipe_on_long, parent, false);
        SwipeOnLongPressMenuAdapter.SwipeOnLongPressHolder holder =
                new SwipeOnLongPressMenuAdapter.SwipeOnLongPressHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(SwipeOnLongPressMenuAdapter.SwipeOnLongPressHolder holder, final int position) {
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

    public class SwipeOnLongPressHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvMenuSwipeName)
        TextView tvMenuSwipeName;

        public SwipeOnLongPressHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
