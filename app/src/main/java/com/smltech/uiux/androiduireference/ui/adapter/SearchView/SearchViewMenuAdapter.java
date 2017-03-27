package com.smltech.uiux.androiduireference.ui.adapter.SearchView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;

import java.text.CollationElementIterator;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/21/2017.
 */

public class SearchViewMenuAdapter extends RecyclerView.Adapter<SearchViewMenuAdapter.SearchViewMenuHolder> {
    private ArrayList<MenuUtamaBean> dataSet;
    private RowCallback rowCallback;

    public SearchViewMenuAdapter(ArrayList<MenuUtamaBean> dataSet, RowCallback rowCallback){
        this.dataSet = dataSet;
        this.rowCallback = rowCallback;
    }
    @Override
    public SearchViewMenuAdapter.SearchViewMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_search_view, parent, false);
        SearchViewMenuAdapter.SearchViewMenuHolder holder = new SearchViewMenuAdapter.SearchViewMenuHolder(itemView);
        return holder ;
    }

    @Override
    public void onBindViewHolder(SearchViewMenuHolder holder, final int position) {
        holder.tvMenuSearchViewName.setText(dataSet.get(position).getMenuName());
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

    public class SearchViewMenuHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvMenuSearchViewName)
        TextView tvMenuSearchViewName;
        public CollationElementIterator tvMenuSearchView;

        public SearchViewMenuHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
