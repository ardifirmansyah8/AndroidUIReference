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
 * Created by Fauziah on 3/21/2017.
 */

public class SearchViewThemedMenuAdapter extends RecyclerView.Adapter<SearchViewThemedMenuAdapter.SearchViewThemedMenuHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;
    public SearchViewThemedMenuAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback){
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }
    @Override
    public SearchViewThemedMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_themed_search_view, parent, false);
        SearchViewThemedMenuHolder holder = new SearchViewThemedMenuHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(SearchViewThemedMenuHolder holder, final int position) {
        holder.tvMenuThemedSearchViewName.setText(dataSet.get(position).getMenuName());
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

    public class SearchViewThemedMenuHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvMenuThemedSearchViewName)
        TextView tvMenuThemedSearchViewName;
        public SearchViewThemedMenuHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
