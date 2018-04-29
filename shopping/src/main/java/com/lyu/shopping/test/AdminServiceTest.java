package com.lyu.shopping.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.shopping.sysmanage.entity.Admin;
import com.lyu.shopping.sysmanage.service.AdminService;

/**
 * 类描述：测试管理员服务类的一些功能
 * 类名称：com.lyu.shopping.sysmanage.test.AdminServiceTest
 * @author 曲健磊
 * 2018年2月25日.下午2:57:48
 * @version V1.0
 */
public class AdminServiceTest {
	
	private ClassPathXmlApplicationContext application;
	
	@Before
	public void init() {
		application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 测试查询管理员列表
	 */
	@Test
	public void testLoginAdmin() {
		AdminService adminService = (AdminService) this.application.getBean("adminService");
		Admin admin = adminService.loginAdmin("admin", "123");
		System.out.println(admin);
	}
	
	/**
	 * 测试密码加密
	 */
	@Test
	public void testEncryptPassword() {
		AdminService adminService = (AdminService) this.application.getBean("adminService");
		String encryptedPsd = adminService.encryptPsd("123");
		boolean flag = adminService.validatePsd("123", encryptedPsd);
		System.out.println(flag);
	}
	
	/**
	 * 测试根据管理员id查询管理员详细信息
	 */
	@Test
	public void testGetAdminByAdminId() {
		AdminService adminService = (AdminService) this.application.getBean("adminService");
		Admin admin  = adminService.getAdminByAdminId(1L);
		
		System.out.println(admin);
	}
	
	/**
	 * 测试根据管理员id查询管理员详细信息
	 */
	@Test
	public void testRemoveAdminBatch() {
		AdminService adminService = (AdminService) this.application.getBean("adminService");
		List<Long> adminIds = new ArrayList<Long>();
		adminIds.add(1L);
		adminIds.add(3L);
		adminIds.add(4L);
		adminIds.add(5L);
		boolean flag  = adminService.removeAdminBatch(adminIds);
		System.out.println(flag);
		
	}
	
	/**
	 * 测试将日期转换成秒
	 */
	@Test
	public void testConvertDateToMillion() {
		Date date = new Date();
		System.out.println(date.getTime());
	}
	
}
