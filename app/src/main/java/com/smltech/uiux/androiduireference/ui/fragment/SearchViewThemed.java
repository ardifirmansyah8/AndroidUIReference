package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.DataDumy;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.SearchView.SearchViewThemedMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/23/2017.
 */

public class SearchViewThemed extends Fragment {
    private SearchViewThemedMenuAdapter searchViewThemedMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = SearchViewThemed.class.getSimpleName();

    @Bind(R.id.rvTheme)
    android.support.v7.widget.RecyclerView rvTheme;

    public static void showFragment(BaseActivity sourceActivity){
        if (!sourceActivity.isFragmentNotNull(TAG)){
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_searchview, new SearchViewThemed(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_themed_search_view, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initThemedSearchView();
        loadMenu();
        return view;
    }

    private void initThemedSearchView() {
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTheme.setLayoutManager(llManager);
    }

    private void loadMenu(){
        searchViewThemedMenuAdapter = new SearchViewThemedMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuTheme) {
                Toast.makeText(getContext(), menuTheme, Toast.LENGTH_SHORT).show();
                switch (menuTheme){
                    case "Arul":
                        break;
                }
            }
        });
        rvTheme.setAdapter(searchViewThemedMenuAdapter);
    }

    private void addMenu(){
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumy.searchThemeView.length; i++){
            list.add(new MenuUtamaBean(DataDumy.searchThemeView[i]));
        }
    }
}
