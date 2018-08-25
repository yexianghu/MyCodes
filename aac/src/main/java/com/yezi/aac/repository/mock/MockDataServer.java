package com.yezi.aac.repository.mock;

import android.util.Log;

import com.yezi.aac.repository.Data;
import com.yezi.aac.repository.DataServer;
import com.yezi.aac.repository.LiveDataList;
import com.yezi.aac.repository.mock.dao.MockData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockDataServer implements DataServer {

    private static final String TAG = "AAC_MockDataServer";
    private static final int REQUEST_COUNT = 20;

    private Random mRandom = new Random(System.currentTimeMillis());

    private int mCurIdx = 0;


    @Override
    public LiveDataList fetchData() {
        LiveDataList ldl = new LiveDataList();

        new Thread(() -> {
            int sleepSeconds = (mRandom.nextInt(5) + 1) * 1000;
            try {
                Log.d(TAG, "sleep " + sleepSeconds + " then execute");
                Thread.sleep(sleepSeconds);
                ldl.postValue(buildMockData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return ldl;
    }

    private List<Data> buildMockData() {
        int count = REQUEST_COUNT;
        List<Data> resultList = new ArrayList<>();
        while(count > 0) {
            resultList.add(new MockData("item --- " + mCurIdx));
            mCurIdx++;
            count--;
        }
        return resultList;
    }
}
