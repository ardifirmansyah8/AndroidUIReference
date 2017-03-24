package com.smltech.uiux.androiduireference.ui.adapter.SearchView;

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
 * Created by Fauziah on 3/23/2017.
 */

public class SearchViewDeafultMenuAdapter extends RecyclerView.Adapter<SearchViewDeafultMenuAdapter.SearchViewDefaultMenuHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;
    public SearchViewDeafultMenuAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback){
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }
    @Override
    public SearchViewDefaultMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_default_search_view, parent, false);
        SearchViewDefaultMenuHolder holder = new SearchViewDefaultMenuHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(SearchViewDefaultMenuHolder holder, final int position) {
        holder.tvMenuDefaultViewName.setText(dataSet.get(position).getMenuName());
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

    public class SearchViewDefaultMenuHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvMenuDefaultSearchViewName)
        TextView tvMenuDefaultViewName;
        public SearchViewDefaultMenuHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
