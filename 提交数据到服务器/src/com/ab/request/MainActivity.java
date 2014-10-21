package com.ab.request;

import com.ab.services.LoginService;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private EditText et_username;
	private EditText et_password;
	private Button btn_post;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		btn_post = (Button) findViewById(R.id.btn_post);
		btn_post.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//TODO 以POST的方式提交请求
				final String usernameString = et_username.getText().toString().trim();
				final String passwordString = et_password.getText().toString().trim();

				new Thread() {
					public void run() {
					final String resultString = LoginService.LoginByGet(usernameString,
								passwordString);
						if (resultString != null) {
							// 请求成功
							runOnUiThread(new Runnable() {

								@Override
								public void run() {
									// 实现这个接口
									Toast.makeText(MainActivity.this, resultString, 0).show();

								}
							});

						} else {
							// 请求失败
							runOnUiThread(new Runnable() {
								
								@Override
								public void run() {
									Toast.makeText(MainActivity.this, "POST请求失败....", 0).show();
									
								}
							});

						}
					}
				}.start();

				
			}
		});

	}

	public void Click(View view) {
		//TODO 以GET的方法请求数据
		final String usernameString = et_username.getText().toString().trim();
		final String passwordString = et_password.getText().toString().trim();

		new Thread() {
			public void run() {
			final String resultString = LoginService.LoginByGet(usernameString,
						passwordString);
				if (resultString != null) {
					// 请求成功
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// 实现这个接口
							Toast.makeText(MainActivity.this, resultString, 0).show();

						}
					});

				} else {
					// 请求失败
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							Toast.makeText(MainActivity.this, "请求失败....", 0).show();
							
						}
					});

				}
			}
		}.start();

	}

}
