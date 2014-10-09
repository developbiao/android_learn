package com.ab.observer;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://sms/");
        
        resolver.registerContentObserver(uri, true, new Myobserver(new Handler()));
        
    }
    
    private class Myobserver extends ContentObserver{

		public Myobserver(Handler handler) {
			super(handler);
			
		}

		@Override
		public void onChange(boolean selfChange) {
			super.onChange(selfChange);
			Toast.makeText(MainActivity.this, "数据库的内容发生变化了", 1).show();
			Uri uri = Uri.parse("content://sms/");
			ContentResolver resolver = getContentResolver();
			Cursor cursor = resolver.query(uri, new String[]{"address", "date", "type", "body"}, null , null, null );
			cursor.moveToFirst();
			String address = cursor.getString(0);
			String body = cursor.getString(3);
			System.out.println(address + "-----" + body);
		}
		
		
    	
    }


}
