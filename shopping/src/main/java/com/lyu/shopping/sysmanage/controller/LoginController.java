package com.lyu.shopping.sysmanage.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyu.shopping.sysmanage.entity.User;
import com.lyu.shopping.sysmanage.service.UserService;

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
	 * 用来打印日志
	 */
	Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 处理跳转到商城用户登录页面的请求
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public String gotoLoginCustomer() {
		return "loginCustomer";
	}
	
	/**
	 * 处理跳转到后台管理系统登录页面的请求
	 * @return
	 */
	@RequestMapping(value="/admin")
	public String gotoLoginAdmin() {
		return "loginAdmin";
	}
	
	/**
	 * 用来处理登录到后台管理页面的请求
	 * @param loginName 用户登录名
	 * @param password 用户密码
	 * @param model 存放页面中的一些属性
	 * @param session 本次会话
	 * @return
	 */
	@RequestMapping(value="/loginAdmin")
	public String loginAdmin(String loginName, String password, Model model, 
		HttpSession session) {
		
		logger.info("登录用户名：" + loginName + "，密码：" + password);
		
		// 初步判断用户名和密码是否为空
		if (!StringUtils.isEmpty(loginName) && !StringUtils.isEmpty(password)) {
			User user = this.userService.loginUser(loginName, password);
			if (user != null) {
				logger.info(loginName + "登录成功");
				session.setAttribute("user", user);
				return "redirect:/main";
			} else {
				model.addAttribute("loginFlag", "登录失败，请输入正确的用户名和密码");
				return "forward:/WEB-INF/pages/loginAdmin.jsp";
			}
		}
		model.addAttribute("loginFlag", "登录失败，请输入正确的用户名和密码");
		return "forward:/WEB-INF/pages/loginAdmin.jsp";
	}
	
	/**
	 * 处理跳转到后台管理系统主页面的请求
	 * @return
	 */
	@RequestMapping(value="/main")
	public String main() {
		return "main/main";
	}
	
}
