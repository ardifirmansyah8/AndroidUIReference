package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.FloatingActionButton.FabToolbarMenuAdapter;
import com.smltech.uiux.androiduireference.ui.adapter.SearchView.SearchViewDeafultMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 4/4/2017.
 */

public class FabToolbar extends Fragment {

    private FabToolbarMenuAdapter fabToolbarMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = FabToolbar.class.getSimpleName();

    @Bind(R.id.fab_toolbar)
    android.support.design.widget.FloatingActionButton fab_toolbar;

    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)) {
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_fab, new FabToolbar(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }


    }
    public FabToolbar(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fab_toolbar, container, false);
        ButterKnife.bind(this, view);
        fab_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FabToolbar.showFragment((BaseActivity)getActivity());
            }
        });
        return view;
    }
}