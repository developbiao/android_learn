package com.eoe.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener, ServiceConnection{
	
	private Button btnStartService, btnStopService, btnBindService, btnUnBindService, btnGetCurrentNum;
	private Intent serviceIntent;
	private EchoService echoService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent(this, EchoService.class);
        
        btnStartService = (Button) findViewById(R.id.btn_StartService);
        btnStopService = (Button) findViewById(R.id.btn_StopService);
        
        btnBindService = (Button) findViewById(R.id.btnBindService);
        btnUnBindService = (Button) findViewById(R.id.btnUnBindService);
        
        btnGetCurrentNum = (Button) findViewById(R.id.btnGetCurrent);
        
        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
        btnUnBindService.setOnClickListener(this);
        btnGetCurrentNum.setOnClickListener(this);
        

       
    }

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.btn_StartService:
			startService(serviceIntent);
			break;
		case R.id.btn_StopService:
			stopService(serviceIntent);
			break;
		case R.id.btnBindService:
			bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
			break;
		case R.id.btnUnBindService:
			unbindService(this);
			echoService = null;
			break;
		case R.id.btnGetCurrent:
			if(echoService != null){
				System.out.println("当前服务中的数字是:" + echoService.getCurrentNum());
			}
			break;
		
		}
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		System.out.println("onServiceConnected...");   //服务创建
		
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		
		  //服务出现异常的时候 Touch的事件
	}
   
}
