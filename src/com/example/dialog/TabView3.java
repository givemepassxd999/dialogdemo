package com.example.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.NoticeCenter;
import com.example.NoticeCenter.OnDataChangedListener;
import com.example.dialogdemo2.R;

public class TabView3 extends MainTabView{

	private TextView textView;
	
	public TabView3(Context context) {
		super(context);
		View v = LayoutInflater.from(context).inflate(R.layout.tab_context3, null, false);
		textView = (TextView) v.findViewById(R.id.text);
		NoticeCenter.addOnDataChangedListener(new OnDataChangedListener() {
			
			@Override
			public void OnDataChanged(String content) {
				textView.setText(content);
			}
		});
		
		this.addView(v, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	}

}
