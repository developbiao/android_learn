package com.ab.db;

import com.ab.service.DBOpenHelper;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonDBProvider extends ContentProvider{
	//定义一个uri的匹配器用于匹配uri 如果路径不满足条件反回-1
	private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int INSERT = 1;
	private static final int DELETE = 2;
	private static final int UPDATE = 3;
	private static final int QUERY = 4;
	private DBOpenHelper helper;
	static{
		//添加一组匹配规则
		matcher.addURI("com.ab.db.personprovider", "insert", INSERT);
		matcher.addURI("com.ab.db.personprovider", "delete", DELETE);
		matcher.addURI("com.ab.db.personprovider", "update", UPDATE);
		matcher.addURI("com.ab.db.personprovider", "query", QUERY);
	}
	@Override
	public boolean onCreate() {
		helper = new DBOpenHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
			if(matcher.match(uri)==QUERY){
				//返回查询的结果
				SQLiteDatabase db= helper.getReadableDatabase();
				Cursor cursor = db.query("person", projection, selection, selectionArgs, null, null, sortOrder);
				return cursor;
			}else{
				throw new IllegalArgumentException("路径不匹配，不能执行查询");
			}
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		if(matcher.match(uri) == INSERT){
			SQLiteDatabase db= helper.getWritableDatabase();
			db.insert("person", null, values);
			
		}else{
			throw new IllegalArgumentException("路径小匹配，不能执行删除操作");
		}
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		if(matcher.match(uri)==DELETE){
			SQLiteDatabase db = helper.getWritableDatabase();
			db.delete("person", selection, selectionArgs);
		}else{
			throw new IllegalArgumentException("路径不匹配，不能执行删除操作");
		}
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
			if(matcher.match(uri)==DELETE){
				SQLiteDatabase db = helper.getWritableDatabase();
				db.update("person", values, selection, selectionArgs);
			}else{
				throw new IllegalArgumentException("路径不匹配，不能执行更新操作");
			}
			return 0;
	}

}
