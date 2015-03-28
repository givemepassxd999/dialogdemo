package com.example.activity;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TabHost.TabSpec;

import com.example.dialogdemo2.R;

public class TabHostDemoActivity extends TabActivity {
	private View back;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tab_main_activity);
         
        addNewTab(this,Tab.class,"TabOne");
        addNewTab(this,TabTwo.class,"TabTwo");
        addNewTab(this,TabThree.class,"TabThree");
        
        getTabHost().setCurrentTab(0);
        getTabHost().requestFocus();
        back = (View) findViewById(R.id.navi_back);
        back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
    }
    public void addNewTab(Context context, Class<?> cls, String tabName){
        Resources res = getResources();
        Intent intent = new Intent().setClass(this, cls);
        TabSpec spec = getTabHost().newTabSpec(tabName)
                .setIndicator(tabName,res.getDrawable(R.drawable.ic_launcher))
                .setContent(intent);
        getTabHost().addTab(spec);
    }
}