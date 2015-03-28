package com.example;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.activity.MySimpleActivity;
import com.example.activity.TabHostDemoActivity;
import com.example.dialog.MySimpleDialog;
import com.example.dialog.MySimpleDialog.OnOpenNewDialogListener;
import com.example.dialog.MyTabDialog;
import com.example.dialogdemo2.R;
import com.example.fragment.FragmentTabActivity;
import com.example.fragment.MyFragmentActivity;

public class MainActivity extends Activity {

	private Button showTabDialog, showDialog;
    
	private Context mContext;
	
	private Button showActivity, showTabActivity;
	
	private Button showFragment, showTabFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        showTabDialog = (Button) findViewById(R.id.show_tab_dialog);
        showTabDialog.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                new MyTabDialog(mContext).show();
            }
        });
        
        showDialog = (Button) findViewById(R.id.show_dialog);
        showDialog.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	final MySimpleDialog mMySimpleDialog = new MySimpleDialog(mContext);
				mMySimpleDialog.setOnOpenNewDialogListener(new OnOpenNewDialogListener() {
					
					@Override
					public void OnOpenNewDialog() {
						
					}
				});
				mMySimpleDialog.show(); 
            }
        });
        
        showActivity = (Button) findViewById(R.id.show_new_activity);
        showActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				Bundle b = new Bundle();
				String text = getAssetsFile();
				b.putString("file", text);
				//出師表傳送門
//				i.putExtras(b);
				i.setClass(MainActivity.this, MySimpleActivity.class);
				startActivity(i);
			}
		});
        
        showTabActivity = (Button) findViewById(R.id.show_tab_activity);
        showTabActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				Bundle b = new Bundle();
				String text = getAssetsFile();
				b.putString("file", text);
				//出師表傳送門
//				i.putExtras(b);
				i.setClass(MainActivity.this, TabHostDemoActivity.class);
				startActivity(i);
			}
		});
        
        showTabFragment = (Button) findViewById(R.id.show_tab_fragment);
        showTabFragment.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	Intent i = new Intent();
				i.setClass(MainActivity.this, FragmentTabActivity.class);
				startActivity(i);
            }
        });
        
        showFragment = (Button) findViewById(R.id.show_fragment);
        showFragment.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	Intent i = new Intent();
				i.setClass(MainActivity.this, MyFragmentActivity.class);
				startActivity(i);
            }
        });
    } 
    
    public String getAssetsFile(){
    	// file to inputstream
        InputStream input;
        String text;
		try {
			input = getAssets().open("file.txt");
			// myData.txt can't be more than 2 gigs.
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
 
            // byte buffer into a string
            text = new String(buffer);
//			Log.e("aaa", text);
            return text;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
    }
}
