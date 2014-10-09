package com.eoe.sms;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	private Button readButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readButton = (Button) findViewById(R.id.ReadSMS);
        readButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//content://sms
				Uri uri = Uri.parse("content://sms/");
				ContentResolver resolver =getContentResolver();
				Cursor cursor = resolver.query(uri,new String[]{"address, date, type, body"},null, null, null);
				while(cursor.moveToNext()){
					String address = cursor.getString(0);
					String date = cursor.getString(1);
					String type = cursor.getString(2);
					String body = cursor.getString(3);
					System.out.println("address:" + address);
					System.out.println("date:" + date);
					System.out.println("type:" + type);
					System.out.println("body:" + body);
					System.out.println("------------------------");
				}
			}
		});
      

       
    }



}
