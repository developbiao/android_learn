package com.eoe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private Button btnStartAty1;
	private TextView tvOut;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvOut = (TextView) findViewById(R.id.tvOut);
       btnStartAty1 = (Button) findViewById(R.id.btnStartAty1);
       btnStartAty1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = new Intent(MainActivity.this, Aty1.class );
			//i.putExtra("txt", "Hello Aty1 你好！");  //第一种方法传递
			Bundle data = new Bundle();
			data.putString("msg", "来至MainActivity的问候！");  //第二种方法传递
			i.putExtras(data);
		
			//startActivity(i);
			startActivityForResult(i, 0);  //回传回来这个时候就要用到startActivity();
			
		}
	});

    }
    
   protected void onActivityResult(int requesCode, int resultCode, Intent data){
	   super.onActivityResult(requesCode, resultCode, data);
	   String result = data.getStringExtra("result");
	   tvOut.setText(result);
   }


}
