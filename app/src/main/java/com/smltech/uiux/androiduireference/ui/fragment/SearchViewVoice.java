package com.smltech.uiux.androiduireference.ui.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.*;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.DataDumy;
import com.smltech.uiux.androiduireference.data.bean.MenuUtamaBean;
import com.smltech.uiux.androiduireference.service.RowCallback;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.SearchView.SearchViewVoiceMenuAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.smltech.uiux.androiduireference.R.id.btnspeak;

/**
 * Created by Fauziah on 3/23/2017.
 */

public class SearchViewVoice extends Fragment {
    private SearchViewVoiceMenuAdapter searchViewVoiceMenuAdapter;
    private ArrayList<MenuUtamaBean> list;
    private LinearLayoutManager llManager;
    public static final String TAG = SearchViewVoice.class.getSimpleName();
    protected static final int RESULT_SPEECH = 1;


    @Bind(R.id.rvVoice)
    android.support.v7.widget.RecyclerView rvVoiceView;
    @Bind(btnspeak)
    ImageButton btnSpeak;
    @Bind(R.id.txtSpeak)
    TextView txtSpeak;
    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)){
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_searchview, new SearchViewVoice(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_voice_search_view, container, false);
        ButterKnife.bind(this, view);
        addMenu();
        initSearchView();
        loadMenu();


        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    txtSpeak.setText("");
                }catch (ActivityNotFoundException a){
                    Toast.makeText(getContext(), "Opps! Your device doesn't support Speech to Text", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }




    private void initSearchView(){
        llManager = new LinearLayoutManager(this.getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVoiceView.setLayoutManager(llManager);
    }
    private void loadMenu(){
        searchViewVoiceMenuAdapter = new SearchViewVoiceMenuAdapter(list, new RowCallback() {
            @Override
            public void onRowClick(String menuVoice) {
                switch (menuVoice){
                    case "Arul":
                        break;
                }
            }
        });
        rvVoiceView.setAdapter(searchViewVoiceMenuAdapter);
    }


    private void addMenu() {
        list =new ArrayList<MenuUtamaBean>();
        for (int i = 0; i < DataDumy.searchVoiceView.length; i++){
            list.add(new MenuUtamaBean(DataDumy.searchVoiceView[i]));
        }

    }
}
