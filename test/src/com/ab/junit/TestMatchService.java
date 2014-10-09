package com.ab.junit;

import junit.framework.Assert;
import android.test.AndroidTestCase;

import com.ab.service.MatchService;

public class TestMatchService extends AndroidTestCase {
	
	//注意在写测试方法的时候需要单独的写一个方法来测试要测试的方法
	
	//测试MatchService里面的Save方法
	public void Save()throws Exception{
		MatchService ms = new MatchService();
		ms.Save(null);
	}
	
	//测试MatchService的sum方法 
	public void Sum()throws Exception{
		MatchService ms = new MatchService();
		int sum = ms.Sum(3, 7);
		Assert.assertEquals(10, sum);
	}


}
