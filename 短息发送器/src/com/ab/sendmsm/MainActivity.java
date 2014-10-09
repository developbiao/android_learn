package com.ab.sendmsm;

import java.util.ArrayList;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private EditText numberText;
	private EditText contentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        numberText = (EditText) findViewById(R.id.number);
        contentText = (EditText) findViewById(R.id.content);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new ButtonClickListener() );
        
        
    }
    
    private final class ButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String number = numberText.getText().toString();
			String content = numberText.getText().toString();
			SmsManager manager = SmsManager.getDefault();
			ArrayList<String> texts = manager.divideMessage(content);
			for(String text : texts){
				manager.sendTextMessage(number, null, content, null, null);
				
			}
			
			Toast.makeText(MainActivity.this, R.string._scucceful,Toast.LENGTH_LONG).show();
			
		}
    	
    	
    	
    	
    }


}
