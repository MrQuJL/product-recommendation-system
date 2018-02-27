package com.lyu.shopping.sysmanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyu.shopping.sysmanage.entity.Admin;
import com.lyu.shopping.sysmanage.service.AdminService;

/**
 * 类描述：处理管理员的请求
 * 类名称：com.lyu.shopping.sysmanage.controller.AdminController
 * @author 曲健磊
 * 2018年2月26日.下午7:20:23
 * @version V1.0
 */
@Controller
@RequestMapping(value="/sysmgr/admin")
public class AdminController {

	private Logger logger = Logger.getLogger(AdminController.class);
	
	private static final String MESSAGE_RIGHT = "新增用户成功";
	
	private static final String MESSAGE_ERROR = "新增用户失败";
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 处理跳转到管理员列表的请求
	 * @return
	 */
	@RequestMapping(value="/adminList")
	public String gotoAdminList() {
		return "sysmanage/admin/adminList";
	}
	
	/**
	 * 处理跳转到管理员个人信息的请求
	 * @return
	 */
	@RequestMapping(value="/adminInfo")
	public String gotoAdminInfo() {
		return "sysmanage/admin/adminInfo";
	}
	
	/**
	 * 处理跳转到首页的请求
	 * @return
	 */
	@RequestMapping(value="/listAdmin")
	public @ResponseBody List<Admin> listAdmin(String adminName, String date) {
		Admin admin = new Admin();
		admin.setAdminName(adminName);
		
		List<Admin> adminList = this.adminService.listAdmin(admin);
		return adminList;
	}
	
	/**
	 * 新增管理员
	 * @return
	 */
	@RequestMapping(value="/saveAdmin")
	public @ResponseBody Map<String, Object> saveAdmin(@RequestBody Admin admin) {
		Map<String, Object> message = new HashMap<String, Object>();
		
		message.put("message", MESSAGE_ERROR);
		if (admin != null) {
			boolean flag = this.adminService.saveAdmin(admin);
			if (flag) {
				message.put("message", MESSAGE_RIGHT);
			}
		}
		
		return message;
	}
	
}
