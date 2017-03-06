package com.smltech.uiux.androiduireference.ui.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ryanzulham on 3/4/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean isFragmentNotNull(String tag) {
        if (getSupportFragmentManager().findFragmentByTag(tag) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFragmentVisible(String tag) {
        if (isFragmentNotNull(tag)
                && getSupportFragmentManager().findFragmentByTag(tag).isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    public Fragment getVisibleFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }
}
