package com.smltech.uiux.androiduireference.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fauziah on 3/14/2017.
 */

public class FloatingActionButton extends Fragment {
    @Bind(R.id.btnmenu)
    Button btnmenu;
    @Bind(R.id.btndownload)
    Button btndownload;
    @Bind(R.id.btnprogress)
    Button btnprogress;
    @Bind(R.id.btnloader)
    Button btnloader;
    @Bind(R.id.btntoolbar)
    Button btntoolbar;
    @Bind(R.id.btnreveal)
    Button btnreveal;

    public static final String TAG = FloatingActionButton.class.getSimpleName();

    public static void showFragment(BaseActivity sourceActivity){
        if (!sourceActivity.isFragmentNotNull(TAG)){
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_fab, new FloatingActionButton(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    public FloatingActionButton(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_fab, container, false);
        ButterKnife.bind(this, view);
        fabMenu();
    return view;
    }

   private void fabMenu() {
       btnmenu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final com.github.clans.fab.FloatingActionButton fFloatingActionButton = new com.github.clans.fab.FloatingActionButton(getActivity());
           }
       });
   }
   }