package com.lyu.shopping.sysmanage.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.common.util.PageUtils;
import com.lyu.shopping.front.controller.LoginMemberController;
import com.lyu.shopping.sysmanage.entity.Member;
import com.lyu.shopping.sysmanage.service.MemberService;

/**
 * 类描述：处理商城会员的请求的处理器
 * 类名称：com.lyu.shopping.sysmanage.controller.MemberController
 * @author 曲健磊
 * 2018年4月17日.下午6:59:45
 * @version V1.0
 */
@Controller
@RequestMapping(value="/sysmgr/member")
public class MemberController {
	
	/**
	 * 前台页面提示信息的属性名称
	 */
	private static final String FRONT_TIPS_ATTR = "message";
	
	/**
	 * 新增商城会员成功的提示消息
	 */
	private static final String SAVE_MEMBER_SUCCESS = "新增商城会员成功";
	
	/**
	 * 新增商城会员失败的提示信息
	 */
	private static final String SAVE_MEMBER_FAILED = "新增商城会员失败";
	
	/**
	 * 删除商城会员成功的提示消息
	 */
	private static final String REMOVE_MEMBER_SUCCESS = "删除商城会员成功";
	
	/**
	 * 删除商城会员失败的提示消息
	 */
	private static final String REMOVE_MEMBER_FAILED = "删除商城会员失败";
	
	/**
	 * 修改商城会员成功的提示消息
	 */
	private static final String UPDATE_MEMBER_SUCCESS = "修改商城会员信息成功";
	
	/**
	 * 修改商城会员失败的提示消息
	 */
	private static final String UPDATE_MEMBER_FAILED = "修改商城会员信息失败";
	
	/**
	 * 修改商城会员密码成功的提示消息
	 */
	private static final String UPDATE_PASSWORD_SUCCESS = "修改商城会员密码成功";
	
	/**
	 * 修改商城会员密码失败的提示消息
	 */
	private static final String UPDATE_PASSWORD_FAILED = "修改商城会员密码失败";
	
	/**
	 * 商城会员列表页面的URI
	 */
	private static final String MEMBER_LIST_URI = "sysmanage/member/memberList";
	
	/**
	 * 商城会员个人信息页面的URI
	 */
	private static final String MEMBER_INFO_URI = "sysmanage/member/memberInfo";
	
	/**
	 * 商城会员的分页查询方法
	 */
	private static final String MEMBER_QUERY_METHOD_PAGE = "memberMgr.listMember";
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 跳转到商城会员列表页面
	 * @return
	 */
	@RequestMapping(value="/gotoMemberList")
	public String gotoMemberList() {
		return MEMBER_LIST_URI;
	}
	
	/**
	 * 跳转到商城会员个人信息页面
	 * @return
	 */
	@RequestMapping(value="/gotoMemberInfo")
	public String gotoMemberInfo() {
		return MEMBER_INFO_URI;
	}
	
	/**
	 * 根据商城会员id获取商城会员的详细信息
	 * @return
	 */
	@RequestMapping(value="/getMemberByMemberId")
	public @ResponseBody Member getMemberByMemberId(Long memberId) {
		Member member = this.memberService.getMemberByMemberId(memberId);
		return member;
	}
	
	/**
	 * 查询商城会员列表
	 * @return
	 */
	@RequestMapping(value="/listMember")
	public @ResponseBody Map<String, Object> listMember(String memberName, Integer pageNo,
		Integer pageSize) {
		
		Member member = new Member();
		// 去除名称中的空格
		member.setMemberName(memberName.replace(" ", ""));
		
		// 创建分页对象
		PageParam pageParam = new PageParam(pageNo, pageSize);
		
		PageInfo<Member> pageInfo = this.memberService.listMember(member, pageParam);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 1.获取商城会员列表
		List<Member> memberList = pageInfo.getList();
		// 2.获取分页条
		String pageBar = PageUtils.pageStr(pageInfo, MEMBER_QUERY_METHOD_PAGE);
		// 3.获取总的记录数
		Long memberNums = pageInfo.getTotal();
		
		resultMap.put("memberList", memberList);
		resultMap.put("pageBar", pageBar);
		resultMap.put("memberNums", memberNums);
		
		return resultMap;
	}
	
