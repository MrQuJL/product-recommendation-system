package com.lyu.shopping.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.shopping.sysmanage.entity.User;
import com.lyu.shopping.sysmanage.service.UserService;

/**
 * 类描述：测试用户服务类的一些功能
 * 类名称：com.lyu.shopping.sysmanage.test.UserTest
 * @author 曲健磊
 * 2018年2月25日.下午2:57:48
 * @version V1.0
 */
public class UserServiceTest {
	
	private ClassPathXmlApplicationContext application;
	
	@Before
	public void init() {
		application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 测试查询用户列表
	 */
	@Test
	public void testListUser() {
		UserService userService = (UserService) this.application.getBean("userService");
		User user = userService.loginUser("admin", "123456");
		System.out.println(user);
	}
	
	/**
	 * 测试密码加密
	 */
	@Test
	public void testEncryptPassword() {
		UserService userService = (UserService) this.application.getBean("userService");
		String encryptedPsd = userService.encryptPsd("123");
		boolean flag = userService.validatePsd("123", encryptedPsd);
		System.out.println(flag);
	}
	
}
