package com.smltech.uiux.androiduireference.service;

import android.support.v7.widget.RecyclerView;

import static android.R.string.no;

/**
 * Created by Fauziah on 2/24/2017.
 */

public interface ItemTouchHelperAdapter {

    boolean onItemMove (int fromPosition, int toPosition);

    void onItemDismiss(int position);

}
