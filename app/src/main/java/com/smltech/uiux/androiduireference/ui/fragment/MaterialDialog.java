package com.smltech.uiux.androiduireference.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.smltech.uiux.androiduireference.R;
import com.smltech.uiux.androiduireference.data.DataDumy;
import com.smltech.uiux.androiduireference.ui.Activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialDialog extends Fragment {
    @Bind(R.id.btnshow)
    Button btnshow;
    @Bind(R.id.btnmessage)
    Button btnmessage;
    @Bind(R.id.btnlist)
    Button btnlist;
    @Bind(R.id.btncheckbox)
    Button btncheckbox;
    @Bind(R.id.btnradiobutton)
    Button btnradiobutton;
    @Bind(R.id.btnedit)
    Button btnedit;


    public static final String TAG = MaterialDialog.class.getSimpleName();

    public static void showFragment(BaseActivity sourceActivity) {
        if (!sourceActivity.isFragmentNotNull(TAG)) {
            FragmentTransaction fragmentTransaction = sourceActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_materialdialog, new MaterialDialog(), TAG).addToBackStack(TAG);
            fragmentTransaction.commit();
        }
    }


    public MaterialDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_material_dialog, container, false);
        ButterKnife.bind(this, view);
        showmessage();
        longmessage();
        showlist();
        showcheckbox();
        showradiobutton();
        showedittext();
        return view;
    }


    private void showmessage() {
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final me.drakeet.materialdialog.MaterialDialog mMaterialDialog = new me.drakeet.materialdialog.MaterialDialog(getActivity());
                mMaterialDialog.setTitle("Show Message");
                mMaterialDialog.setMessage("Hello Fauziah");
                mMaterialDialog.setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.setNegativeButton("CANCEL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.show();
            }
        });
    }
    private void longmessage(){
        btnmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final me.drakeet.materialdialog.MaterialDialog mMaterialDialog = new me.drakeet.materialdialog.MaterialDialog(getActivity());
                mMaterialDialog.setTitle("Long Message");
                mMaterialDialog.setMessage("Fauziah Rabbani Aziz 1401082002 TK.3B Politeknik Negeri Padang 2017");
                mMaterialDialog.setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.setNegativeButton("CANCEL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.show();
            }
        });
    }
    private void showlist(){
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_list_item_1);
                /*for (int j = 0; j < 10; j++){
                    arrayAdapter.add(DataDumy.showListNegara[j-1]);
                }*/
                int i = 0;
                while (i <= 9){
                    arrayAdapter.add(DataDumy.showListNegara[i]);
                    i++;
                }

                ListView listView = new ListView(getContext());
                listView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (8 * scale + 0.5f);
                listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
                listView.setDividerHeight(0);
                listView.setAdapter(arrayAdapter);

                final me.drakeet.materialdialog.MaterialDialog mMaterialDialog = new me.drakeet.materialdialog.MaterialDialog(getActivity());
                mMaterialDialog.setTitle("Pilih Negara").setContentView(listView);
                mMaterialDialog.setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.show();

            }
        });
    }
    // 7 Maret 2017
    private void showcheckbox(){
        btncheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final me.drakeet.materialdialog.MaterialDialog mMaterialDialog = new me.drakeet.materialdialog.MaterialDialog(getActivity());
                mMaterialDialog.setTitle("Pilih Social Media").setContentView(R.layout.material_dialog_checkbox);
                mMaterialDialog.setPositiveButton("Pilih", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.setNegativeButton("Batal", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.show();
            }
        });
    }

    private void showradiobutton(){
        btnradiobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final me.drakeet.materialdialog.MaterialDialog mMaterialDialog = new me.drakeet.materialdialog.MaterialDialog(getActivity());
                mMaterialDialog.setTitle("Pilih Jurusan").setContentView(R.layout.material_dialog_radiobutton);
                mMaterialDialog.setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.setNegativeButton("CANCEL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.show();
            }
        });
    }
    private void showedittext(){
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final me.drakeet.materialdialog.MaterialDialog mMaterialDialog = new me.drakeet.materialdialog.MaterialDialog(getActivity());
                mMaterialDialog.setTitle("Isi Form").setContentView(R.layout.material_dialog_edit_text);
                mMaterialDialog.setPositiveButton("LANJUT", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.setNegativeButton("BATAL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
                mMaterialDialog.show();
            }
        });
    }

}




