package com.lyu.shopping.recommendate.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.shopping.recommendate.dto.UserActiveDTO;
import com.lyu.shopping.recommendate.service.UserActiveService;

/**
 * 类描述：用与测试UserActiveService接口的一些方法
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
	
	/**
	 * 测试更新用户行为数据
	 */
	@Test
	public void testSaveUserActive() {
		UserActiveService userActiveService = (UserActiveService) application.getBean("userActiveService");
		
		UserActiveDTO userActiveDTO = new UserActiveDTO();
		userActiveDTO.setUserId(1L);
		userActiveDTO.setCategory2Id(1111L);
		userActiveDTO.setHits(10000L);
		boolean flag = userActiveService.saveUserActive(userActiveDTO);
		if (flag) {
			System.out.println("更新用户行为数据成功!!!");
		}
	}
	
}
