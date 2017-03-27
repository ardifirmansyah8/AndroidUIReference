package com.smltech.uiux.androiduireference.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.Activity.MainMenu.SearchViewActivity;
import com.smltech.uiux.androiduireference.ui.adapter.SearchView.SearchViewMenuAdapter;
import com.smltech.uiux.androiduireference.ui.adapter.SearchView.SearchViewVoiceMenuAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchView extends Fragment {
    @Bind(R.id.cvVoiceSearch)
    CardView cvVoice;
    @Bind(R.id.cvThemedSearch)
    CardView cvThemed;
    @Bind(R.id.cvDefaultSearch)
    CardView cvDefault;

    public static final String TAG = SearchView.class.getSimpleName();
    public Object setAdapter;
    private LinearLayoutManager layoutManager;
    private boolean displayHomeAsUpEnabled;
    private SearchViewVoiceMenuAdapter adapter;

    public static void showFragment (BaseActivity sourceActivity){
        if (!sourceActivity.isFragmentNotNull(TAG)){
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_searchview, new SearchView(),TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }


    public SearchView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_search_view, container, false);
        ButterKnife.bind(this, view);
        cvVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchViewVoice.showFragment((BaseActivity)getActivity());

            }
        });

        cvThemed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchViewThemed.showFragment((BaseActivity)getActivity());
            }
        });

        cvDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchViewDefault.showFragment((BaseActivity)getActivity());
            }
        });
        return view;
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public void setAdapter(SearchViewVoiceMenuAdapter adapter) {
        this.adapter = adapter;
    }
}
