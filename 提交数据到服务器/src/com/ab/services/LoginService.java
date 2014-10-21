package com.ab.services;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import utils.StreamTools;

public class LoginService {
	/**
	 * 
	 * @param username
	 * @param password
	 * @return 返回null 登陆失败异常
	 */
  public static String LoginByGet(String username, String password){
	//提交数据到服务器
  	//拼装路径
  	String pathString = "http://172.30.2.181/day33/login.php?username="+username+"&password="+password+"";
    URL url;
	try {
		url = new URL(pathString);
		 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 conn.setConnectTimeout(5000);
		 conn.setRequestMethod("GET");
		 
		 int code = conn.getResponseCode();
		 if(code == 200){
			 //请求成功
			 InputStream is = conn.getInputStream();
			 String textString  = StreamTools.readInputStream(is);
			 return textString;
		 }else{
			 return null;
		 }
		 
		
	} catch (Exception e) {
		e.printStackTrace();
		return null ;
	}
   
  
  }
  
  
  public static String LoginByPost(String username, String password){
		//提交数据到服务器
	  	//拼装路径
	  	String pathString = "http://192.168.191.2/day33/postlogin.php";
	    URL url;
		try {
			url = new URL(pathString);
			 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			 conn.setConnectTimeout(5000);
			 conn.setRequestMethod("POST");
			 //准备数据
			 String dataString = "username="+ username + "password="+password+"";
			 conn.setRequestProperty("Content-Type", "text/html");
			 conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:29.0) Gecko/20100101 Firefox/29.0");
			 conn.setRequestProperty("Content-Length", dataString.length()+"");
			 
			 //post 方式实际上是浏览器把数据写给了服务器
			 conn.setDoOutput(true);
			 OutputStream os = conn.getOutputStream();
			 os.write(dataString.getBytes());
		
			 
			 int code = conn.getResponseCode();
			 if(code == 200){
				 //请求成功
				 InputStream is = conn.getInputStream();
				 String textString  = StreamTools.readInputStream(is);
				 return textString;
			 }else{
				 return null;
			 }
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
	   
	  
	  }

}
