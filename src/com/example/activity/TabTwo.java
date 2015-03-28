package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.MyAdapter;
import com.example.dialogdemo2.R;

public class TabTwo extends Activity {
	private ListView mListView;
	private MyAdapter mMyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);
        mListView = (ListView) findViewById(R.id.list);
        mMyAdapter = new MyAdapter(getApplicationContext());
        mListView.setAdapter(mMyAdapter);
    }
    
}
