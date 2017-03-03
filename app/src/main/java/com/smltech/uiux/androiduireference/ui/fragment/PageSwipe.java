package com.smltech.uiux.androiduireference.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.Activity.DataDumyActivity;
import com.smltech.uiux.androiduireference.ui.adapter.recyclerview.SwipeMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 2/14/2017.
 */

public class PageSwipe extends Fragment {
    private SwipeMenuAdapter swipeMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;

    @Bind(R.id.rvSwipe)
    RecyclerView rvSwipe;


    public PageSwipe(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_page_swipe, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initRecyclerView();
        loadMenu();
        return view;

    }

    private void initRecyclerView(){
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSwipe.setLayoutManager(llManager);
    }

    private void loadMenu(){
        swipeMenuAdapter = new SwipeMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuRecyclerView) {
                Toast.makeText(getContext(), menuRecyclerView, Toast.LENGTH_SHORT).show();

                switch (menuRecyclerView){
                    case "SWIPEABLE":
                        /*Toast.makeText(getContext(), menuRecyclerView, Toast.LENGTH_SHORT).show();*/
                       /* Intent pilihanbutton = new Intent(getContext(), menuRecyclerView.class);
                        startActivity(pilihanbutton);*/
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.fr_recyclerview, new PageSwipeable());
                        ft.commit();
                        break;

                    case "SWIPE ON LONG PRESS":
                        FragmentTransaction FT = getFragmentManager().beginTransaction();
                        FT.replace(R.id.fr_recyclerview, new PageSwipeOnLongPress());
                        FT.commit();
                        break;
                }



            }
        });
        rvSwipe.setAdapter(swipeMenuAdapter);
    }


    private void addMenu(){
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumyActivity.recyclerViewMenu.length; i++){
            list.add(new MenuUtamaBean(DataDumyActivity.recyclerViewMenu[i]));

        }
    }
}
