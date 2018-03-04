package com.lyu.shopping.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.shopping.sysmanage.entity.Category1;
import com.lyu.shopping.sysmanage.service.Category1Service;

/**
 * 类描述：测试一级类目服务类的一些功能
 * 类名称：com.lyu.shopping.test.Category1ServiceTest
 * @author 曲健磊
 * 2018年3月4日.下午8:59:04
 * @version V1.0
 */
public class Category1ServiceTest {
	
	private ClassPathXmlApplicationContext application;
	
	@Before
	public void init() {
		application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 测试查询一级类目列表
	 */
	@Test
	public void testLoginAdmin() {
		Category1Service category1Service = (Category1Service) this.application.getBean("category1Service");
		
		Category1 category1 = new Category1();
		category1.setCategory1Name("");
		
		List<Category1> category1List = category1Service.listCategory1(category1);
		
		System.out.println(category1List);
		
	}
	
}
