/*
 * @Describe:简单的拨号键盘
 * @Author:GongBiao
 * @Date:2014/09/15
 */
package com.ab.callphone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	private Button bt_cail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        bt_cail = (Button) findViewById(R.id.bt_dail);
        bt_cail.setOnClickListener(new MyListener());
    }
    
    private class MyListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			
			EditText et_number =(EditText) MainActivity.this.findViewById(R.id.et_number);
			String number = et_number.getText().toString();
			//意图想干一件什么事情
			Intent intent = new Intent();//Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);   //intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:"+number));	//intent.setData(Uri.parse("tel:"+number))
			startActivity(intent);
		}
    	
    	
    }

}
