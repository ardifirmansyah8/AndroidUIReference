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
import com.smltech.uiux.androiduireference.ui.adapter.MaterialTabs.MaterialTabsPagerAdapter;
import com.smltech.uiux.androiduireference.ui.adapter.Toolbar.ToolbarMenuAdapter;

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

    public static final String TAG = MaterialTabs.class.getSimpleName();
    public Object setAdapter;
    private ToolbarMenuAdapter adapter;
    private LinearLayoutManager layoutManager;

    public static void showFragment(BaseActivity sourceActivity){
        if (!sourceActivity.isFragmentNotNull(TAG)){
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_materialtabs, new MaterialTabs(),TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_materialtabs, container, false);
        ButterKnife.bind(this, view);
        setupViewPager();
        setupTabLayout();
        return view;
    }

private void setupViewPager() {
    vpMaterialtabs.setAdapter(new MaterialTabsPagerAdapter(getActivity().getSupportFragmentManager()));

}
    private void setupTabLayout(){
tabMaterialtabs.setupWithViewPager(vpMaterialtabs);
tabMaterialtabs.setTabTextColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.hijau));
tabMaterialtabs.setupWithViewPager(vpMaterialtabs);
}

    public void setSetAdapter(ToolbarMenuAdapter adapter){
        this.adapter = adapter;
    }

    public void setLayoutManager(LinearLayoutManager layoutManager){
        this.layoutManager = layoutManager;
    }
}
