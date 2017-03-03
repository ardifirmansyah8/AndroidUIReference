package com.smltech.uiux.androiduireference.ui.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.fragment.PageA;
import com.smltech.uiux.androiduireference.ui.fragment.PageSwipe;
import com.smltech.uiux.androiduireference.ui.fragment.PageC;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {
    @BindView(R.id.tabRecycleview)
    TabLayout tabRecyclerview;
    @BindView(R.id.vpRecycleview)
    ViewPager vpRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);

        vpRecyclerview.setAdapter(new ViewPagerRecyclerviewAdapter(getSupportFragmentManager()));
        tabRecyclerview.setTabTextColors(getResources().getColor(R.color.windowBackground),getResources().getColor(R.color.hijau));
        tabRecyclerview.setupWithViewPager(vpRecyclerview);


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

