package com.smltech.uiux.androiduireference.ui.Activity.MainMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.fragment.FloatingActionButton;
import com.smltech.uiux.androiduireference.ui.fragment.MaterialTabs;
import com.smltech.uiux.androiduireference.ui.fragment.RecyclerView;

import butterknife.ButterKnife;

/**
 * Created by Fauziah on 2/13/2017.
 */

public class MaterialTabsActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materialtabs);
        ButterKnife.bind(this);
        initFragment();
    }
    private void initFragment(){
        MaterialTabs.showFragment(this);
        //FloatingActionButton.showFragment(this);
        // MaterialDialog.showFragment(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.home){
            finish();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 1){
            fm.popBackStack();
        } else {
            finish();
        }
    }

}