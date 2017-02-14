package com.smltech.uiux.androiduireference.ui.Activity.MaterialTabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.smltech.uiux.androiduireference.R;

import butterknife.ButterKnife;

/**
 * Created by Fauziah on 2/13/2017.
 */

public class MaterialTabsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materialtabs);
        ButterKnife.bind(this);
    }
}
