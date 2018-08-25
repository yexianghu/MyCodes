package com.yezi.aac.repository.mock;

import android.content.Context;

import com.yezi.aac.repository.Data;
import com.yezi.aac.repository.DataRepository;
import com.yezi.aac.repository.LiveDataList;
import com.yezi.aac.repository.mock.dao.MockData;
import com.yezi.aac.repository.mock.dao.MockDataBase;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Room;

public class MockDataRepository implements DataRepository {

    private MockDataBase mDB;

    public MockDataRepository(Context context) {
        mDB = Room.databaseBuilder(context.getApplicationContext(), MockDataBase.class, "database").allowMainThreadQueries().build();
    }
    @Override
    public LiveDataList load() {
        LiveDataList ldl = new LiveDataList();
        new Thread(() -> {
            List<Data> datas = new ArrayList<>();
            for (MockData mockData : mDB.userDao().getAll()) {
                datas.add(mockData);
            }
            ldl.postValue(datas);
        }).start();
        return ldl;
    }

    public void add(LiveDataList dataList) {
        dataList.observeForever(data -> {
            Data[] dbItems = new Data[data.size()];
            for (int i=0; i<dbItems.length; i++) {
                dbItems[i] = dataList.getValue().get(i);
            }
            mDB.runInTransaction(new Runnable() {
                @Override
                public void run() {
                    MockData[] datas = new MockData[dbItems.length];
                    for (int i=0; i<datas.length; i++) {
                        datas[i] = (MockData) dbItems[i];
                    }
                    mDB.userDao().insertAll(datas);
                }
            });
        });
    }
}
