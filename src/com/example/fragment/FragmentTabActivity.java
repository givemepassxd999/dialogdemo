package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.view.Window;
import android.widget.TabHost.OnTabChangeListener;

import com.example.dialogdemo2.R;

public class FragmentTabActivity extends FragmentActivity {

	private View back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
	
		FragmentTabHost tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		//1
		tabHost.addTab(tabHost.newTabSpec("Apple")
			   				  .setIndicator("Apple"), 
   					  AppleFragment.class, 
   					  null);
	    //2
		tabHost.addTab(tabHost.newTabSpec("Google")
				   			  .setIndicator("Google"), 
					  GoogleFragment.class, 
					  null);
	    //3
		tabHost.addTab(tabHost.newTabSpec("Facebook")
				   			  .setIndicator("Facebook"), 
					  FacebookFragment.class, 
				      null);
		
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				
			}
		});
		
		back = (View) findViewById(R.id.navi_back);
        back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}

	/**************************
	 * 
	 * 		���l���ҩI�s��
	 * 
	 **************************/
	
	public String getAppleData(){
		return "Apple 123";
	}

	public String getGoogleData(){
		return "Google 456";
	}
	
	public String getFacebookData(){
		return "Facebook 789";
	}
	
	public String getTwitterData(){
		return "Twitter abc";
	}
}
