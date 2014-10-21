package com.ab.htmlviewer;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ab.htmlviewer.utils.StreamTools;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	protected static final int ERROR = 1;
	protected static final int SHOW_TEXT = 2;
	private TextView tv_content;
	private EditText et_path;
	//定义一个Handler消息处理器
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case ERROR:
				Toast.makeText(MainActivity.this, "获取数据失败", 0).show();
				break;
			case SHOW_TEXT:
				String text = (String) msg.obj;
				tv_content.setText(text);
				
				break;
			default:
				break;
			}
			
		}
		
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_content = (TextView)findViewById(R.id.tv_content);
        et_path = (EditText) findViewById(R.id.et_path);

    }
    
    public void Click(View view){
    	final String path = et_path.getText().toString().trim();
    	if(TextUtils.isEmpty(path)){
    		Toast.makeText(this, "路径不能为空", 0).show();
    	}else{
    		new Thread(){
    			public void run(){
    				try {
						URL url = new URL(path);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.setConnectTimeout(5000);
						conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:29.0) Gecko/20100101 Firefox/29.0");
						conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
						conn.setRequestProperty("Connection", "keep-alive");
						
						int code = conn.getResponseCode();
						if(code == 200){
							InputStream is = conn.getInputStream();  //服务端的输入流
							String resultString = StreamTools.readInputStream(is);
							Message msg = new Message();
							msg.what = SHOW_TEXT;
							msg.obj = resultString;
							handler.sendMessage(msg);
							
						}else{
							Message msg = new Message();
							msg.what = ERROR;
							handler.sendMessage(msg);
						}
						
					} catch (Exception e) {
						e.printStackTrace();
						Message msg = new Message();
						msg.what = ERROR;
						handler.sendMessage(msg);
					}
    			}
    		}.start();
    	}
    	
    	
    }

}
