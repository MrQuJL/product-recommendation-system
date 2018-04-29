package com.lyu.shopping.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.dto.Category1DTO;
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
		
		PageInfo<Category1> pageInfo = category1Service.listCategory1Page(category1, pageParam);
		
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
	
	/**
	 * 测试统计数据库中存在于集合中一级类目的个数
	 */
	@Test
	public void testCountCategory1InList() {
		Category1Service category1Service = (Category1Service) this.application.getBean("category1Service");
		
		List<Long> category1Ids = new ArrayList<Long>();
		category1Ids.add(6L);
		category1Ids.add(7L);
		category1Ids.add(8L);
		category1Ids.add(9L);
		
		boolean flag = category1Service.removeCategory1Batch(category1Ids);
		
		System.out.println(flag);
		
	}
	
	// 测试查询一级类目列表
	@Test
	public void testListCategory1() {
		Category1Service category1Service = (Category1Service) this.application.getBean("category1Service");
		
		List<Category1> category1List = category1Service.listCategory1(null);
		
		System.out.println(category1List.size());
		
	}
	
	// 测试查询一级类目DTO列表
	@Test
	public void testListCategory1DTO() {
		Category1Service category1Service = (Category1Service) this.application.getBean("category1Service");
		
		List<Category1DTO> category1DTOList = category1Service.listCategory1DTO(null);
		
		for (Category1DTO category1DTO : category1DTOList) {
			System.out.println(category1DTO);
		}
		System.out.println();
	}
	
	// 测试查询一级类目下是否有二级类目
	@Test
	public void testHasSubCategory2() {
		Category1Service category1Service = (Category1Service) this.application.getBean("category1Service");
		
		List<Long> category1Ids = new ArrayList<Long>();
		category1Ids.add(20L);
		category1Ids.add(62L);
		category1Ids.add(111L);
		
		List<Long> hitIds = category1Service.hasSubCategory2(category1Ids);
		
		for (Long category1Id : hitIds) {
			System.out.println(category1Id + "命中");
		}
	}
}
