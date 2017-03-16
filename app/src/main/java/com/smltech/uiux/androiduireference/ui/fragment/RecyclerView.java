package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.MaterialTabs.MaterialTabsAdapter;
import com.smltech.uiux.androiduireference.ui.adapter.Recyclerview.RecyclerviewPagerAdapter;
import com.smltech.uiux.androiduireference.ui.adapter.Toolbar.QuickReturnToolbarMenuAdapter;
import com.smltech.uiux.androiduireference.ui.adapter.Toolbar.ToolbarMenuAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 2/21/2017.
 */

public class RecyclerView extends Fragment {

    @Bind(R.id.tabRecycleview)
    TabLayout tabRecyclerview;
    @Bind(R.id.vpRecycleview)
    ViewPager vpRecyclerview;

    public static final String TAG = RecyclerView.class.getSimpleName();
    public Object setAdapter;
    private ToolbarMenuAdapter adapter;
    private LinearLayoutManager layoutManager;

    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)) {
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_recyclerview, new RecyclerView(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.f_recyclerview, container, false);
            ButterKnife.bind(this, view);
            setupViewPager();
            setupTabLayout();
            return view;
        }


    private void setupViewPager() {
        vpRecyclerview.setAdapter(new RecyclerviewPagerAdapter(getActivity().getSupportFragmentManager()));

    }
    private void setupTabLayout() {
        tabRecyclerview.setupWithViewPager(vpRecyclerview);
        tabRecyclerview.setTabTextColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.hijau));
        tabRecyclerview.setupWithViewPager(vpRecyclerview);
    }

    public void setAdapter(ToolbarMenuAdapter adapter) {
        this.adapter = adapter;
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;

    }
}

