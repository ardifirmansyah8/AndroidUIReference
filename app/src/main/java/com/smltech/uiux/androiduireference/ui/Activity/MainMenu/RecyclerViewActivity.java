package com.smltech.uiux.androiduireference.ui.Activity.MainMenu;

import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.fragment.RecyclerView;


import butterknife.ButterKnife;

public class RecyclerViewActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        initFragment();
    }

    private void initFragment() {
        RecyclerView.showFragment(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home){
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
           /* Snackbar snackbar = Snackbar.make(RecyclerViewActivity.this.findViewById(android.R.id.content), "Keluar ?", Snackbar.LENGTH_LONG).setAction("Ya", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            View view = snackbar.getView();
            TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_action);
            tv.setTypeface(null, Typeface.BOLD);
            snackbar.show();*/
            finish();
        }
    }
}