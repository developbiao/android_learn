package com.ab.activitytest;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       System.out.println("OnCreate");

      
    }
    
    public boolean onCreateOptionMenu(Menu menu){
    	getMenuInflater().inflate(R.menu.main, menu);
    	return true;
    }
    
    public void onStart(){
    	super.onStart();
    	System.out.println("onStart");
    }
    
    public void onResume(){
    	super.onResume();
    	System.out.println("onResume");
    }
    protected void onPause(){
    	super.onPause();
    	System.out.println("OnPause");
    }
    
    protected void onStop(){
    	super.onStop();
    	System.out.println("OnStop");
    }
    

   
    protected void onDestroy(){
    	super.onDestroy();
    	System.out.println("onDestroy");
    }
    




}
