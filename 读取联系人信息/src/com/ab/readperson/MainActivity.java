package com.ab.readperson;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	private Button btnRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRead = (Button) findViewById(R.id.readContent);
        btnRead.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//1、查询raw_contact表获取联系人的id
				ContentResolver resolver = getContentResolver();
				//获取raw_contact表对应的uri
				Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
				Uri dataUri = Uri.parse("content://com.android.contacts/data");
				
				Cursor cursor = resolver.query(uri, null, null, null, null);
				while(cursor.moveToNext()){
					String id = cursor.getString(cursor.getColumnIndex("contact_id"));
					if(id != null){
					System.out.println("id--->>"+id);
					Cursor dataCursor = resolver.query(dataUri, null, "raw_contact_id=?", new String[]{id}, null);	
					while(dataCursor.moveToNext()){
						String data1 = dataCursor.getString(dataCursor.getColumnIndex("data1"));
						String mimetype = dataCursor.getString(dataCursor.getColumnIndex("mimetype"));
						System.out.println("data1=" + data1);
						System.out.println("mimetype=" + mimetype);
					}
					dataCursor.close();
					System.out.println("-----------------");
					}
				}
				cursor.close();
			}
		});

       
    }
   

}
