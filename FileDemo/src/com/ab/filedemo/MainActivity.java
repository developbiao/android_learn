/*
 * @Desicribe:文件操作
 * @Student:GongBiao
 * @Date:2014/09/19
 */
package com.ab.filedemo;

import com.ab.service.FileService;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       Button button = (Button)findViewById(R.id.bt_save);
       Button bt_save_sd=(Button)findViewById(R.id.bt_savesd);
       button.setOnClickListener(new ButtonClickListener());
       bt_save_sd.setOnClickListener(new ButtonClickListener(){

		@Override
		public void onClick(View v) {
			//保存到SDcard
			EditText filenameText = (EditText) findViewById(R.id.filename);
			EditText filecontentText = (EditText) findViewById(R.id.filecontent);
			String filename = filenameText.getText().toString();
			String filecontent = filecontentText.getText().toString();
			
			//文件操作对象
			FileService service = new FileService(getApplicationContext());
			try{
			service.saveToSDCard(filename, filecontent);
			Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_LONG).show();
			}catch(Exception e){
				Toast.makeText(getApplicationContext(), R.string.sdcarderror, Toast.LENGTH_SHORT).show();
			}
			
			Toast.makeText(getApplicationContext(), "准备写入SDCard的文件内容是：" + filecontent, Toast.LENGTH_SHORT).show();
		}
    	   
    	
       });
       
    }
    
    private  class ButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 保存按键的事件
			EditText filenameText = (EditText) findViewById(R.id.filename);
			EditText filecontentText = (EditText) findViewById(R.id.filecontent);
			String filename = filenameText.getText().toString();
			String filecontent = filecontentText.getText().toString();
			
			Toast.makeText(getApplicationContext(), "文件内容是：" + filecontent, Toast.LENGTH_SHORT).show();
		
			
			//文件操作对象 
			FileService service = new FileService(getApplicationContext());
			try {
				service.save(filename, filecontent);
				Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Toast.makeText(getApplicationContext(), R.string.fail, Toast.LENGTH_SHORT).show();
			}
			
			
		}
    	
    	
    }

}
