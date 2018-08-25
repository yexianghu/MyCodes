package com.yezi.aac;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemHolder extends RecyclerView.ViewHolder {

    public ItemHolder(View itemView) {
        super(itemView);
    }

    public void setText(String text) {
        if (itemView instanceof TextView) {
            ((TextView) itemView).setText(text);
        }
    }
}
