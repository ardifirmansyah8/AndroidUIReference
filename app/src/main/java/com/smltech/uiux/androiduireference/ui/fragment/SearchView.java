package com.smltech.uiux.androiduireference.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.MainMenu.SearchViewActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchView extends Fragment {


    public SearchView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.f_search_view, container, false);
    }

    public static void showFragment(SearchViewActivity searchViewActivity) {

    }
}
