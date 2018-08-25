package com.yezi.aac.repository;

import com.yezi.aac.repository.mock.MockDataServer;

import java.util.List;

public interface DataServer {

    LiveDataList fetchData();
}
