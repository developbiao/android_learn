package com.eoe.otherapp;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    
    public void click(View view){
    	//得到手机的中间人
    	/*
    	ContentResolver resolver = getContentResolver();
    	Uri uri = Uri.parse("content://com.ab.db.personprovider/query");
    	Cursor cursor = resolver.query(uri, null, null, null, null);
    	while(cursor.moveToNext()){
    	String nameString =	cursor.getString(cursor.getColumnIndex("name"));
    	//String idString= cursor.getString(cursor.getColumnIndex("personid"));
    	System.out.println("name=" + nameString );
    	}
    	*/
    }


  
}
