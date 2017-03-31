package com.smltech.uiux.androiduireference.ui.adapter.MaterialTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.smltech.uiux.androiduireference.ui.fragment.MaterialTabsCategory1;
import com.smltech.uiux.androiduireference.ui.fragment.MaterialTabsCategory2;
import com.smltech.uiux.androiduireference.ui.fragment.MaterialTabsCategory3;

/**
 * Created by Fauziah on 3/14/2017.
 */

public class MaterialTabsPagerAdapter extends FragmentStatePagerAdapter {

    String[] title = new String[]{
            "Category 1", "Category 2", "Category 3"
    };

    public MaterialTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MaterialTabsCategory1();
                break;
            case 1:
                fragment = new MaterialTabsCategory2();
                break;
            case 2:
                fragment = new MaterialTabsCategory3();
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
