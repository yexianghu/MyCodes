package com.yezi.aac.repository;

public interface DataRepository {
    LiveDataList load();
    void add(LiveDataList dataList);
}
