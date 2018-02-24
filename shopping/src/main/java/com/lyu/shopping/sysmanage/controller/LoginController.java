package com.lyu.shopping.sysmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：用于登录的控制器
 * 类名称：com.lyu.shopping.sysmanage.controller.LoginController
 * @author 曲健磊
 * 2018年2月23日.下午8:39:33
 * @version V1.0
 */
@Controller
public class LoginController {

	/**
	 * 跳转到后台管理系统登录页面
	 * @return
	 */
	@RequestMapping(value="/admin")
	public String loginAdmin() {
		return "loginAdmin";
	}
	
	
	/**
	 * 跳转到商城用户登录页面
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public String loginCustomer() {
		return "loginCustomer";
	}
	
}
