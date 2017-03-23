package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.DataDumy;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.SearchView.SearchViewVoiceMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/23/2017.
 */

public class SearchViewVoice extends Fragment {
    private SearchViewVoiceMenuAdapter searchViewVoiceMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = SearchViewVoice.class.getSimpleName();

    @Bind(R.id.rvVoice)
    android.support.v7.widget.RecyclerView rvVoiceView;

    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)){
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_searchview, new SearchViewVoice(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_voice_search_view, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initSearchView();
        loadMenu();
        return view;
    }

    private void initSearchView(){
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVoiceView.setLayoutManager(llManager);
    }
    private void loadMenu(){
        searchViewVoiceMenuAdapter = new SearchViewVoiceMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuVoice) {
                Toast.makeText(getContext(), menuVoice, Toast.LENGTH_SHORT).show();
                switch (menuVoice){
                    case "Arul":
                        break;
                }
            }
        });
        rvVoiceView.setAdapter(searchViewVoiceMenuAdapter);
       // rvVoiceView.setAdapter(searchViewVoiceMenuAdapter);
    }

    private void addMenu() {
        list =new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumy.searchVoiceView.length; i++){
            list.add(new MenuUtamaBean(DataDumy.searchVoiceView[i]));
        }

    }
}
