package com.smltech.uiux.androiduireference.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smltech.uiux.androiduireference.R;

import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
    }
}
