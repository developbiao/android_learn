package com.ab.db;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.ab.service.PersonService;

public class MainActivity extends ActionBarActivity {
	private ListView listView;
	private PersonService personService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化personServie对象
        personService = new PersonService(this);
        
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new ItemClickListener());
        show2();
       
    }
    
    private final class ItemClickListener implements OnItemClickListener{
    	
    	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			ListView lView = (ListView)parent;
			/* 自定义适配器
			Person person = (Person) lView.getItemAtPosition(position);
			Toast.makeText(getApplicationContext(), person.getId().toString(), 1).show();*/
			
			Cursor cursor = (Cursor) lView.getItemAtPosition(position);
			int personid = cursor.getInt(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			Toast.makeText(getApplicationContext(), "小学妹:"+ name +personid+ "", 1).show();
		}
    	
    	
    	
    }
    
    private void show2() {
		Cursor cursor = personService.getCursorScrollData(0, 20);
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, cursor,
				new String[]{"name", "phone", "amount"}, new int[]{R.id.name, R.id.phone, R.id.amount});
		listView.setAdapter(adapter);
	}



}
