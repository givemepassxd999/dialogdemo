package com.example.dialog;

import com.example.dialogdemo2.R;

import android.content.Context;
import android.view.View;
import android.widget.Button;

public class MySimpleDialog extends MyDialog{

	private Button mNextDialog, mListenerBtn;
	
	private Context mContext;
	
	public interface OnOpenNewDialogListener{
		public void OnOpenNewDialog();
	}
	
	private OnOpenNewDialogListener mOnOpenNewDialogListener;
	
	public void setOnOpenNewDialogListener(OnOpenNewDialogListener listener){
		mOnOpenNewDialogListener = listener;
	}
	
	public MySimpleDialog(Context context) {
		super(context);
		mContext = context;
		setMainView(R.layout.simple_dialog);
		mNextDialog = (Button) findViewById(R.id.simple_button);
		mNextDialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final MySimpleDialog mMySimpleDialog = new MySimpleDialog(mContext);
				mMySimpleDialog.setOnOpenNewDialogListener(new OnOpenNewDialogListener() {
					
					@Override
					public void OnOpenNewDialog() {
						dismiss();
					}
				});
				mMySimpleDialog.show();
			}
		});
		
		mListenerBtn = (Button) findViewById(R.id.simple_listener_button);
		mListenerBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mOnOpenNewDialogListener != null){
					mOnOpenNewDialogListener.OnOpenNewDialog();
				}
			}
		});
	}


}
