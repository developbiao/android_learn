package com.eoe.intents;


import java.io.File;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btnStartAty1).setOnClickListener(new
        		View.OnClickListener() {
					
					@Override
					/**
					 * 显示的初始化Intent
					 */
					public void onClick(View v) {
//						Intent i = new Intent();
//						i.setComponent(new ComponentName("com.eoe.intents", "com.eoe.intents.action.Aty1"));
						Intent i = new Intent("com.eoe.intents.action.Aty1");
						startActivity(i);
			
					}
				});
        
        findViewById(R.id.btnOpenImage).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 图片的显示
				File f = new File("mnt/sdcard/haha.jpeg");
				Toast.makeText(getApplicationContext(), Environment.getExternalStorageState().toString() + "/haha.jpeg", 1).show();
				Intent i = new Intent (Intent.ACTION_VIEW);
				i.setDataAndType(Uri.fromFile(f), "image/*");
				startActivity(i);
				
			}
		});
        
        findViewById(R.id.btnDel10086).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 打电话给10086
				
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse("tel:10010"));
				startActivity(i);
			}
		});
        
        findViewById(R.id.btnNavTowenlu).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 打开一个网站 
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://wen.lu"));
				startActivity(i);
				
				
			}
		});
    }


}
