package com.lyu.shopping.sysmanage.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.common.util.PageUtils;
import com.lyu.shopping.sysmanage.entity.category1;
import com.lyu.shopping.sysmanage.service.category1Service;

/**
 * 类描述：处理一级分类的请求
 * 类名称：com.lyu.shopping.sysmanage.controller.Category1Controller
 * @author 曲健磊
 * 2018年3月3日.下午1:36:48
 * @version V1.0
 */
@Controller
@RequestMapping(value="/sysmgr/category1")
public class Category1Controller {
	
	/**
	 * 前台页面提示信息的属性名称
	 */
	private static final String FRONT_TIPS_ATTR = "message";
	
	/**
	 * 新增一级分类成功的提示消息
	 */
	private static final String SAVE_CATEGORY1_SUCCESS = "新增一级分类成功";
	
	/**
	 * 新增一级分类失败的提示信息
	 */
	private static final String SAVE_CATEGORY1_FAILED = "新增一级分类失败";
	
	/**
	 * 删除一级分类成功的提示消息
	 */
	private static final String REMOVE_CATEGORY1_SUCCESS = "删除一级分类成功";
	
	/**
	 * 删除一级分类失败的提示消息
	 */
	private static final String REMOVE_CATEGORY1_FAILED = "删除一级分类失败";
	
	/**
	 * 修改一级分类成功的提示消息
	 */
	private static final String UPDATE_CATEGORY1_SUCCESS = "修改一级分类信息成功";
	
	/**
	 * 修改一级分类失败的提示消息
	 */
	private static final String UPDATE_CATEGORY1_FAILED = "修改一级分类信息失败";
	
	/**
	 * 一级分类的分页查询方法
	 */
	private static final String CATEGORY1_QUERY_METHOD_PAGE = "category1Mgr.listCategory1";
	
	@Autowired
	private category1Service category1Service;
	
	/**
	 * 跳转到一级分类列表页面
	 * @return
	 */
	@RequestMapping(value="/gotocategory1List")
	public String gotocategory1List() {
		return "sysmanage/category1/category1List";
	}
	
	/**
	 * 跳转到一级分类个人信息页面
	 * @return
	 */
	@RequestMapping(value="/gotocategory1Info")
	public String gotocategory1Info() {
		
		return "sysmanage/category1/category1Info";
	}
	
	/**
	 * 根据一级分类id获取一级分类的详细信息
	 * @return
	 */
	@RequestMapping(value="/getcategory1Bycategory1Id")
	public @ResponseBody category1 getcategory1Bycategory1Id(Long category1Id) {
		category1 category1 = this.category1Service.getcategory1Bycategory1Id(category1Id);
		return category1;
	}
	
	/**
	 * 查询一级分类列表
	 * @return
	 */
	@RequestMapping(value="/listcategory1")
	public @ResponseBody Map<String, Object> listcategory1(String category1Name, Integer pageNo,
		Integer pageSize) {
		
		category1 category1 = new category1();
		// 去除名称中的空格
		category1.setcategory1Name(category1Name.replace(" ", ""));
		
		// 创建分页对象
		PageParam pageParam = new PageParam(pageNo, pageSize);
		
		PageInfo<category1> pageInfo = this.category1Service.listcategory1(category1, pageParam);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 1.获取一级分类列表
		List<category1> category1List = pageInfo.getList();
		// 2.获取分页条
		String pageBar = PageUtils.pageStr(pageInfo, category1_QUERY_METHOD_PAGE);
		
		resultMap.put("category1List", category1List);
		resultMap.put("pageBar", pageBar);
		
		return resultMap;
	}
	
	/**
	 * 新增一级分类
	 * @return
	 */
	@RequestMapping(value="/savecategory1")
	public @ResponseBody Map<String, Object> savecategory1(@RequestBody category1 category1) {
		Map<String, Object> message = new HashMap<String, Object>();
		
		message.put(FRONT_TIPS_ATTR, SAVE_category1_FAILED);
		if (category1 != null) {
			boolean flag = this.category1Service.savecategory1(category1);
			if (flag) {
				message.put(FRONT_TIPS_ATTR, SAVE_category1_SUCCESS);
			}
		}
		
		return message;
	}
	
	/**
	 * 删除（逻辑删除）一级分类
	 * @return
	 */
	@RequestMapping(value="/removecategory1")
	public @ResponseBody Map<String, Object> removecategory1(Long category1Id) {
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, REMOVE_category1_FAILED);
		
		if (category1Id != null) {
			boolean flag = this.category1Service.removecategory1(category1Id);
			if (flag) {
				message.put(FRONT_TIPS_ATTR, REMOVE_category1_SUCCESS);
			}
		}
		
		return message;
	}
	
	/**
	 * 删除（逻辑删除）一级分类
	 * @return
	 */
	@RequestMapping(value="/removecategory1Batch")
	public @ResponseBody Map<String, Object> removecategory1Batch(@RequestBody Long[] category1Ids) {
		
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, REMOVE_category1_FAILED);
		
		if (category1Ids != null && category1Ids.length > 0) {
			
			boolean flag = this.category1Service.removecategory1Batch(Arrays.asList(category1Ids));
			if (flag) {
				message.put(FRONT_TIPS_ATTR, REMOVE_category1_SUCCESS);
			}
		}
		
		return message;
	}
	
	/**
	 *修改一级分类信息
	 * @return
	 */
	@RequestMapping(value="/updatecategory1")
	public @ResponseBody Map<String, Object> updatecategory1(@RequestBody category1 category1,
		HttpSession session) {
		
		Map<String, Object> message = new HashMap<String, Object>();
		message.put(FRONT_TIPS_ATTR, UPDATE_category1_FAILED);
		
		boolean flag = this.category1Service.updatecategory1(category1);
		if (flag) {
			message.put(FRONT_TIPS_ATTR, UPDATE_category1_SUCCESS);
			// 修改完一级分类信息之后要更新session
			category1 updatedcategory1 = this.category1Service.getcategory1Bycategory1Id(category1.getId());
			session.setAttribute("category1", updatedcategory1);
		}
		
		return message;
	}
	
}
