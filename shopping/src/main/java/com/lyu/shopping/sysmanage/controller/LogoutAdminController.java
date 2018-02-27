package com.lyu.shopping.sysmanage.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：管理员退出的控制器
 * 类名称：com.lyu.shopping.sysmanage.controller.LogoutAdminController
 * @author 曲健磊
 * 2018年2月27日.下午7:30:41
 * @version V1.0
 */
@Controller
public class LogoutAdminController {
	
	/**
	 * 用来打印日志
	 */
	Logger logger = Logger.getLogger(LogoutAdminController.class);
	
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
