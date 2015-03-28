package com.example.dialog;

import java.util.ArrayList;

import com.example.NoticeCenter;
import com.example.dialogdemo2.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MyTabDialog extends TabDialog{

	public MyTabDialog(Context context) {
		super(context);
	}

	@Override
	public ArrayList<View> getMainViewList(Context context) {
		TabView1 mTabView1 = new TabView1(context);

		TabView2 mTabView2 = new TabView2(context);
		TabView3 mTabView3 = new TabView3(context);
		ArrayList<View> mainViewList = new ArrayList<View>();
		//要按照順序加入
		mainViewList.add(mTabView1);
		mainViewList.add(mTabView2);
		mainViewList.add(mTabView3);
		return mainViewList;
	}

	@Override
	public View createTabView(Context context, int index) {
		View v = null;
		switch(index){
		case 0: //建立團體文字跟icon
			v = LayoutInflater.from(context).inflate(R.layout.tab_view1, null, false);
			TextView tab1 = (TextView) v.findViewById(R.id.tab_text);
			tab1.setText("tab1");
			break;
		case 1: //團體邀請文字跟icon
			v = LayoutInflater.from(context).inflate(R.layout.tab_view2, null, false);
			TextView tab2 = (TextView) v.findViewById(R.id.tab_text);
			tab2.setText("tab2");
			break;
		case 2: //團體邀請文字跟icon
			v = LayoutInflater.from(context).inflate(R.layout.tab_view3, null, false);
			TextView tab3 = (TextView) v.findViewById(R.id.tab_text);
			tab3.setText("tab3");
			break;
		}
		return v;
	}

	@Override 
	public void dismiss() {
		NoticeCenter.removeAllOnDataChangedListener();
		super.dismiss();
	}

}
