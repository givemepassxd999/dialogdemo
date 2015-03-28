package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.dialogdemo2.R;

public class MyFragmentActivity extends FragmentActivity {
	private Button backBtn,nextBtn;
	private int page = 1;
	private View back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_fragment_activity);
		backBtn = (Button)findViewById(R.id.back_button);
		nextBtn = (Button)findViewById(R.id.next_button);
		changeFragment(DetailsFragment.newInstance(page));
		backBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(page>1){
					changeFragment(DetailsFragment.newInstance(--page));
				}
				else{
					changeFragment(DetailsFragment.newInstance(page));
				}
			}
			
		});
		nextBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				changeFragment(DetailsFragment.newInstance(++page));
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
	
	private void changeFragment(Fragment f) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_container, f);
		transaction.commitAllowingStateLoss();
	}
}
