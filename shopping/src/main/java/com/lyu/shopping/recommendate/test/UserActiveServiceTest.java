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
	 * 测试添加用户行为数据
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
			System.out.println("添加用户行为数据成功!!!");
		}
	}
	
	/**
	 * 测试统计某个用户的行为记录的条数
	 */
	@Test
	public void testCountUserActive() {
		UserActiveService userActiveService = (UserActiveService) application.getBean("userActiveService");
		UserActiveDTO userActiveDTO = new UserActiveDTO();
		userActiveDTO.setUserId(1L);
		userActiveDTO.setCategory2Id(36L);
		userActiveDTO.setHits(10000L);
		int rows = userActiveService.countUserActive(userActiveDTO);
		if (rows >= 1) {
			System.out.println("存在用户id为：" + userActiveDTO.getUserId() + 
				",二级类目id为：" + userActiveDTO.getCategory2Id() + "用户行为记录");
		}
	}
	
	/**
	 * 测试统计某个用户的行为记录的条数
	 */
	@Test
	public void testGetHitsOfUser() {
		UserActiveService userActiveService = (UserActiveService) application.getBean("userActiveService");
		UserActiveDTO userActiveDTO = new UserActiveDTO();
		Long userId = 1L;
		Long category2Id = 24L;
		
		userActiveDTO.setUserId(userId);
		userActiveDTO.setCategory2Id(category2Id);
		
		int hits = userActiveService.getHitsByUserActiveInfo(userActiveDTO);
		
		System.out.println("用户id为：" + userId + "，二级类目id为：" + category2Id + "的点击量为：" + hits);
		
	}
	
	/**
	 * 测试更新某个用户对某个二级类目的点击量
	 */
	@Test
	public void testUpdateHitsOfUser() {
		UserActiveService userActiveService = (UserActiveService) application.getBean("userActiveService");
		UserActiveDTO userActiveDTO = new UserActiveDTO();
		Long userId = 1L;
		Long category2Id = 24L;
		Long hits = 1200L;
		userActiveDTO.setUserId(userId);
		userActiveDTO.setCategory2Id(category2Id);
		userActiveDTO.setHits(hits);;
		
		boolean flag = userActiveService.updateUserActive(userActiveDTO);
		
		if (flag) {
			System.out.println("更新用户的点击量成功!");
		} else {
			System.out.println("更新用户的点击量失败!");
		}
		
	}
	
}
