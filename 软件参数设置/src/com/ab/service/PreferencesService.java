package com.ab.service;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferencesService {
	
	private Context context;
	
	
	public PreferencesService(Context context) {
		this.context = context;
	}

	/*
	 * 保存参数
	 */
	public void Save(String name, Integer age){
		
		SharedPreferences preferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString("name", name);
		editor.putInt("age", age);
		editor.commit();  //提交
		
	}
	
	/**
	 * 获取xml中的各项参数
	 * 回显用的方法 
	 * @return
	 */
	public Map<String, String> getPreferences(){
		Map<String, String> params = new HashMap<String, String>();
		SharedPreferences preferences =context.getSharedPreferences("share", Context.MODE_PRIVATE);
		params.put("name", preferences.getString("name", ""));
		params.put("age", String.valueOf(preferences.getInt("age", 0)));
		
		return params;
		
	}
	
	
	

}
