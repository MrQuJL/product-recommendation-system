package com.lyu.shopping.sysmanage.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：处理客户退出操作的控制器
 * 类名称：com.lyu.shopping.sysmanage.controller.LogoutCustomerController
 * @author 曲健磊
 * 2018年2月27日.下午7:22:50
 * @version V1.0
 */
@Controller
public class LogoutCustomerController {
	
	/**
	 * 用来打印日志
	 */
	Logger logger = Logger.getLogger(LogoutCustomerController.class);
	
	/**
	 * 处理退出商城用户登录状态的请求
	 * @return
	 */
	@RequestMapping(value="/logoutCustomer")
	public String gotoLoginCustomer() {
		return "loginCustomer";
	}
	
}
