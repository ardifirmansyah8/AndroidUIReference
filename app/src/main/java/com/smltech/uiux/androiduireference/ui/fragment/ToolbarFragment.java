package com.smltech.uiux.androiduireference.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;
import com.smltech.uiux.androiduireference.ui.adapter.Toolbar.ToolbarMenuAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToolbarFragment extends Fragment {
    @Bind(R.id.cvCollapsToolbar)
    CardView cvCollapsing;
    @Bind(R.id.cvQuickReturn)
    CardView cvQuickReturn;


    public static final String TAG = ToolbarFragment.class.getSimpleName();
    public Object setAdpater;
    private ToolbarMenuAdapter layoutManager;
    private boolean displayHomeAsUpEnabled;

    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)) {
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_toolbar, new ToolbarFragment(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }

    public ToolbarFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_toolbar, container, false);
        ButterKnife.bind(this, view);
        cvCollapsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolbarCollapsing.showFragment((BaseActivity) getActivity());
            }
        });
        return view;
    }
}







    /*@OnClick(R.id.cvCollapsToolbar)
    void onClickCollaps(){
        Toast.makeText(getContext(), "Collapse Toolbar", Toast.LENGTH_SHORT).show();
    }*/
