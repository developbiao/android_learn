package com.ab.imageview;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	protected static final int CHANGE_UI = 1;
	protected static final int ERROR = 2;
	private static final int PATH_ERROR = 3;
	private EditText et_path;
	private ImageView iv;
	
	//1、主线程创建消息处理器
	private  Handler handler =new Handler(){

		@Override
		public void handleMessage(android.os.Message msg) {
			if(msg.what == CHANGE_UI){
				Bitmap bitmap = (Bitmap)msg.obj;  //图片异步加载过程
				iv.setImageBitmap(bitmap);
			}else if(msg.what == ERROR){
				Toast.makeText(MainActivity.this, "显示图片错误", 0).show();
			
			}else if(msg.what == PATH_ERROR){
				Toast.makeText(MainActivity.this, "图片路径不正确!", 0).show();
			}
		}
		
		
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_path = (EditText) findViewById(R.id.et_path);
        iv = (ImageView) findViewById(R.id.iv);
    }
    
    public void click(View view){
    	final String path = et_path.getText().toString().trim();
    	if(TextUtils.isEmpty(path)){
    		Message msg = new Message();
    		msg.what = PATH_ERROR;
    		handler.sendMessage(msg);
    		
    	}else{
    		new Thread(){

				@Override
				public void run() {
					//连接服务器get请求获取图片
		    		try{
		    			URL url = new URL(path);
		    			
		    			//根据url发送http请求
		    			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    			//设置请求的方式
		    			conn.setRequestMethod("GET");
		    			conn.setConnectTimeout(5000);
		    			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:29.0) Gecko/20100101 Firefox/29.0");
		    			
		    			//得到服务器返回的响应码
		    			int code = conn.getResponseCode();
		    			if(code==200){
		    				InputStream is = conn.getInputStream();
		    				Bitmap bitmap = BitmapFactory.decodeStream(is);
		    				//iv.setImageBitmap(bitmap);
		    				//TODO :告诉主线程一个消息 帮我更改界面，内容:bitmap
		    				Message msg= new Message();
		    				msg.what = CHANGE_UI;
		    				msg.obj = bitmap;
		    				handler.sendMessage(msg);
		    			}else{
		    				Message msg = new Message();
			    			msg.what = ERROR;
			    			handler.sendMessage(msg);
		    			}
		    			
		    		}catch(Exception e){
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
