package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.MaterialTabs.MaterialTabsAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/1/2017.
 */

public class MaterialTabs extends Fragment {
    @Bind(R.id.tabMaterialtabs)
    TabLayout tabMaterialtabs;
    @Bind(R.id.vpMaterialtabs)
    ViewPager vpMaterialtabs;
    private LinearLayoutManager layoutManager;
    private MaterialTabsAdapter adpater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_materialtabs, container, false);
        ButterKnife.bind(this, view);

        vpMaterialtabs.setAdapter(new MaterialTabs.ViewPagerMaterialtabsAdapter(getFragmentManager()));
        tabMaterialtabs.setTabTextColors(getResources().getColor(R.color.colorAccent),getResources().getColor(R.color.hijau));
        tabMaterialtabs.setupWithViewPager(vpMaterialtabs);
        return view;
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public void setAdpater(MaterialTabsAdapter adpater) {
        this.adpater = adpater;
    }

    class ViewPagerMaterialtabsAdapter extends FragmentPagerAdapter {
        String[] title = new String[]{
                "Material Tabs"
        };

        public ViewPagerMaterialtabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new PageMaterialTab();
                    break;
                default:
                    fragment = null;
                    break;
            }
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public int getCount() {
            return title.length;
        }
    }
}