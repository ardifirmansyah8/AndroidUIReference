package com.smltech.uiux.androiduireference.ui.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.adapter.recyclerview.MainMenuAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private MainMenuAdapter adapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;

    @BindView(R.id.rvMainMenu)
    RecyclerView rvMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addMenu();
        initRecyclerView();
        loadMenu();

    }

    private void initRecyclerView(){
        llManager = new LinearLayoutManager(this);
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMainMenu.setLayoutManager(llManager);
    }

    private void loadMenu(){
        adapter = new MainMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuName) {
                Toast.makeText(MainActivity.this, menuName, Toast.LENGTH_SHORT).show();

                switch (menuName) {
                    case "RecyclerView":
                        Intent pilihanbutton = new Intent(MainActivity.this,RecyclerViewActivity.class);
                        startActivity(pilihanbutton);
                        break;
                }
                Toast.makeText(MainActivity.this, menuName, Toast.LENGTH_SHORT).show();

            }
        });
        rvMainMenu.setAdapter(adapter);
    }

    private void addMenu(){
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumyActivity.mainMenu.length; i++){
            list.add(new MenuUtamaBean(DataDumyActivity.mainMenu[i]));
        }
    }
}

