package com.ab.demo04;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends ActionBarActivity {

	private MultiAutoCompleteTextView macTextView;
	private String[] res = {"张三","张小三","张玲"
							,"龚彪", "龚自珍", "龚玲",
							"李小帅","李矓", "李小明",
							"王小红", "王儿小", "王超"
							};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /**
         * 第一步：初始化控件
         * 第二步：需要一个Adapter
         * 第三步：初始化数据源，这个数据是源是去匹配输入文本框中的内容
         * 第四步：设置分隔符
         */
        macTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        		res);
        macTextView.setAdapter(adapter);
        //设逗号为结束分隔符
        macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        
    }



}
