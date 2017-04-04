package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.FloatingActionButton.FabMenuAdapter;
import com.smltech.uiux.androiduireference.ui.adapter.FloatingActionButton.FloatingActionButtonMenuAdapter;
import com.smltech.uiux.androiduireference.ui.adapter.MaterialScrollBar.MaterialScroolBarMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/14/2017.
 */

public class FloatingActionButton extends Fragment {
    @Bind(R.id.cvFabMenu)
    CardView cvMenu;
    @Bind(R.id.cvFabDownload)
    CardView cvDownload;
    @Bind(R.id.cvFabProgress)
    CardView cvProgress;
    @Bind(R.id.cvFabLoader)
    CardView cvLoader;
    @Bind(R.id.cvFabToolbar)
    CardView cvToolbar;
    @Bind(R.id.cvFabReveal)
    CardView cvReveal;

    private FloatingActionButtonMenuAdapter floatingActionButtonMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = FloatingActionButton.class.getSimpleName();

    public static void showFragment(BaseActivity sourceActivity){
        if (!sourceActivity.isFragmentNotNull(TAG)){
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_fab, new FloatingActionButton(),TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    public FloatingActionButton(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_fab, container, false);
        ButterKnife.bind(this, view);
        cvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FabMenu.showFragment((BaseActivity) getActivity());
            }
        });
        return view;
    }

}