package com.yezi.aac;

import android.content.Context;
import android.util.Log;

import com.yezi.aac.repository.Data;
import com.yezi.aac.repository.DataFactory;
import com.yezi.aac.repository.LiveDataList;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class ListViewModel extends ViewModel {

    private static final String TAG = "AAC_ListViewModel";

    private MediatorLiveData<List<Data>> mLiveDatas;

    public MediatorLiveData<List<Data>> getListData(Context ctx) {
        Log.d(TAG, "getListData");
        if (mLiveDatas == null) {
            mLiveDatas = new MediatorLiveData<>();
            mLiveDatas.addSource(DataFactory.getReopository(ctx).load(), data -> {
                if (data.isEmpty()) {
                    loadMore(ctx);
                } else {
                    mLiveDatas.postValue(data);
                }
            });
        }
        return mLiveDatas;
    }

    public void loadMore(Context ctx) {
        Log.d(TAG, "loadMore");
        LiveDataList ldl = DataFactory.getServer(ctx).fetchData();
        DataFactory.getReopository(ctx).add(ldl);
        mLiveDatas.addSource(ldl, data -> {
            List<Data> currentDatas = mLiveDatas.getValue();
            if (currentDatas == null) {
                currentDatas = new ArrayList<>();
            }
            currentDatas.addAll(data);
            mLiveDatas.postValue(currentDatas);
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
