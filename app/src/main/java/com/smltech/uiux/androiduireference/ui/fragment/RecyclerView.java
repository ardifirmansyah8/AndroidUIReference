package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.MaterialTabs.MaterialTabsAdapter;

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
    private LinearLayoutManager layoutManager;
    private MaterialTabsAdapter adpater;


    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.f_recyclerview, container, false);
            ButterKnife.bind(this, view);

            vpRecyclerview.setAdapter(new RecyclerView.ViewPagerRecyclerviewAdapter(getFragmentManager()));
            tabRecyclerview.setTabTextColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.hijau));
            tabRecyclerview.setupWithViewPager(vpRecyclerview);
            return view;
        }

    public void setLayoutManager(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public void setAdpater(MaterialTabsAdapter adpater) {
        this.adpater = adpater;
    }


    class ViewPagerRecyclerviewAdapter extends FragmentPagerAdapter {
            String[] title = new String[]{
                    "DRAG", "SWIPE", "EXPAND"
            };

            public ViewPagerRecyclerviewAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new PageA();
                        break;
                    case 1:
                        fragment = new PageSwipe();
                        break;
                    case 2:
                        fragment = new PageC();
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