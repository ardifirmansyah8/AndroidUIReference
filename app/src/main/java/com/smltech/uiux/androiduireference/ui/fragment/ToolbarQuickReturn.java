package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.DataDumy;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.Toolbar.QuickReturnToolbarMenuAdapter;
import com.smltech.uiux.androiduireference.ui.adapter.Toolbar.ToolbarCollapsingMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/10/2017.
 */

public class ToolbarQuickReturn extends Fragment {

   /* private QuickReturnToolbarMenuAdapter quickReturnToolbarMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = ToolbarQuickReturn.class.getSimpleName();

    @Bind(R.id.rvQuickReturn)
    ToolbarFragment rvQuickReturn;

    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)) {
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_recyclerview, new ToolbarQuickReturn(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_page_quickreturn_toolbar, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initToolbar();
        loadMenu();
        return view;
    }
    private void initToolbar(){
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvQuickReturn.setLayoutManager(llManager);
    }
    private void loadMenu(){
        quickReturnToolbarMenuAdapter = new QuickReturnToolbarMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuToolbar) {
                Toast.makeText(getContext(),menuToolbar, Toast.LENGTH_SHORT).show();
                switch (menuToolbar){
                    case "Android Studio, Android Studio adalah Lingkungan Pengembangan Terpadu - ":
                        break;

                }

            }
        });
        rvQuickReturn.setAdapter(quickReturnToolbarMenuAdapter);
        //rvQuickReturn.setAdapter(quickReturnToolbarMenuAdapter);
    }
    private void addMenu(){
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumy.quickReturnToolbar.length; i++){
            list.add(new MenuUtamaBean(DataDumy.quickReturnToolbar[i]));
        }
    }*/
}
