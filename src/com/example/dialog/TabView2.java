package com.example.dialog;

import com.example.MyAdapter;
import com.example.dialogdemo2.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

public class TabView2 extends MainTabView{

	private ListView mListView;
	private MyAdapter mMyAdapter;
	
	public TabView2(Context context) {
		super(context);
		View v = LayoutInflater.from(context).inflate(R.layout.tab_context2, null, false);
		this.addView(v, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		mListView = (ListView) findViewById(R.id.dialog_tab2_list);
        mMyAdapter = new MyAdapter(context);
        mListView.setAdapter(mMyAdapter);
	}

}
