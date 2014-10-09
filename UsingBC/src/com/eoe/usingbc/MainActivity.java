package com.eoe.usingbc;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	private Button btnSendBroadcast;
	private Button btnRegBCR;
	private Button btnUnRegBCR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);
        btnRegBCR = (Button) findViewById(R.id.btnRegBCR);
        btnUnRegBCR = (Button) findViewById(R.id.btnUnRegBCR);
        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent i = new Intent(MainActivity.this, MyBC.class);
				Intent i = new Intent(MyBC.ACTION);
				i.putExtra("msg", "Hello BroadCast");
				sendBroadcast(i);  //发送广播
			}
		});
        final MyBC mybc = new MyBC();
        //动态注册BroadCastReveiver
        btnRegBCR.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				registerReceiver(mybc, new IntentFilter(MyBC.ACTION));
			}
		});
        
        
        //动态注消BroadCastReceiver
        btnUnRegBCR.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				unregisterReceiver(mybc);
				//unregister Receiver
			}
		});
     
       
    }


 
 
}
