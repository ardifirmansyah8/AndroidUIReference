package com.smltech.uiux.androiduireference.ui.adapter.Recyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.smltech.uiux.androiduireference.ui.fragment.RecyclerViewPageA;
import com.smltech.uiux.androiduireference.ui.fragment.RecyclerViewPageC;
import com.smltech.uiux.androiduireference.ui.fragment.RecyclerViewPageSwipe;

/**
 * Created by ryanzulham on 3/4/17.
 */

public class RecyclerviewPagerAdapter extends FragmentStatePagerAdapter{

    String[] title = new String[]{
            "DRAG", "SWIPE", "EXPAND"
    };
    public RecyclerviewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new RecyclerViewPageA();
                break;
            case 1:
                fragment = new RecyclerViewPageSwipe();
                break;
            case 2:
                fragment = new RecyclerViewPageC();
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
