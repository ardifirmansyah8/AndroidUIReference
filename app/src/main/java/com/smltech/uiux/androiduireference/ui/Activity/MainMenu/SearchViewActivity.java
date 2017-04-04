package com.smltech.uiux.androiduireference.ui.Activity.MainMenu;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.fragment.SearchView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchViewActivity extends BaseActivity {

    private Toolbar toolbar_searchdefault;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        ButterKnife.bind(this);
        toolbar_searchdefault = (Toolbar) findViewById(R.id.toolbar_searchdefault);
        initToolbar();
        initFragment();
    }

    private void initFragment(){
        SearchView.showFragment(this);

    }

    private void initToolbar() {
        setSupportActionBar(toolbar_searchdefault);/*
        getSupportActionBar().setTitle(null);*/
    }
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.toolbar_searchviewdefault);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchview, menu);
        return true;
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
