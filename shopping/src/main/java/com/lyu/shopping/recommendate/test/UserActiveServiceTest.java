package com.lyu.shopping.recommendate.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.shopping.recommendate.dto.UserActiveDTO;
import com.lyu.shopping.recommendate.service.UserActiveService;

/**
 * 类描述：用户测试UserActiveService接口的一些方法
 * 类名称：com.lyu.shopping.recommendate.test.UserActiveServiceTest
 * @author 曲健磊
 * 2018年3月26日.下午6:36:40
 * @version V1.0
 */
public class UserActiveServiceTest {

	private ClassPathXmlApplicationContext application;
	
	@Before
	public void init() {
		application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 测试查询所有的用户行为
	 */
	@Test
	public void testListAllUserActive() {
		UserActiveService userActiveService = (UserActiveService) application.getBean("userActiveService");
		
		List<UserActiveDTO> userActiveDTOList = userActiveService.listAllUserActive();
		
		System.out.println(userActiveDTOList.size());
		
	}
	
}
