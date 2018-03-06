package com.lyu.shopping.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
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
		
		PageParam pageParam = new PageParam();
		pageParam.setPageNo(1);
		pageParam.setPageNo(5);
		
		PageInfo<Category1> pageInfo = category1Service.listCategory1(category1, pageParam);
		
		System.out.println(pageInfo);
		
	}
	
	/**
	 * 对显示和隐藏一级类目的测试
	 */
	@Test
	public void testChangeShowFlag() {
		Category1Service category1Service = (Category1Service) this.application.getBean("category1Service");
		// 显示一级类目测试
		// System.out.println(category1Service.showCategory1(2L));
		// 隐藏一级类目测试
		System.out.println(category1Service.hideCategory1(2L));
		
	}
	
	/**
	 * 测试添加一级类目
	 */
	@Test
	public void testSaveCategory1() {
		Category1 category1 = new Category1();
		category1.setCategory1Name("测试类目");
		category1.setCategory1Record("测试类目的备注");
		Category1Service category1Service = (Category1Service) this.application.getBean("category1Service");
		boolean flag = category1Service.saveCategory1(category1);
		System.out.println(flag);
		
	}
	
	/**
	 * 测试根据 id 获取一级类目的名称
	 */
	@Test
	public void testGetCategory1ById() {
		Category1Service category1Service = (Category1Service) this.application.getBean("category1Service");
		Category1 category1 = category1Service.getCategory1ById(1L);
		
		System.out.println(category1);
		
	}
	
}
