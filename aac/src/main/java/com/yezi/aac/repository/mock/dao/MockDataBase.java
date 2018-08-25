package com.yezi.aac.repository.mock.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MockData.class}, version = 1, exportSchema = false)
public abstract class MockDataBase extends RoomDatabase {
    public abstract DataDao userDao();
}
