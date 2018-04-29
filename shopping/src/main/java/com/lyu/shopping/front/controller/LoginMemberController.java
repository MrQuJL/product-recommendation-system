package com.lyu.shopping.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.lyu.shopping.sysmanage.entity.Member;
import com.lyu.shopping.sysmanage.service.MemberService;

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
	private MemberService memberService;
	
	/**
	 * 存入session中的商城会员的属性名
	 */
	public static final String SESSION_MEMBER_ATTR = "member";
	
	/**
	 * 商城用户登录页面的URI
	 */
	public static final String LOGIN_MEMBER_URI = "loginMember";
	
	/**
	 * 错误信息存放的属性
	 */
	public static final String ERR_MSG_ATTR = "errMsg";
	
	/**
	 * 错误消息的提示信息
	 */
	public static final String ERR_MSG_CONTENT = "用户名或密码输入有误，请重新输入！";
	
	/**
	 * 处理跳转到商城用户登录页面的请求
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public String gotoLoginMember(HttpSession session) {
		return LOGIN_MEMBER_URI;
	}
	
	/**
	 * 用来验证用户登录的请求
	 * @return
	 */
	@RequestMapping(value="/loginMember")
	public String loginMember(String loginName, String password, HttpServletRequest request, HttpSession session) {
		// 1.合法性校验
		if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
			request.setAttribute(ERR_MSG_ATTR, ERR_MSG_CONTENT);
			return LOGIN_MEMBER_URI;
		}
		// 2.调用service层方法去查询，获得返回结果
		Member member = memberService.loginMember(loginName, password);
		// 3.成功重定向到首页，并且把当前用户的信息放入session中
		if (member != null) {
			session.setAttribute("member", member);
			return "redirect:/index.jsp";
		}
		// 4.失败则转发会原页面
		request.setAttribute(ERR_MSG_ATTR, ERR_MSG_CONTENT);
		return "forward:/toLogin";
	}
	
}
