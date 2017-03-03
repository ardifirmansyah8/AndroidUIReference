package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.smltech.uiux.androiduireference.ui.adapter.recyclerview.SwipeableMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 2/17/2017.
 */

public class PageSwipeable extends Fragment {
    private SwipeableMenuAdapter swipeableMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;


    @Bind(R.id.rvSwipeable)
    RecyclerView rvSwipeable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_page_swipeable, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initRecyclerView();
        loadMenu();
        return view;


    }

    private void initRecyclerView(){
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSwipeable.setLayoutManager(llManager);
    }

    private void loadMenu(){
        swipeableMenuAdapter = new SwipeableMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuRecyclerView) {
                Toast.makeText(getContext(), menuRecyclerView, Toast.LENGTH_SHORT).show();

                switch (menuRecyclerView){
                    case "0 - A":
                       /* Toast.makeText(getContext(), menuRecyclerView, Toast.LENGTH_SHORT).show();*/
                        //Intent pilihanbutton = new Intent(getContext(), PageSwipeable.class);
                        //startActivity(pilihanbutton);
                        break;   }



            }
        });
        rvSwipeable.setAdapter(swipeableMenuAdapter);
    }


    private void addMenu() {
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumyActivity.swipeableViewMenu.length; i++) {
            list.add(new MenuUtamaBean(DataDumyActivity.swipeableViewMenu[i]));
        }
    }
}