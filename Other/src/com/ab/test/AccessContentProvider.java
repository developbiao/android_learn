package com.ab.test;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.util.Log;

public class AccessContentProvider extends AndroidTestCase{
	
	private static final String TAG = "AccessContentProviderTest";
	
	public void testInsert() throws Exception{
		Uri uri = Uri.parse("content://com.ab.db.providers.personprovider/person");
		ContentResolver resolver = this.getContext().getContentResolver();
		ContentValues values = new ContentValues();
		values.put("name", "laoniu");
		values.put("phone", "17888323232");
		values.put("amount", "80000000");
		resolver.insert(uri, values);
	}
	
	public void testQuery() throws Exception{
		Uri uri = Uri.parse("content://com.ab.db.providers.personprovider/person");
		ContentResolver resolver = this.getContext().getContentResolver();
		Cursor cursor = resolver.query(uri, null, null, null, "personid asc");
		while(cursor.moveToNext()){
			String nameString = cursor.getString(cursor.getColumnIndex("name"));
			Log.i(TAG, nameString);
		}
		cursor.close();
	}
}
