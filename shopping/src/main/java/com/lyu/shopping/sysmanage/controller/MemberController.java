package com.lyu.shopping.sysmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：用于会员管理的控制器
 * 类名称：com.lyu.shopping.sysmanage.controller.MemberController
 * @author 曲健磊
 * 2018年4月15日.下午4:58:06
 * @version V1.0
 */
@Controller
@RequestMapping(value="/sysmgr/member")
public class MemberController {
	
	/**
	 * 会员列表页面的uri
	 */
	private static final String MEMBER_LIST_URI = "/sysmanage/member/memberList";
	
	@RequestMapping(value="/gotoMemberList")
	public String gotoMemberList() {
		
		return MEMBER_LIST_URI;
	}
	
}
