package com.example.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dialogdemo2.R;


public class AppleFragment extends Fragment {
	
	private String value = "";

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d("=====>", "AppleFragment onAttach");
		FragmentTabActivity mainActivity = (FragmentTabActivity)activity;
		value = mainActivity.getAppleData();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("=====>", "AppleFragment onCreateView");
		return inflater.inflate(R.layout.frg_apple, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("=====>", "AppleFragment onActivityCreated");
		TextView txtResult = (TextView) this.getView().findViewById(R.id.textView1);
		txtResult.setText(value);
	}
	
}
