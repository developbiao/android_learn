package com.ab.junit;

import junit.framework.Assert;
import android.test.AndroidTestCase;

import com.ab.service.PersonService;

public class PersonSerivceTest extends AndroidTestCase {
	
	//测试save方法
	public void TestSave() throws Exception{
		PersonService ps = new PersonService();
		ps.save(null);
	}
	
	//测试add方法
	public void TestAdd() throws Exception{
		
		PersonService ps = new PersonService();
		 int actual = ps.add(1, 7);
		
		 Assert.assertEquals(3, actual);//assert 断言
	}
	
	

}
