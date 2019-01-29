package com.power.mortex.mvvm.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Morteza Rahimi on 11/07/17.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
