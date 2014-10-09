package com.ab.listener.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 1、初始化一个控件
         * 2、findViewById()查找控件
         * 3、监听事件对象，设置button的监听器，通过监听器实现我们的Button操作
         */
        
        button = (Button) findViewById(R.id.button1);
        /*
         *第一种方法匿名内部类的方法实现
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView textView;
				textView = (TextView) findViewById(R.id.show_text);
				textView.setTextColor(Color.RED);
				textView.setText("学习的态度，在于坚持！");
				System.out.println("点击事件已Touch!");
			}
        	
        });
        */
        
       
        button.setOnClickListener(this);
        
       
    }
    //第二种方法通过new OnClickListener对象实现
   /* OnClickListener listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Android的Log专业输入方法
			Log.i("tag", "new Listener点击事件已经Touch了!");
			TextView textView;
			textView = (TextView) findViewById(R.id.show_text);
			textView.setTextColor(Color.GREEN);
			textView.setText("朝正确的方向努力！");
			Toast.makeText(MainActivity.this, "朝正确的方向努力", Toast.LENGTH_LONG).show();
			
		}
    	
    };*/

	@Override
	public void onClick(View v) {
		// TODO MainActive实现接口这也是一种实现的方法
		Display();
		
	}
  
	//抽取出来的一个方法
	private void Display() {
		Log.i("tag", "MainActive实现OnClickListener已Touch!");
		TextView textView = (TextView) findViewById(R.id.show_text);
		textView.setText("每天坚持一点点离成功了就不远了!");
		textView.setTextColor(Color.GREEN);
		Toast.makeText(this, "用心去体会发现...", Toast.LENGTH_LONG).show();
		//toast 吐丝
	}
    
    /*
    //第三种方法实现OnClickListener 接口
    private final class OnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
		
			Log.i("tag", "接口的方法实现了监听事件");
			TextView textView = (TextView) findViewById(R.id.show_text);
			textView.setText("计划的足够详细才能，在可能的范围撑握自己的生活！");
			textView.setTextColor(Color.BLUE);
			Toast.makeText(MainActivity.this, "蕃茄工作法", Toast.LENGTH_LONG).show();
			
		}
    	
    }
    */
}
