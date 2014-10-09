package com.eoe.readcontact;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private TextView show;
	private final String Contact = "Contact";
	int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.show);
        show.setTextColor(190);
        show.setTextSize(18);
       Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
       while(c.moveToNext()){
    	   Log.i(Contact, ">>>" + c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
    	   count ++;
    	   
    	  show.setText("正在扫描联系人....已扫描到:" + count  +"个");
    	   
       }
       Toast.makeText(this, "你总共有" + count + "个联系人 ", Toast.LENGTH_LONG).show();
      
    }


   

}