	/**
	 * 新增商城会员
	 * @return
	 */
	@RequestMapping(value="/saveMember")
	public @ResponseBody Map<String, Object> saveMember(@RequestBody Member member) {
		Map<String, Object> message = new HashMap<String, Object>();
		
		message.put(FRONT_TIPS_ATTR, SAVE_MEMBER_FAILED);
		if (member != null) {
			boolean flag = this.memberService.saveMember(member);
			if (flag) {
				message.put(FRONT_TIPS_ATTR, SAVE_MEMBER_SUCCESS);
			}
		}
		
		return message;
	}
	
	/**
	 * 删除（逻辑删除）商城会员
	 * @return
	 */
	@RequestMapping(value="/removeMember")
	public @ResponseBody Map<String, Object> removeMember(Long memberId) {
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, REMOVE_MEMBER_FAILED);
		
		if (memberId != null) {
			boolean flag = this.memberService.removeMember(memberId);
			if (flag) {
				message.put(FRONT_TIPS_ATTR, REMOVE_MEMBER_SUCCESS);
			}
		}
		
		return message;
	}
	
	/**
	 * 删除（逻辑删除）商城会员
	 * @return
	 */
	@RequestMapping(value="/removeMemberBatch")
	public @ResponseBody Map<String, Object> removeMemberBatch(@RequestBody Long[] memberIds) {
		
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, REMOVE_MEMBER_FAILED);
		
		if (memberIds != null && memberIds.length > 0) {
			
			boolean flag = this.memberService.removeMemberBatch(Arrays.asList(memberIds));
			if (flag) {
				message.put(FRONT_TIPS_ATTR, REMOVE_MEMBER_SUCCESS);
			}
		}
		
		return message;
	}
	
	/**
	 *修改商城会员信息
	 * @return
	 */
	@RequestMapping(value="/updateMember")
	public @ResponseBody Map<String, Object> updateMember(@RequestBody Member member,
		HttpSession session) {
		
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, UPDATE_MEMBER_FAILED);
		
		boolean flag = this.memberService.updateMember(member);
		if (flag) {
			message.put(FRONT_TIPS_ATTR, UPDATE_MEMBER_SUCCESS);
			// 修改完商城会员信息之后要更新session
			Member updatedMember = this.memberService.getMemberByMemberId(member.getId());
			session.setAttribute("member", updatedMember);
		}
		
		return message;
	}
	
	/**
	 * 修改商城会员密码 
	 * @param oldPsd 旧密码
	 * @param newPsd 新密码
	 * @param confirmPsd 确认的新密码
	 * @return
	 */
	@RequestMapping(value="/updatePassword")
	public @ResponseBody Map<String, Object> updatePassword(String oldPsd, String newPsd,
		String confirmPsd, HttpSession session) {
		
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, UPDATE_PASSWORD_FAILED);
		
		// 1.确定密码是否为空
		if (StringUtils.isEmpty(oldPsd) || StringUtils.isEmpty(newPsd) || 
			StringUtils.isEmpty(confirmPsd)) {
			return message; 
		}
		
		// 2.更新商城会员密码，获取当前商城会员id
		Member member = (Member) session.getAttribute(LoginMemberController.SESSION_MEMBER_ATTR);
		Long memberId = member.getId();
		boolean flag = this.memberService.updatePassword(memberId, oldPsd, newPsd, confirmPsd);
		
		if (flag) {
			message.put(FRONT_TIPS_ATTR, UPDATE_PASSWORD_SUCCESS);
		}
		
		return message;
	}
	
}
