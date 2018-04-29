package com.lyu.shopping.recommendate.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.shopping.recommendate.dto.UserActiveDTO;
import com.lyu.shopping.recommendate.mapper.UserActiveMapper;

/**
 * 类描述：用与测试UserActiveMapper接口的一些方法
 * 类名称：com.lyu.shopping.recommendate.test.UserActiveMapperTest
 * @author 曲健磊
 * 2018年4月4日.下午7:58:56
 * @version V1.0
 */
public class UserActiveMapperTest {

	private ClassPathXmlApplicationContext application;
	
	@Before
	public void init() {
		application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 测试统计某个用户的行为记录的条数
	 */
	@Test
	public void testCountUserActive() {
		UserActiveMapper userActiveMapper = (UserActiveMapper) application.getBean("userActiveMapper");
		UserActiveDTO userActiveDTO = new UserActiveDTO();
		userActiveDTO.setUserId(1L);
		userActiveDTO.setCategory2Id(35L);
		userActiveDTO.setHits(10000L);
		int rows = userActiveMapper.countUserActive(userActiveDTO);
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
		UserActiveMapper userActiveMapper = (UserActiveMapper) application.getBean("userActiveMapper");
		UserActiveDTO userActiveDTO = new UserActiveDTO();
		Long userId = 1L;
		Long category2Id = 24L;
		userActiveDTO.setUserId(userId);
		userActiveDTO.setCategory2Id(category2Id);
		
		int hits = userActiveMapper.getHitsByUserActiveInfo(userActiveDTO);
		
		System.out.println("用户id为：" + userId + "，二级类目id为：" + category2Id + "的点击量为：" + hits);
		
	}
	
	/**
	 * 测试更新某个用户对某个二级类目的点击量
	 */
	@Test
	public void testUpdateHitsOfUser() {
		UserActiveMapper userActiveMapper = (UserActiveMapper) application.getBean("userActiveMapper");
		UserActiveDTO userActiveDTO = new UserActiveDTO();
		Long userId = 1L;
		Long category2Id = 24L;
		Long hits = 12001L;
		userActiveDTO.setUserId(userId);
		userActiveDTO.setCategory2Id(category2Id);
		userActiveDTO.setHits(hits);;
		
		int rows = userActiveMapper.updateUserActive(userActiveDTO);
		
		if (rows > 0) {
			System.out.println("更新用户的点击量成功!");
		} else {
			System.out.println("更新用户的点击量失败!");
		}
	}
}
