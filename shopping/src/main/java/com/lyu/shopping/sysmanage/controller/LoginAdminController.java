package com.lyu.shopping.sysmanage.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyu.shopping.sysmanage.entity.Admin;
import com.lyu.shopping.sysmanage.service.AdminService;

/**
 * 类描述：用于管理员登录的控制器
 * 类名称：com.lyu.shopping.sysmanage.controller.LoginAdminController
 * @author 曲健磊
 * 2018年2月23日.下午8:39:33
 * @version V1.0
 */
@Controller
public class LoginAdminController {
	
	/**
	 * 用来打印日志
	 */
	Logger logger = Logger.getLogger(LoginAdminController.class);
	
	/**
	 * 存入session中的管理员属性名
	 */
	public static final String SESSION_ADMIN_ATTR = "admin";
	
	/**
	 * 登录失败的错误提示信息
	 */
	private static final String LOGIN_FAILED_MESSAGE = "登录失败，请输入正确的用户名和密码";
	
	/**
	 * 管理系统登录页面的请求
	 */
	private static final String LOGIN_ADMIN_URI = "forward:/WEB-INF/pages/loginAdmin.jsp";
	
	/**
	 * 重定向到管理系统主页面的请求
	 */
	private static final String ADMIN_MAIN_REQUEST = "redirect:/admin/main";
	
	/**
	 * 管理系统主页面视图名
	 */
	private static final String ADMIN_MAIN_URI = "/sysmanage/main/main";
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 跳转到后台管理系统的登录页面
	 * @return
	 */
	@RequestMapping(value="/gotoLoginAdmin")
	public String gotoLoginAdmin() {
		return "loginAdmin";
	}
	
	/**
	 * 处理登录到后台管理页面的请求
	 * @param loginName 用户登录名
	 * @param password 用户密码
	 * @param model 存放页面中的一些属性
	 * @param session 会话域
	 * @return
	 */
	@RequestMapping(value="/loginAdmin")
	public String loginAdmin(String loginName, String password, Model model, 
		HttpSession session) {
		
		logger.info("登录用户名：" + loginName + "，密码：" + password);
		
		// 初步判断用户名和密码是否为空
		if (!StringUtils.isEmpty(loginName) && !StringUtils.isEmpty(password)) {
			Admin admin = this.adminService.loginAdmin(loginName, password);
			if (admin != null) {
				logger.info(loginName + "登录成功");
				admin.setPassword(null);
				session.setAttribute(SESSION_ADMIN_ATTR, admin);
				return ADMIN_MAIN_REQUEST;
			} else {
				model.addAttribute("loginFlag", LOGIN_FAILED_MESSAGE);
				return LOGIN_ADMIN_URI;
			}
		}
		model.addAttribute("loginFlag", LOGIN_FAILED_MESSAGE);
		return LOGIN_ADMIN_URI;
	}
	
	/**
	 * 跳转到后台管理系统主页面
	 * @return
	 */
	@RequestMapping(value="/admin/main")
	public String main() {
		return ADMIN_MAIN_URI;
	}
	
}
