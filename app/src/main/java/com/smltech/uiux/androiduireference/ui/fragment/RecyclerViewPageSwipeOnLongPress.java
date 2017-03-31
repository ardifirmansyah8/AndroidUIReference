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
import com.smltech.uiux.androiduireference.data.DataDumy;
import com.smltech.uiux.androiduireference.ui.adapter.Recyclerview.Swipe.SwipeOnLongPressMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 2/21/2017.
 */

public class RecyclerViewPageSwipeOnLongPress extends Fragment {
    private SwipeOnLongPressMenuAdapter swipeOnLongPressMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;

    @Bind(R.id.rvSwipeOnLongPress)
    RecyclerView rvSwipeOnLongPress;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_page_swipe_on_recyclerview, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initRecyclerView();
        loadMenu();
        return view;
    }

    private void initRecyclerView() {
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSwipeOnLongPress.setLayoutManager(llManager);
    }

    private void loadMenu() {
        swipeOnLongPressMenuAdapter = new SwipeOnLongPressMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuRecyclerView) {
                Toast.makeText(getContext(), menuRecyclerView, Toast.LENGTH_SHORT).show();
                switch (menuRecyclerView) {
                    case "0 - A":
                        break;

                }
            }
        });
        rvSwipeOnLongPress.setAdapter(swipeOnLongPressMenuAdapter);
    }


    private void addMenu() {
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumy.swipeonlongpressViewMenu.length; i++) {
            list.add(new MenuUtamaBean(DataDumy.swipeonlongpressViewMenu[i]));

        }
    }
}
