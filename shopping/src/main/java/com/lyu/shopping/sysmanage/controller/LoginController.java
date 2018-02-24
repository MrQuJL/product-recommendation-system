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
	 * 处理跳转到后台管理系统登录页面的请求
	 * @return
	 */
	@RequestMapping(value="/admin")
	public String loginAdmin() {
		return "loginAdmin";
	}
	
	/**
	 * 处理跳转到商城用户登录页面的请求
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public String loginCustomer() {
		return "loginCustomer";
	}
	
	@RequestMapping(value="/main")
	public String main() {
		
		
		return "main/main";
	}
	
}
