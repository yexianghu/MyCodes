package com.yezi.aac;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ACC_MainActivity";

    private RecyclerView mRecyclerView;

    private ListAdapter mAdapter = new ListAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.list);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        ListViewModel module = ViewModelProviders.of(this).get(ListViewModel.class);

        module.getListData(this).observe(this, datas -> {
            Log.d(TAG, "observe callback");
            mAdapter.setDatas(datas);
        });
    }
}
