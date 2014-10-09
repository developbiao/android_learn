package com.eoe.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Aty1 extends Activity {
	
	private TextView tvOut;
	private Button btnClose;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty1);
		
		btnClose = (Button) findViewById(R.id.btnClose);
		btnClose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.putExtra("result", "Hello MainActivity I'am Coming!");
				setResult(0, i);
				finish();  //关闭当前的Activity
				
			}
		});
	
		tvOut = (TextView) findViewById(R.id.tvOut);
		//tvOut.setText(getIntent().getStringExtra("txt"));
		Bundle data = getIntent().getExtras();
		tvOut.setText(data.getString("msg"));
	}
	
	 

}
