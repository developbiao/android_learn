package com.ab.autocompletetextview;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private AutoCompleteTextView acTextView;
	private String[] res = {"石棉县", "芦山", "安顺", "美罗", "宰羊"};
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * 流程：
         * 第一步：初始化控件
         * 第二步:需要一个适配器 
         * 第三步:初始化数据源--这数据去匹配输入文本框中的内容
         * 第四步：设置Adapter数据源
         */
        
        acTextView = (AutoCompleteTextView)findViewById(R.id.autoTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        		res);
        acTextView.setAdapter(adapter);
        

    }

  

}
