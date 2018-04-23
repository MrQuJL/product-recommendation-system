package com.lyu.shopping.front.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyu.shopping.sysmanage.service.Category1Service;

/**
 * 类描述：用于客户登录的控制器
 * 类名称：com.lyu.shopping.front.controller.LoginMemberController
 * @author 曲健磊
 * 2018年4月18日.下午11:07:03
 * @version V1.0
 */
@Controller
public class LoginMemberController {
	
	/**
	 * 用来打印日志
	 */
	Logger logger = Logger.getLogger(LoginMemberController.class);
	
	@Autowired
	private Category1Service category1Service;
	
	/**
	 * 存入session中的商城会员的属性名
	 */
	public static final String SESSION_MEMBER_ATTR = "member";
	
	/**
	 * 处理跳转到商城用户登录页面的请求
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public String gotoLoginMember(HttpSession session) {
//		// 如果用户一打开网页就进入这个页面，任然需要查询所有的商品列表
//		Category1 category1 = new Category1();
//		category1.setShowFlag(1);
//		List<Category1DTO> category1DTOList = this.category1Service.listCategory1DTO(category1);
//		session.setAttribute("category1List", category1DTOList);
		
		return "loginMember";
	}
	
	/**
	 * 用来验证用户登录的请求
	 * @return
	 */
	@RequestMapping(value="")
	public String loginMember() {
		return "";
	}
	
}
