package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.ui.adapter.MaterialTabs.MaterialTabsAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/3/2017.
 */
public class MaterialTabsPage extends Fragment {
    private MaterialTabsAdapter materialTabsAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.f_page_materialtabs, container, false);
        ButterKnife.bind(this, rootView);
       /* addMenu();
        initRecyclerView();
        loadMenu();*/
        return rootView;
    }
    /*private void initRecyclerView(){
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llManager);
    }
    private void loadMenu(){
        materialTabsAdapter = new MaterialTabsAdapter (list, new RowCallback() {
            @Override
            public void onRowClick(String menuRecylerView) {
                Toast.makeText(getContext(), menuRecylerView, Toast.LENGTH_SHORT).show();
                switch (menuRecylerView){
                    case "Laguiole":
                        FragmentTransaction ft =getFragmentManager().beginTransaction();
                        ft.replace(R.id.fr_materialtabs, new MaterialTabsCategory1());
                        ft.commit();
                        break;
                }

            }
        });
        recyclerView.setAdpater(materialTabsAdapter);
    }
    private void addMenu(){
        list = new ArrayList<MenuUtamaBean>();
        for (int i =0; i< DataDumy.materialTabsMenu.length; i++){
            list.add(new MenuUtamaBean(DataDumy.materialTabsMenu[i]));
        }
    }
*/
}
