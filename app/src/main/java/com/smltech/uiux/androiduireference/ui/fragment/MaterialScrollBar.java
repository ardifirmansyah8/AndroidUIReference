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
import com.smltech.uiux.androiduireference.ui.adapter.MaterialScrollBar.MaterialScroolBarMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/27/2017.
 */

public class MaterialScrollBar extends Fragment {
    private MaterialScroolBarMenuAdapter materialScroolBarMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = MaterialScrollBar.class.getSimpleName();

    @Bind(R.id.rvScroll)
    android.support.v7.widget.RecyclerView rvScroll;

    public static void showFragment(BaseActivity sourceActivity){
        if (!sourceActivity.isFragmentNotNull(TAG)){
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_materialscrollbar, new MaterialScrollBar(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_material_scroll_bar, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initScrollBar();
        loadMenu();
        return view;
    }

    private void initScrollBar(){
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvScroll.setLayoutManager(llManager);
    }

    private void loadMenu(){
        materialScroolBarMenuAdapter = new MaterialScroolBarMenuAdapter(list, new RowCallback(){
            @Override
            public void onRowClick(String menuScroll) {
                Toast.makeText(getContext(), menuScroll, Toast.LENGTH_SHORT).show();
                switch (menuScroll){
                    case "Ana":
                        break;
                }
            }
        });
        rvScroll.setAdapter(materialScroolBarMenuAdapter);
    }

    private void addMenu(){
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumy.scrollBar.length; i++){
            list.add(new MenuUtamaBean(DataDumy.scrollBar[i]));
        }
    }
}
