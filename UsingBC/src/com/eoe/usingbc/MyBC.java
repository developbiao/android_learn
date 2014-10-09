package com.eoe.usingbc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBC extends BroadcastReceiver {

	public static final String ACTION = "com.eoe.usingbc.intent.action.MYBC";  //ACTION格式
	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("OnReceive.....");
		//接收到数据
		Toast.makeText(context, "OnReceive,data value:" + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
	}

}
