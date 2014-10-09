/**
 * @Describe:数据库操作对象
 */
package com.ab.service;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ab.doman.Person;

public class PersonService {
	private DBOpenHelper dbOpenHelper;
	public PersonService(Context context){
		this.dbOpenHelper= new DBOpenHelper(context);
	}
	public void payment(){
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		db.beginTransaction();//开启事务
		try{
			db.execSQL("update person set amount=amount-10 where personid=2");
			db.execSQL("update person set amount=amount+10 where personid=3");
			db.setTransactionSuccessful(); //结束事务，有两种情况：commit, rollback
		//否则回滚，默认情况下事务的标志为False;
		}finally{
			db.endTransaction(); //结束事务
		}
	}
	/*
	 * 添加记录
	 * @param person
	 */
	public void save(Person person){
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		db.execSQL("insert into person(name, phone, amount) values(?,?,?)",
				new Object[]{person.getName(), person.getPhone(), person.getAmount()});
	}
	/**
	 * 更新记录
	 * @param person
	 */
	public void update(Person person){
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		db.execSQL("update person set name=?,phone=?,amount=? where personid=?",
				new Object[]{person.getName(), person.getPhone(), person.getAmount(), person.getId()});
	}
	/***
	 * 跟据ID查询
	 * @param id
	 * @return
	 */
	public Person find(Integer id){
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from person where personid=?", new String[]{id.toString()});
		if(cursor.moveToFirst()){
			int personid = cursor.getInt(cursor.getColumnIndex("personid"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String phone = cursor.getString(cursor.getColumnIndex("phone"));
			int amount = cursor.getInt(cursor.getColumnIndex("amount"));
			return new Person(personid, name, phone, amount);
		}
		
		return null;
	}
	
	/**
	 * 获取分页数据
	 * @param offset
	 * @param maxResult
	 * @return
	 */
	public List<Person> getScrollData(int offset, int maxResult){
		List<Person> persons = new ArrayList<Person>();
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from person order by personid asc limit ?,?",
				new String[]{String.valueOf(offset), String.valueOf(maxResult)});
		
		while(cursor.moveToNext()){
			int personid = cursor.getInt(cursor.getColumnIndex("personid"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String phone = cursor.getString(cursor.getColumnIndex("phone"));
			int amount = cursor.getInt(cursor.getColumnIndex("amount"));
			persons.add(new Person(personid, name, phone, amount));
		}
		cursor.close();
		return persons;
		
	}
	
	/**
	 * 删除记录
	 * @param id
	 */
	public void delete(Integer id){
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
		db.execSQL("delete from person where personid=?", new Object[]{id});
	}
	
	
	
	/**
	 * 获取记录总数
	 * @return
	 */
	public long getCount(){
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from person", null);
		cursor.moveToFirst();
		long result = cursor.getLong(0);
		return result;
	}
	/**
	 * cursor获取分页数据
	 * @param offset
	 * @param maxResult
	 * @return
	 */
	public Cursor getCursorScrollData(int offset, int maxResult){
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select personid as _id,name,phone,amount from person order by personid asc limit ?,?",
				new String[]{String.valueOf(offset), String.valueOf(maxResult)});
		return cursor;
	}
	
	
	
	
}
