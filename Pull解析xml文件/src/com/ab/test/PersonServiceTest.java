/*
 * 测试PersonService
 */
package com.ab.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.ab.domain.Person;
import com.ab.service.PersonService;


public class PersonServiceTest extends AndroidTestCase{
	
	/**
	 * 测试xml的pullxml获取
	 * @author gongbiao
	 *
	 */
	
	private static final String TAG = "PersonServiceTest";
	
	public void testPersons()throws Exception{
		InputStream xml = this.getClass().getClassLoader().getResourceAsStream("person.xml");
		List<Person> persons = PersonService.getPersons(xml);
		for(Person person : persons){
			Log.i(TAG, person.toString());
		}
		
	}
	
	public void testSave() throws Exception{
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(33, "xiaoqiang", 22));
		persons.add(new Person(21, "qiangge", 31));
		persons.add(new Person(17, "biaoge", 17));
		persons.add(new Person(16, "小玲", 16));
		
		File xmlFile = new File(getContext().getFilesDir(), "habao.xml");
		FileOutputStream outStream = new FileOutputStream(xmlFile);
		PersonService.Save(persons, outStream);
	}
	

}
