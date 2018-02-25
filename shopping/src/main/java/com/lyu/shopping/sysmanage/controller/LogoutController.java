package com.lyu.shopping.sysmanage.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：用于退出的控制器
 * 类名称：com.lyu.shopping.sysmanage.controller.LogoutController
 * @author 曲健磊
 * 2018年2月25日.下午3:44:10
 * @version V1.0
 */
@Controller
public class LogoutController {
	
	/**
	 * 用来打印日志
	 */
	Logger logger = Logger.getLogger(LogoutController.class);
	
	/**
	 * 处理退出商城用户登录状态的请求
	 * @return
	 */
	@RequestMapping(value="/logoutCustomer")
	public String gotoLoginCustomer() {
		return "loginCustomer";
	}
	
	/**
	 * 处理退出后台管理系统的请求
	 * @return
	 */
	@RequestMapping(value="/logoutAdmin")
	public String gotoLoginAdmin(HttpSession session) {
		session.removeAttribute("user");
		return "loginAdmin";
	}
}
