package com.example.activity;

import com.example.dialogdemo2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MySimpleActivity extends Activity {

	private Button mNextDialog;
	
	private View back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity2);
		mNextDialog = (Button) findViewById(R.id.simple_button);
		mNextDialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClass(MySimpleActivity.this, MySimpleActivity.class);
				startActivity(i);
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


}
