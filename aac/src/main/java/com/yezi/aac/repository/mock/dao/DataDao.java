package com.yezi.aac.repository.mock.dao;

import com.yezi.aac.repository.Data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DataDao {

    @Query("SELECT * FROM data")
    List<MockData> getAll();

    @Insert
    void insertAll(MockData... data);

    @Delete
    void delete(MockData data);
}
