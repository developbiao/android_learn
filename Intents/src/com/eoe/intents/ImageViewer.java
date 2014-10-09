package com.eoe.intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewer extends Activity {
	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自定义图片打开器
		super.onCreate(savedInstanceState);
		iv = new ImageView(this);
		setContentView(iv);
		iv.setImageURI(getIntent().getData());
		
	}
	
	

}
