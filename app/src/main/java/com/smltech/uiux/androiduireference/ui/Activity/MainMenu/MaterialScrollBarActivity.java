package com.smltech.uiux.androiduireference.ui.Activity.MainMenu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.fragment.MaterialScrollBar;

import butterknife.ButterKnife;

//27 Maret 2017


public class MaterialScrollBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_scroll_bar);
        ButterKnife.bind(this);
        initFragment();
    }

    private void initFragment() {
        MaterialScrollBar.showFragment(this);

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
        }else {
            finish();
        }
    }
}
