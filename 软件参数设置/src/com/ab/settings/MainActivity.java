package com.ab.settings;

import java.util.Map;

import com.ab.service.PreferencesService;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private EditText nameText;
	private EditText ageText;
	private PreferencesService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = (EditText) findViewById(R.id.name);
        ageText = (EditText) findViewById(R.id.age);
        service = new PreferencesService(this);
        //回显操作
        Map<String, String> params = service.getPreferences();
        nameText.setText(params.get("name"));
        ageText.setText(params.get("age"));
        
    }
    
    public void save(View v){
    	
    	String name= nameText.getText().toString();
    	String age= ageText.getText().toString();
    	service.Save(name, Integer.valueOf(age));
    	Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_LONG).show();
    	
    }

}
