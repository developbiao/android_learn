package com.ab.db;

import com.ab.service.DBOpenHelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonProvider extends ContentProvider{
	private DBOpenHelper dbOpenHelper;
	private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int PERSONS = 1;
	private static final int PERSON = 2;
	static{
		MATCHER.addURI("com.ab.db.providers.personprovider", "person", PERSONS);
		MATCHER.addURI("com.ab.db.providers.personprovider", "person/#", PERSON);
	}

	@Override
	public boolean onCreate() {
		dbOpenHelper = new DBOpenHelper(this.getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		switch (MATCHER.match(uri)) {
		case PERSONS:
			return db.query("person", projection, selection, selectionArgs, null, null, sortOrder);

		default:
			throw new IllegalArgumentException("this is Unknown Uri:" + uri);
		}
	}

	@Override
	public String getType(Uri uri) {
		
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		switch (MATCHER.match(uri)) {
		case PERSONS:
			long rowid = db.insert("person", "name", values);
			Uri insertUri = ContentUris.withAppendedId(uri, rowid);
			this.getContext().getContentResolver().notifyChange(uri, null);
			return insertUri;

		default:
			throw new IllegalArgumentException("this is Unknown Uri:" + uri);
		}
	
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		int num = 0;
		switch (MATCHER.match(uri)) {
		case PERSONS:
		num = db.delete("person", selection, selectionArgs);
			break;
		case PERSON:
			long rowid = ContentUris.parseId(uri);
			String whereString = "personid=" + rowid;
			if(selection != null && !"".equals(selection.trim())){
				whereString += "and" + selection;
			}
			num = db.delete("person", whereString, selectionArgs);

		default:
			throw new IllegalArgumentException("this is Unknown Uri:" + uri);
		}
		return num;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		int num = 0;
		switch (MATCHER.match(uri)) {
		case PERSONS:
			num = db.update("person", values, selection, selectionArgs);
			break;
		case PERSON:
			long rowid = ContentUris.parseId(uri);
			String whereString = "personid=" + rowid;
			if(selection != null && !"".equals(selection.trim())){
				whereString += " and " + selection;
			}
			num = db.update("person", values, whereString, selectionArgs);
			break;

		default:
			throw new IllegalArgumentException("this is Unknown Uri" + uri);
		}
		return num;
	}
	

}
