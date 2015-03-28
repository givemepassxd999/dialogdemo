package com.example;

import java.util.ArrayList;

public class NoticeCenter {
	
	private static ArrayList<OnDataChangedListener> mOnDataChangedListenerList = new ArrayList<OnDataChangedListener>(); ;
	
	public static void addOnDataChangedListener(OnDataChangedListener listener){
		mOnDataChangedListenerList.add(listener);
	}
	
	public static void removeOnDataChangedListener(OnDataChangedListener listener){
		mOnDataChangedListenerList.remove(listener);
	}
	
	public interface OnDataChangedListener{
		public void OnDataChanged(String content);
	}
	
	public static void removeAllOnDataChangedListener(){
		for(OnDataChangedListener l : mOnDataChangedListenerList){
			if(l != null){
				mOnDataChangedListenerList.remove(l);
			}
		}
	}
	
	public static void notifyDataChanged(String s){
		for(OnDataChangedListener listener : mOnDataChangedListenerList){
			if(listener != null){
				listener.OnDataChanged(s);
			}
		}
	}
}
