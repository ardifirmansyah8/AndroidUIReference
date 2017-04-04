package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.*;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.DataDumy;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.FloatingActionButton.FabMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 4/4/2017.
 */

public class FabMenu extends Fragment {
    private FabMenuAdapter fabMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = FabMenu.class.getSimpleName();

    @Bind(R.id.rvFabMenu)
    RecyclerView rvFabMenu;

    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)) {
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_fab, new FabMenu(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fab_menu, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initFabMenu();
        loadMenu();
        return view;
    }

    private void initFabMenu(){
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFabMenu.setLayoutManager(llManager);

    }
    private void loadMenu(){
        fabMenuAdapter = new FabMenuAdapter(list, new RowCallback(){
            @Override
            public void onRowClick(String menuFabMenu) {
                switch (menuFabMenu){
                    case "Press the FAB to experiance the FAB Menu!":
                        break;
                }
            }
        });
        rvFabMenu.setAdapter(fabMenuAdapter);
    }
    private void addMenu(){
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumy.fabMenu.length; i++){
            list.add(new MenuUtamaBean(DataDumy.fabMenu[i]));
        }
    }
}

