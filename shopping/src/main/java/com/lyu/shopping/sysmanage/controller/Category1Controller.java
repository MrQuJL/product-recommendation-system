package com.lyu.shopping.sysmanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.common.util.PageUtils;
import com.lyu.shopping.sysmanage.entity.Category1;
import com.lyu.shopping.sysmanage.service.Category1Service;

/**
 * 类描述：处理一级分类的请求
 * 类名称：com.lyu.shopping.sysmanage.controller.Category1Controller
 * @author 曲健磊
 * 2018年3月3日.下午1:36:48
 * @version V1.0
 */
@Controller
@RequestMapping(value="/sysmgr/category/category1")
public class Category1Controller {
	
	/**
	 * 一级分类列表的uri地址
	 */
	private static final String CATEGORY1_LIST_URI = "sysmanage/category/category1/category1List";
	
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
	private Category1Service category1Service;
	
	/**
	 * 跳转到一级类目列表页面
	 * @return
	 */
	@RequestMapping(value="/gotoCategory1List")
	public String gotoCategory1List() {
		return CATEGORY1_LIST_URI;
	}
	
	/**
	 * 处理查询一级类目列表的请求
	 * @return
	 */
	@RequestMapping(value="/listCategory1")
	public @ResponseBody Map<String, Object> listCategory1(String category1Name,
		Integer pageNo, Integer pageSize) {
		
		// 1.创建一级类目对象
		Category1 category1 = new Category1();
		category1.setCategory1Name(category1Name);
		// 2.构造分页对象
		PageParam pageParam = new PageParam(pageNo, pageSize);
		// 3.分页查询
		PageInfo<Category1> pageInfo = category1Service.listCategory1(category1, pageParam);
		
		// 获取一级类目列表
		List<Category1> category1List = pageInfo.getList();
		// 获取分页条
		String pageBar = PageUtils.pageStr(pageInfo, CATEGORY1_QUERY_METHOD_PAGE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("category1List", category1List);
		map.put("pageBar", pageBar);
		map.put("listSize", pageInfo.getTotal());
		
		return map;
	}
	
	/**
	 * 处理显示或者隐藏一级类目的请求
	 * @return
	 */
	@RequestMapping(value="/showOrHideCategory1")
	public @ResponseBody Map<String, Object> showOrHideCategory1(Integer changeValue,
		Long category1Id) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("message", "failed");
		
		boolean flag = false;
		if (changeValue.equals(1)) { // 显示该一级类目
			flag = this.category1Service.showCategory1(category1Id);
			
		} else { // 隐藏该二级类目
			flag = this.category1Service.hideCategory1(category1Id);
		}
		if (flag) {
			resultMap.put("message", "success");
		}
		
		return resultMap;
	}
	
}
