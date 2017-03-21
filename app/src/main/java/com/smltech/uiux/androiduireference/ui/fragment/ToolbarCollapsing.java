package com.smltech.uiux.androiduireference.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.DataDumy;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.Toolbar.ToolbarCollapsingMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/9/2017.
 */

public class ToolbarCollapsing extends Fragment {

    private ToolbarCollapsingMenuAdapter toolbarCollapsingMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = ToolbarCollapsing.class.getSimpleName();

    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.anim_toolbar)
    Toolbar toolbar;
    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)) {
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_toolbar, new ToolbarCollapsing(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_page_collapsing, container, false);
        ButterKnife.bind(this, view);
        toolbar.setTitle("My Title");
        return view;
    }


/*
    private void loadMenu() {
        toolbarCollapsingMenuAdapter = new ToolbarCollapsingMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuToolbar) {
                Toast.makeText(getContext(), menuToolbar, Toast.LENGTH_SHORT).show();
                switch (menuToolbar) {
                    case "Android Studio, Android Studio adalah Lingkungan Pengembangan Terpadu -":

                        break;

                }

            }
        });*/
        // rvcollapsing.setAdapter(toolbarCollapsingMenuAdapter);
    }

