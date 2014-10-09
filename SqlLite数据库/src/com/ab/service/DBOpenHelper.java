package com.ab.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

	public DBOpenHelper(Context context){
		super(context, "sqlite.db", null ,3); //<包>/databases/
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE person(personid integer primary key autoincrement,"
				+ "name varchar(20), phone VARCHAR(12) NULL)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE person ADD amount integer");
		
	}
	
	

}
