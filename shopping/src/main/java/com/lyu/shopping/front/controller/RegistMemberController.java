package com.lyu.shopping.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyu.shopping.sysmanage.entity.Member;

/**
 * 类描述：用于处理注册商城会员请求的控制器
 * 类名称：com.lyu.shopping.front.controller.RegistMemberController
 * @author 曲健磊
 * 2018年4月18日.下午11:12:54
 * @version V1.0
 */
@Controller
public class RegistMemberController {
	
	/**
	 * 商城用户注册页面的uri
	 */
	public static final String REGIST_MEMBER_URI = "registMember";
	
	/**
	 * 处理前往商城用户注册页面的请求
	 * @return 商城用户注册页面的视图名称
	 */
	@RequestMapping("/toRegister")
	public String gotoRegistMember() {
		return REGIST_MEMBER_URI;
	}
	
	/**
	 * 处理注册成为商城会员的请求
	 * @return 返回注册成功或者失败的页面
	 */
	@RequestMapping("/registMember")
	public String registMember(Member member) {
		
		
		System.out.println("这是member：" + member.toString());
		
		
		return REGIST_MEMBER_URI;
	}
	
	
}
