package com.smltech.uiux.androiduireference.ui.Activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.fragment.RecyclerView;

import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity{
    private FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        initFragment();
    }

    private void initFragment() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fr_recyclerview, new RecyclerView());
        fragmentTransaction.commit();
    }
}