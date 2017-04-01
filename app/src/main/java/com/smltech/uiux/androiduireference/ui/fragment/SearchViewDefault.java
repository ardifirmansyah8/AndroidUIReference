package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.DataDumy;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.SearchView.SearchViewDeafultMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/23/2017.
 */

public class SearchViewDefault extends Fragment {
    private SearchViewDeafultMenuAdapter searchViewDeafultMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = SearchViewDefault.class.getSimpleName();

    @Bind(R.id.rvDefault)
    android.support.v7.widget.RecyclerView rvDefault;

    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)) {
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_searchview, new SearchViewThemed(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_default_search_view, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initDeafultView();
        loadMenu();
        return view;
    }


    private void initDeafultView(){
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDefault.setLayoutManager(llManager);
    }


    private void loadMenu(){
        searchViewDeafultMenuAdapter = new SearchViewDeafultMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuDefault) {
                Toast.makeText(getContext(), menuDefault, Toast.LENGTH_SHORT).show();
                switch (menuDefault){
                    case "Arul":
                        break;
                }
            }
        });
        rvDefault.setAdapter(searchViewDeafultMenuAdapter);
    }
    private void addMenu(){
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i< DataDumy.searchDefaultView.length; i++){
            list.add(new MenuUtamaBean(DataDumy.searchDefaultView[i]));
        }
    }
}
