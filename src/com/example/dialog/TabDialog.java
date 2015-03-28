package com.example.dialog;

import java.util.ArrayList;

import com.example.dialogdemo2.R;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

public abstract class TabDialog extends MyDialog{
	
	//一共有多少分頁 這邊由工廠模式得到的陣列自行計算
	private int TAB_COUNT;
	
	private ViewPager mPager;
	
	private ViewPagerAdapter mViewPagerAdapter;
	
	//裝viewpager view的list
	private ArrayList<View> mPagerViews;
	
	//裝tab view的list
	private ArrayList<View> mTabViews;
	
	//tab的layout
	private LinearLayout groupTab;
	
	private int currentTabIndex;
	
	private Context mContext;
	
	public TabDialog(Context context) {
		super(context);
		mContext = context;
		setMainView(R.layout.tab_dialog);
		//從子類別那邊得到的view陣列
		mPagerViews = getMainViewList(mContext);
		TAB_COUNT = mPagerViews.size();
		
		DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
		int width = metrics.widthPixels / TAB_COUNT;
		
		groupTab = (LinearLayout) findViewById(R.id.group_tab_layout);
		mPager = (ViewPager) findViewById(R.id.pager);
		
		mTabViews = new ArrayList<View>();
		//設定為兩個頁面
		mPager.setOffscreenPageLimit(TAB_COUNT);
		
		mViewPagerAdapter = new ViewPagerAdapter(mContext);
		mPager.setAdapter(mViewPagerAdapter);
		
		//先將tab layout的view全部清空
		groupTab.removeAllViews();
		
		//把tab加進去
		for(int i = 0; i < TAB_COUNT; i++){
			//從子類別取得view
			View tabViews = createTabView(mContext, i);
			groupTab.addView(tabViews, width, LayoutParams.MATCH_PARENT);
			mTabViews.add(tabViews);
			//tab被按下切換
			tabViews.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					currentTabIndex = mTabViews.indexOf(v);
					v.setSelected(true);
					setTabStatus();
					setIndicator(currentTabIndex);
					mPager.setCurrentItem(currentTabIndex);
					//縮下鍵盤
					InputMethodManager imm = (InputMethodManager)mContext.getSystemService(
						      Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
				}
			});
			//如果目前的Tab被切換 則將tab view設為selected = true
			if(i == currentTabIndex){
				tabViews.setSelected(true);
			}
		}
		
		//當viewpager滑動的時候
		mPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				currentTabIndex = pos;
				setTabStatus();
				setIndicator(pos);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		setIndicator(0);
	}
	
	private void setIndicator(int pos){
		View indicator1 = mTabViews.get(0).findViewById(R.id.view1_indicator);
		View indicator2 = mTabViews.get(1).findViewById(R.id.view2_indicator);
		View indicator3 = mTabViews.get(2).findViewById(R.id.view3_indicator);
		
		indicator1.setVisibility(View.GONE);
		indicator2.setVisibility(View.GONE);
		indicator3.setVisibility(View.GONE);
		switch(pos){
		case 0:
			indicator1.setVisibility(View.VISIBLE);
			break;
		case 1:
			indicator2.setVisibility(View.VISIBLE);
			break;
		case 2:
			indicator3.setVisibility(View.VISIBLE);
			break;
		}
	}
	
	//改變tab
	private void setTabStatus(){
		
		if(groupTab == null){
			return;
		}
		for(int i = 0; i < TAB_COUNT; i++){
			View v = mTabViews.get(i);
			if(currentTabIndex == i){
				v.setSelected(true);
			}else{
				v.setSelected(false);
			}
		}
	}
	
	private class ViewPagerAdapter extends PagerAdapter{
		
		private Context c;
		
		public ViewPagerAdapter(Context context) {
			this.c = context;
		}
		
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) 	{	
			container.removeView((View) object);
		}

		@Override
	     public void notifyDataSetChanged() {         
	           super.notifyDataSetChanged();
	     }
	 
	     @Override
	     public int getItemPosition(Object object)   {          
	           return super.getItemPosition(object);
	     }
	     
	     public View getItem(int position){
	    	 return (View) mPagerViews.get(position);
	     }

		@Override
		public Object instantiateItem(ViewGroup container, int position) {	
			 View v = mPagerViews.get(position);
			 if(v.getParent() != null){
				 ViewGroup vg = (ViewGroup)v.getParent();
				 vg.removeView(v);
			 }
			 ((ViewPager) container).addView(v, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			 
			 return v;
		}

		@Override
		public int getCount() {			
			return mPagerViews.size();
		}
		

		@Override
		public boolean isViewFromObject(View v, Object o) {
			return v == o;
		}
	}
	
	//由子類別完成 tab的內容物
	public abstract ArrayList<View> getMainViewList(Context context);
	//由子類別完成 tab view內的畫面
	public abstract View createTabView(Context context, int index);
}
