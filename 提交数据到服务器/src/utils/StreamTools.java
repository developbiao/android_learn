package utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;



/*
 * 把输入流的内容转化成字符串
 */
public class StreamTools {
	public static String readInputStream(InputStream is){
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte[] buffer = new byte[1024];
			while((len =is.read(buffer))!= -1){
				baos.write(buffer, 0, len);
			}
		
			is.close();
			byte[] result =  baos.toByteArray();
			String temp = new String(result);
			return temp;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "获取失败";
	}

}
