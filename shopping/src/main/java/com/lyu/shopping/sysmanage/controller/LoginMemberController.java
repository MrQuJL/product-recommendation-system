package com.lyu.shopping.sysmanage.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：用于客户登录的控制器
 * 类名称：com.lyu.shopping.sysmanage.controller.LoginCustomerController
 * @author 曲健磊
 * 2018年2月27日.下午7:21:27
 * @version V1.0
 */
@Controller
public class LoginMemberController {
	
	/**
	 * 用来打印日志
	 */
	Logger logger = Logger.getLogger(LoginMemberController.class);
	
	/**
	 * 存入session中的商城会员的属性名
	 */
	public static final String SESSION_MEMBER_ATTR = "member";
	
	/**
	 * 处理跳转到商城用户登录页面的请求
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public String gotoLoginCustomer() {
		return "loginCustomer";
	}
	
}
