package com.yezi.aac;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yezi.aac.repository.Data;
import com.yezi.aac.repository.mock.dao.MockData;

import java.util.List;

import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ItemHolder> implements LifecycleObserver {

    private List<Data> mDatas;

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item, parent, false);
        return new ItemHolder(tv);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Data data = mDatas.get(position);
        holder.setText(((Data.TextContent)data.getContent().get(0)).content);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void setDatas(List<Data> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

}
