package com.example.dialog;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.NoticeCenter;
import com.example.dialogdemo2.R;

public class TabView1 extends MainTabView{

	private EditText mEdit;
	
	private Button mButton;
	
	private Context mContext;
	
	public TabView1(Context context) {
		super(context);
		mContext = context;
		View v = LayoutInflater.from(context).inflate(R.layout.tab_context1, null, false);
		
		mEdit = (EditText) v.findViewById(R.id.edit_text);
		mButton = (Button) v.findViewById(R.id.teb1_button);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				String content = mEdit.getText().toString();
				//出師表傳送門
				String content = getAssetsFile();
				NoticeCenter.notifyDataChanged(content);
			}
		});
		this.addView(v, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	}
	public String getAssetsFile(){
    	// file to inputstream
        InputStream input;
        String text;
		try {
			input = mContext.getAssets().open("file.txt");
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
