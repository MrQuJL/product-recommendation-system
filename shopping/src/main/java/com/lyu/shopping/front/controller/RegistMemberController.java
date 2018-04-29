package com.lyu.shopping.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.lyu.shopping.sysmanage.entity.Member;
import com.lyu.shopping.sysmanage.service.MemberService;

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
	
	@Autowired
	public MemberService memberService;
	
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
		// 1.初步验证数据的合法性
		if (member == null) {
			return "";
		}
		// 2.调用service方法增加会员
		boolean flag = memberService.saveMember(member);
		// 3.获取增加结果
		if (flag) {
			return "redirect:/toLogin"; // 增加成功，跳转到登录页面
		}
		
		// 4.增加失败，返回原页面
		System.out.println("这是member：" + member.toString());
		
		return REGIST_MEMBER_URI;
	}
	
	/**
	 * 检查用户名是否存在
	 * @param userName
	 * @return
	 */
	@RequestMapping("/checkUser/{loginName}")
	public @ResponseBody Map<String, String> checkUserName(@PathVariable(value="loginName") String loginName) {
		Map<String, String> messageMap = new HashMap<String, String>();
		messageMap.put("isExists", "false");
		
		if (StringUtils.isEmpty(loginName)) {
			// 用户名不存在,返回
			return messageMap;
		}
		// 1.创建member对象
		Member member = new Member();
		member.setLoginName(loginName);
		
		// 2.验证某个用户名是否存在
		List<Member> memeberList = memberService.listMember(member);
		if (memeberList.size() > 0) {
			messageMap.put("isExists", "true");
		}
		
		return messageMap;
	}
	
}
