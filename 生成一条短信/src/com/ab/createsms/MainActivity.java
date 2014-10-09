package com.ab.createsms;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       
        new Thread(){
        	public void run(){
        		try{
        		Thread.sleep(2000);
        		ContentResolver resolver = getContentResolver();
        		 Uri uri = Uri.parse("content://sms/");
        	       ContentValues values = new ContentValues();
        	       values.put("address", "18783528562");
        	       values.put("type", 1);
        	       values.put("date", System.currentTimeMillis());
        	       values.put("body", "龚彪,I Love You!");
        	       resolver.insert(uri, values);
        		}catch(InterruptedException e){
        			e.printStackTrace();
        		}
        	}
        }.start();

       
    }


 

}
