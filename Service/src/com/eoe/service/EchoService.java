package com.eoe.service;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class EchoService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
	
		System.out.println("onBind");
		
		return echoServiceBinder;
	}
	private final EchoServiceBinder echoServiceBinder = new EchoServiceBinder();
	public class EchoServiceBinder extends Binder{
		
		public EchoService getService(){
			return EchoService.this;
		}
		
	}
	
	public int getCurrentNum(){
		return i;
		
	}

	@Override
	public void onCreate() {

		System.out.println("OnCreate");
		startTimer();
		Toast.makeText(this, "服务开启...", 1).show();
		
	
	}

	@Override
	public void onDestroy() {
		
		super.onDestroy();
		stopTimer();
		System.out.println("OnDestory");
		Toast.makeText(this, "服务Destory...", 1).show();
	}
	
	private void stopTimer() {
		if(timer != null){
			task.cancel();
			timer.cancel();
			
			task = null;
			timer = null;
		}
		
	}
	private int i = 0;
	Timer timer = null;
	TimerTask task = null;
	public void startTimer(){
		if(timer==null){
			timer = new Timer();
			task = new TimerTask(){
				public void run(){
					i++;
					System.out.println(i);
				}
			};
			timer.schedule(task, 1000, 1000);
		}
	}
	
	

}
