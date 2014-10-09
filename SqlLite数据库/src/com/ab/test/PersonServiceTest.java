/**
 * @Describe:单元测试包
 */
package com.ab.test;

import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.ab.doman.Person;
import com.ab.service.DBOpenHelper;
import com.ab.service.PersonService;

public class PersonServiceTest extends AndroidTestCase {
	/**
	 * 测试创建数据库
	 */
	private static final String TAG="PersonServiceTest";
	public void testCreateDB(){
		
		DBOpenHelper dbOpenHelper = new DBOpenHelper(getContext());
		dbOpenHelper.getWritableDatabase();
		
	}
	
	/**
	 * 测试存储数据
	 */
	public void testSave()throws Exception{
		PersonService service = new PersonService(this.getContext());
		for(int i = 0; i < 50; i++){
		Person person = new Person("zhangxx" + i, "15616213337" + i, 700 + i);
		service.save(person);
		}
	
	}
	
	/**
	 * 删除数据
	 */
	
	public void testDelete()throws Exception{
		PersonService service = new PersonService(this.getContext());
		service.delete(1);
		
		
	}
	/**
	 * 跟据ID获取数据
	 * @throws Exception
	 */
	public void testFind()throws Exception{
		PersonService service = new PersonService(this.getContext());
		Person person = service.find(2);
		Log.i(TAG, person.toString());
	}
	
	public void testScrollData() throws Exception{
		PersonService service = new PersonService(this.getContext());
		List<Person> persons = service.getScrollData(0, 5);
		for(Person person : persons){
			Log.i(TAG, person.toString());
		}
	}
	
	/**
	 * 统计数据条数
	 * @throws Exception
	 */
	public void testCount() throws Exception{
		PersonService service = new PersonService(this.getContext());
		int i = (int) service.getCount();
		System.out.println(i);
	}
	
	/**
	 *测试更新数据
	 */
	
	public void testUpdate(){
		PersonService service = new PersonService(this.getContext());
		Person person = service.find(2);
		person.setName("小学妹");
		person.setPhone("8888878");
		service.update(person);
	}
	
	public void testUpdateAmount() throws Exception{
		PersonService service = new PersonService(this.getContext());
		Person person1 = service.find(1);
		Person person2 = service.find(2);
		person2.setAmount(100);
		person1.setAmount(50);
		service.update(person1);
		service.update(person2);
	}
	
	//测试事务
	public void testPayment()throws Exception{
		PersonService service = new PersonService(this.getContext());
		service.payment();
		
	}
	
	

}
