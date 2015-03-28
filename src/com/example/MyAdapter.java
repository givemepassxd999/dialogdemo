package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dialogdemo2.R;

public class MyAdapter extends BaseAdapter{
	
	private Context mContext;
	
	public MyAdapter(Context context){
		mContext = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		Holder holder;
		if(null == v){
			v = LayoutInflater.from(mContext).inflate(R.layout.adapter_item, null);
			holder = new Holder();
			
			holder.text = (TextView) v.findViewById(R.id.adapter_item_text);
			
			v.setTag(holder);
		} else{
			holder = (Holder) v.getTag();
		}
		holder.text.setText(position + "");
		return v;
	}
	
	class Holder{
		TextView text;
	}

}
