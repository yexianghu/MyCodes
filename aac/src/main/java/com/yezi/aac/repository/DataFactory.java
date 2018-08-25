package com.yezi.aac.repository;

import android.content.Context;

import com.yezi.aac.repository.mock.MockDataRepository;
import com.yezi.aac.repository.mock.MockDataServer;

public class DataFactory {

    public static DataRepository getReopository(Context context) {
        return new MockDataRepository(context);
    }

    public static DataServer getServer(Context context) {
        return new MockDataServer();
    }
}
