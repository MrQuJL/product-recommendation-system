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
import com.lyu.shopping.sysmanage.entity.Admin;
import com.lyu.shopping.sysmanage.service.AdminService;

/**
 * 类描述：处理管理员的请求
 * 类名称：com.lyu.shopping.sysmanage.controller.AdminController
 * @author 曲健磊
 * 2018年2月26日.下午7:20:23
 * @version V1.0
 */
@Controller
@RequestMapping(value="/sysmgr/admin")
public class AdminController {
	
	/**
	 * 前台页面提示信息的属性名称
	 */
	private static final String FRONT_TIPS_ATTR = "message";
	
	/**
	 * 新增管理员成功的提示消息
	 */
	private static final String SAVE_ADMIN_SUCCESS = "新增管理员成功";
	
	/**
	 * 新增管理员失败的提示信息
	 */
	private static final String SAVE_ADMIN_FAILED = "新增管理员失败";
	
	/**
	 * 删除管理员成功的提示消息
	 */
	private static final String REMOVE_ADMIN_SUCCESS = "删除管理员成功";
	
	/**
	 * 删除管理员失败的提示消息
	 */
	private static final String REMOVE_ADMIN_FAILED = "删除管理员失败";
	
	/**
	 * 修改管理员成功的提示消息
	 */
	private static final String UPDATE_ADMIN_SUCCESS = "修改管理员信息成功";
	
	/**
	 * 修改管理员失败的提示消息
	 */
	private static final String UPDATE_ADMIN_FAILED = "修改管理员信息失败";
	
	/**
	 * 修改管理员密码成功的提示消息
	 */
	private static final String UPDATE_PASSWORD_SUCCESS = "修改管理员密码成功";
	
	/**
	 * 修改管理员密码失败的提示消息
	 */
	private static final String UPDATE_PASSWORD_FAILED = "修改管理员密码失败";
	
	/**
	 * 管理员列表页面的URI
	 */
	private static final String ADMIN_LIST_URI = "sysmanage/admin/adminList";
	
	/**
	 * 管理员个人信息页面的URI
	 */
	private static final String ADMIN_INFO_URI = "sysmanage/admin/adminInfo";
	
	/**
	 * 管理员的分页查询方法
	 */
	private static final String ADMIN_QUERY_METHOD_PAGE = "adminMgr.listAdmin";
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 跳转到管理员列表页面
	 * @return
	 */
	@RequestMapping(value="/gotoAdminList")
	public String gotoAdminList() {
		return ADMIN_LIST_URI;
	}
	
	/**
	 * 跳转到管理员个人信息页面
	 * @return
	 */
	@RequestMapping(value="/gotoAdminInfo")
	public String gotoAdminInfo() {
		return ADMIN_INFO_URI;
	}
	
	/**
	 * 根据管理员id获取管理员的详细信息
	 * @return
	 */
	@RequestMapping(value="/getAdminByAdminId")
	public @ResponseBody Admin getAdminByAdminId(Long adminId) {
		Admin admin = this.adminService.getAdminByAdminId(adminId);
		return admin;
	}
	
	/**
	 * 查询管理员列表
	 * @return
	 */
	@RequestMapping(value="/listAdmin")
	public @ResponseBody Map<String, Object> listAdmin(String adminName, Integer pageNo,
		Integer pageSize) {
		
		Admin admin = new Admin();
		// 去除名称中的空格
		admin.setAdminName(adminName.replace(" ", ""));
		
		// 创建分页对象
		PageParam pageParam = new PageParam(pageNo, pageSize);
		
		PageInfo<Admin> pageInfo = this.adminService.listAdmin(admin, pageParam);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 1.获取管理员列表
		List<Admin> adminList = pageInfo.getList();
		// 2.获取分页条
		String pageBar = PageUtils.pageStr(pageInfo, ADMIN_QUERY_METHOD_PAGE);
		// 3.获取总的记录数
		Long adminNums = pageInfo.getTotal();
		
		resultMap.put("adminList", adminList);
		resultMap.put("pageBar", pageBar);
		resultMap.put("adminNums", adminNums);
		
		return resultMap;
	}
	
	/**
	 * 新增管理员
	 * @return
	 */
	@RequestMapping(value="/saveAdmin")
	public @ResponseBody Map<String, Object> saveAdmin(@RequestBody Admin admin) {
		Map<String, Object> message = new HashMap<String, Object>();
		
		message.put(FRONT_TIPS_ATTR, SAVE_ADMIN_FAILED);
		if (admin != null) {
			boolean flag = this.adminService.saveAdmin(admin);
			if (flag) {
				message.put(FRONT_TIPS_ATTR, SAVE_ADMIN_SUCCESS);
			}
		}
		
		return message;
	}
	
	/**
	 * 删除（逻辑删除）管理员
	 * @return
	 */
	@RequestMapping(value="/removeAdmin")
	public @ResponseBody Map<String, Object> removeAdmin(Long adminId) {
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, REMOVE_ADMIN_FAILED);
		
		if (adminId != null) {
			boolean flag = this.adminService.removeAdmin(adminId);
			if (flag) {
				message.put(FRONT_TIPS_ATTR, REMOVE_ADMIN_SUCCESS);
			}
		}
		
		return message;
	}
	
	/**
	 * 删除（逻辑删除）管理员
	 * @return
	 */
	@RequestMapping(value="/removeAdminBatch")
	public @ResponseBody Map<String, Object> removeAdminBatch(@RequestBody Long[] adminIds) {
		
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, REMOVE_ADMIN_FAILED);
		
		if (adminIds != null && adminIds.length > 0) {
			
			boolean flag = this.adminService.removeAdminBatch(Arrays.asList(adminIds));
			if (flag) {
				message.put(FRONT_TIPS_ATTR, REMOVE_ADMIN_SUCCESS);
			}
		}
		
		return message;
	}
	
	/**
	 *修改管理员信息
	 * @return
	 */
	@RequestMapping(value="/updateAdmin")
	public @ResponseBody Map<String, Object> updateAdmin(@RequestBody Admin admin,
		HttpSession session) {
		
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, UPDATE_ADMIN_FAILED);
		
		boolean flag = this.adminService.updateAdmin(admin);
		if (flag) {
			message.put(FRONT_TIPS_ATTR, UPDATE_ADMIN_SUCCESS);
			// 修改完管理员信息之后要更新session
			Admin updatedAdmin = this.adminService.getAdminByAdminId(admin.getId());
			session.setAttribute("admin", updatedAdmin);
		}
		
		return message;
	}
	
	
	/**
	 * 修改管理员密码 
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
		
		// 2.更新管理员密码，获取当前管理员id
		Admin admin = (Admin) session.getAttribute(LoginAdminController.SESSION_ADMIN_ATTR);
		Long adminId = admin.getId();
		boolean flag = this.adminService.updatePassword(adminId, oldPsd, newPsd, confirmPsd);
		
		if (flag) {
			message.put(FRONT_TIPS_ATTR, UPDATE_PASSWORD_SUCCESS);
		}
		
		return message;
	}
	
}
