package com.smltech.uiux.androiduireference.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.adapter.recyclerview.MainMenuAdapter;

import java.io.Serializable;
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

    /**
     * Methode untuk inisiasi recyclerview
     */
    private void initRecyclerView(){
        llManager = new LinearLayoutManager(this);
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMainMenu.setLayoutManager(llManager);
    }

    /**
     * Methode untuk menampilkan menu yang sudah di tambahkan ke recyclerview
     * Dan untuk menghandle action klik pada menu yang ditampilkan
     */
    private void loadMenu(){
        adapter = new MainMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuName) {
                switch (menuName){
                    case "RecyclerView":
                        //Lakukan Action disini
                        break;
                    case "Toolbar":
                        //Lakukan Action disini
                        break;
                    case "Material Tabs":
                        //Lakukan Action disini
                        break;
                    case "Material Dialogs":
                        //Lakukan Action disini
                        break;
                    case "Floating Action Button":
                        //Lakukan Action disini
                        break;
                    default:
                        break;
                }

            }
        });
        rvMainMenu.setAdapter(adapter);
    }

    /**
     * Methode untuk menambahkan menu pada recyclerview
     */
    private void addMenu(){
        list = new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumyActivity.mainMenu.length; i++){
            list.add(new MenuUtamaBean(DataDumyActivity.mainMenu[i]));
        }
    }
}

