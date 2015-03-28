package com.example.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.MyAdapter;
import com.example.dialogdemo2.R;


public class GoogleFragment extends Fragment {

	private String value = "";

	private ListView mListView;
	private MyAdapter mMyAdapter;
	
	private Context mContext;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d("=====>", "GoogleFragment onAttach");
		
		FragmentTabActivity mainActivity = (FragmentTabActivity)activity;
		value = mainActivity.getGoogleData();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("=====>", "GoogleFragment onCreateView");
		mContext = getActivity().getApplicationContext();
		View v = inflater.inflate(R.layout.frg_google, container, false);
		mListView = (ListView) v.findViewById(R.id.dialog_tab2_list);
        mMyAdapter = new MyAdapter(mContext);
        mListView.setAdapter(mMyAdapter);
        
        return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("=====>", "GoogleFragment onActivityCreated");
		
	}
	
}
