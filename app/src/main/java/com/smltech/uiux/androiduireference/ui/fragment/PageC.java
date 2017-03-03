package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smltech.uiux.androiduireference.R;

/**
 * Created by Fauziah on 2/14/2017.
 */

public class PageC extends Fragment {




    public PageC(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_page_c, container, false);
    }
}
