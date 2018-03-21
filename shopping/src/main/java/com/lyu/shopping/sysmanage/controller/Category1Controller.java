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
import com.lyu.shopping.sysmanage.entity.Category1;
import com.lyu.shopping.sysmanage.service.Category1Service;
import com.lyu.shopping.sysmanage.service.impl.Category1ServiceImpl;

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
	 * 因为一级类目下面有子类目而删除失败
	 */
	private static final String REMOVE_CATEGORY1_FAILED_CHILDS = "一级类目下面有子类目";
	
	/**
	 * 删除一级分类成功的提示消息
	 */
	private static final String REMOVE_CATEGORY1_BATCH_SUCCESS = "批量删除一级分类成功";
	
	/**
	 * 删除一级分类失败的提示消息
	 */
	private static final String REMOVE_CATEGORY1_BATCH_FAILED = "批量删除一级分类失败";
	
	/**
	 * 修改一级分类成功的提示消息
	 */
	private static final String UPDATE_CATEGORY1_SUCCESS = "修改一级分类成功";
	
	/**
	 * 修改一级分类失败的提示消息
	 */
	private static final String UPDATE_CATEGORY1_FAILED = "修改一级分类失败";
	
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
	public String gotoCategory1List(HttpSession session) {
		// 在跳转到一级类目页面时加载所有的一级类目名称
		List<String> category1Names = this.category1Service.listAllCategory1Name();
		session.setAttribute("category1Names", category1Names);
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
		if (category1Name == null || category1Name.equals("") || category1Name.equals("所有一级类目")) {
			category1Name = null;
		}
		category1.setCategory1Name(category1Name);
		// 2.构造分页对象
		PageParam pageParam = new PageParam(pageNo, pageSize);
		// 3.分页查询
		PageInfo<Category1> pageInfo = category1Service.listCategory1Page(category1, pageParam);
		
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
	 * @param changeValue 1为显示一级类目，0为隐藏一级类目
	 * @param category1Id 要被修改状态的一级类目的id
	 * @param session 本次会话
	 * @return 返回给前台的一些提示信息
	 */
	@RequestMapping(value="/showOrHideCategory1")
	public @ResponseBody Map<String, Object> showOrHideCategory1(Integer changeValue,
		Long category1Id, HttpSession session) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("message", "failed");
		
		boolean flag = false;
		if (changeValue.equals(1)) { // 显示该一级类目
			flag = this.category1Service.showCategory1(category1Id);
			
		} else { // 隐藏该二级类目
			flag = this.category1Service.hideCategory1(category1Id);
		}
		if (flag) {
			session.setAttribute("category1List", null);
			resultMap.put(FRONT_TIPS_ATTR, "success");
		}
		
		return resultMap;
	}
	
	/**
	 * 处理根据一级类目的id查询出它的详细信息的请求
	 * @param category1Id
	 * @return
	 */
	@RequestMapping(value="/getCategory1ById")
	public @ResponseBody Map<String, Object> getCategory1ById(Long category1Id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Category1 category1 = this.category1Service.getCategory1ById(category1Id);
		
		resultMap.put("category1", category1);
		
		return resultMap;
	}
	
	/**
	 * 处理新增或者修改一级类目的请求
	 * @param category1
	 * @return 新增（修改）一级类目成功或者失败的提示信息
	 */
	@RequestMapping(value="/saveCategory1")
	public @ResponseBody Map<String, Object> saveCategory1(@RequestBody Category1 category1) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean flag = false;
		if (category1.getCategory1Id() == null) { // id为空说明是新增一级类目
			resultMap.put(FRONT_TIPS_ATTR, SAVE_CATEGORY1_FAILED);
			flag = this.category1Service.saveCategory1(category1);
			if (flag) {
				resultMap.put(FRONT_TIPS_ATTR, SAVE_CATEGORY1_SUCCESS);
			}
		} else { // id不为空说明是修改一级类目
			resultMap.put(FRONT_TIPS_ATTR, UPDATE_CATEGORY1_FAILED);
			flag = this.category1Service.updateCategory1(category1);
			if (flag) {
				resultMap.put(FRONT_TIPS_ATTR, UPDATE_CATEGORY1_SUCCESS);
			}
		}
		
		return resultMap;
	}
	
	/**
	 * 删除category1Id的一级类目
	 * @param category1Id 待删除的一级类目id
	 * @return 返回给前台的提示信息
	 */
	@RequestMapping(value="/removeCategory1")
	public @ResponseBody Map<String, Object> removeCategory1(Long category1Id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY1_FAILED);
		
		boolean flag = this.category1Service.removeCategory1(category1Id);
		if (flag) {
			resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY1_SUCCESS);
		} else if (Category1ServiceImpl.childFlag) { // 是因为一级类目下有子类目而导致的删除失败
			resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY1_FAILED_CHILDS);
		}
		
		return resultMap;
	}
	
	/**
	 * 处理批量删除一级类目的请求
	 * @param category1Ids 待删除的一级类目id集合
	 * @return 删除成功或者失败的提示信息
	 */
	@RequestMapping(value="/removeCategory1Batch")
	public @ResponseBody Map<String, Object> removeCategory1Batch(@RequestBody Long[] category1Ids) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY1_BATCH_FAILED);
		
		if (category1Ids != null && category1Ids.length > 0) {
			// 先去查一级类目下是否有二级类目，如果有获取那些命中的二级目录
			List<Long> hitIds = category1Service.hasSubCategory2(Arrays.asList(category1Ids));
			if (hitIds == null) { // 传入的数据非法
				return resultMap;
			}
			if (hitIds.size() > 0) { //通知客户端有哪些一级类目下有二级类目
				resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY1_FAILED_CHILDS);
				resultMap.put("hitIds", hitIds);
				return resultMap;
			}
			
			
			boolean flag = this.category1Service.removeCategory1Batch(Arrays.asList(category1Ids));
			if (flag) {
				resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY1_BATCH_SUCCESS);
			} else { // 是因为一级类目下面有子类目导致的删除失败
				resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY1_FAILED_CHILDS);
			}
		}
		
		return resultMap;
	}
	
	
}
