package com.ab.insertacontact;

import java.security.PublicKey;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
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
       

    }
    
    public void Click(View view){
    	//1、向raw_contact表里面添加联系人的id
    	ContentResolver resolover = getContentResolver();
    	//获取raw_contact表对应的uri
    	Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
    	Uri dataUri = Uri.parse("content://com.android.contacts/data");
    	ContentValues values = new ContentValues();
    	//必须知道最后一条联系人的id 是多少
    	Cursor cursor = resolover.query(uri, new String[]{"_id"}, null, null, null);
    	cursor.moveToLast();
    	int lastId = cursor.getInt(0);
    	int newId = lastId + 1;
    	values.put("contact_id", newId);
    	resolover.insert(uri, values);
    	
    	//2、使用添加联系人的id 向data表里面添加数据
    	ContentValues phoneValues = new ContentValues();
    	phoneValues.put("data1", "15616214867");
    	phoneValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
    	phoneValues.put("raw_contact_id", newId);
    	resolover.insert(dataUri, phoneValues);
    	
    	//3、插入email信息
    	ContentValues emailValues = new ContentValues();
    	emailValues.put("data1", "developbiao@gmail.com");
    	emailValues.put("mimetype", "vnd.android.cursor.item/email_v2");
    	emailValues.put("raw_contact_id", newId);
    	resolover.insert(dataUri, emailValues);
    	
    	//4、插入联系人姓名
    	ContentValues nameValues = new ContentValues();
    	nameValues.put("data1", "gongbiao");
    	nameValues.put("mimetype", "vnd.android.cursor.item/name");
    	nameValues.put("raw_contact_id", newId);
    	resolover.insert(dataUri, nameValues);
    	
    	//提示添加成功
    	Toast.makeText(getApplicationContext(), "添加成功", 0).show();
    }
	

}
