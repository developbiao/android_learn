package com.ab.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class FileService {
	private Context context;
	
	public FileService(Context context){
		this.context = context;
	}

	/*
	 * @Desc:文件的保存
	 * @param filename 保存文件名
	 * @param filecontent 保存内容
	 * 
	 */
	public void save(String filename, String filecontent) throws Exception{
	
		//MODE.PRIVATE:私有模式创建出来的文件只能被自己访问，其它应用无法访问，另外私有模式操作创建
		//文件会覆盖原来的文件
		FileOutputStream outStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
		outStream.write(filecontent.getBytes());
		Log.i("tag", filecontent);
		outStream.close();
	}
	
	public void saveAppend(String filename, String content) throws Exception{
		FileOutputStream outStream = context.openFileOutput(filename, Context.MODE_APPEND);
		outStream.write(content.getBytes());
		outStream.close();
	}
	
	/*
	 * @Desc:文件的读取
	 * @param filename 文件名
	 * @return content 文件内容
	 * @throws Exception
	 */
	public String read(String filename) throws Exception{
		FileInputStream inStream = context.openFileInput(filename);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len=(inStream.read()))!= -1){
			outStream.write(buffer, 0, len);
		}
		byte[] data = outStream.toByteArray();
		outStream.close();
		inStream.close();
		return new String(data);
	}

	/**
	 * 
	 * @param filename
	 * @param filecontent
	 */
	public void saveToSDCard(String filename, String filecontent)throws Exception {
		// 存储文件到SDCard中
		
		//Environment.getExternaStorageDirectory()  获取内存卡的路径
		File file = new File(Environment.getExternalStorageDirectory(), filename);
		FileOutputStream outStream = new FileOutputStream(file);
		outStream.write(filecontent.getBytes());
		outStream.close();
		
	}
	
	
	
	
}
