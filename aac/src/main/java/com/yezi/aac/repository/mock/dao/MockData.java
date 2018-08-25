package com.yezi.aac.repository.mock.dao;

import com.yezi.aac.repository.Data;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "data")
public class MockData implements Data {

    @PrimaryKey
    @NonNull
    public String mText;

    public MockData(String text) {
        mText = text;
    }

    @Override
    public List<Content> getContent() {
        return Collections.singletonList(new TextContent(mText));
    }

    public String getText() {
        return mText;
    }
}
