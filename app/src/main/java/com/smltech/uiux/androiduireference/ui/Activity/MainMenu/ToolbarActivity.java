package com.smltech.uiux.androiduireference.ui.Activity.MainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.smltech.uiux.androiduireference.R;

import butterknife.ButterKnife;

/**
 * Created by Didisrahmatita on 2/9/2017.
 */

public class ToolbarActivity extends AppCompatActivity implements View.OnClickListener {

    Button collapsingToolbar,quickReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        ButterKnife.bind(this);

        collapsingToolbar=(Button) findViewById(R.id.btncollapsingToolbar);
        collapsingToolbar.setOnClickListener(this);
        quickReturn=(Button) findViewById(R.id.btnquickreturn);
        quickReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btncollapsingToolbar:

                break;


            case R.id.btnquickreturn:


                break;


        }

    }
}
