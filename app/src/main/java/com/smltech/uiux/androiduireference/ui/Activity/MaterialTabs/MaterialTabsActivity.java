package com.smltech.uiux.androiduireference.ui.Activity.MaterialTabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.fragment.MaterialTabs;
import com.smltech.uiux.androiduireference.ui.fragment.RecyclerView;

import butterknife.ButterKnife;

/**
 * Created by Fauziah on 2/13/2017.
 */

public class MaterialTabsActivity extends AppCompatActivity {

    private FragmentTransaction fragmentTransaction;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materialtabs);
        ButterKnife.bind(this);
        initFragment();
    }
    private void initFragment(){
    fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.fr_materialtabs, new MaterialTabs());
        fragmentTransaction.commit();
    }
}
