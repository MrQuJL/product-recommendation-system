package com.lyu.shopping.sysmanage.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyu.shopping.sysmanage.entity.User;
import com.lyu.shopping.sysmanage.service.UserService;

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
	
	@Autowired
	private UserService userService;
	
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
	public @ResponseBody List<User> listAdmin(String username, String date) {
		User user = new User();
		user.setUsername(username);
		List<User> userList = this.userService.listUser(user);
		return userList;
	}

}
