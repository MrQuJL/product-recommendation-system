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
import com.lyu.shopping.sysmanage.dto.Category1DTO;
import com.lyu.shopping.sysmanage.dto.Category2DTO;
import com.lyu.shopping.sysmanage.entity.Category1;
import com.lyu.shopping.sysmanage.entity.Category2;
import com.lyu.shopping.sysmanage.service.Category1Service;
import com.lyu.shopping.sysmanage.service.Category2Service;

/**
 * 类描述：处理二级分类请求的控制器
 * 类名称：com.lyu.shopping.sysmanage.controller.Category2Controller
 * @author 曲健磊
 * 2018年3月8日.下午5:29:28
 * @version V1.0
 */
@Controller
@RequestMapping(value="/sysmgr/category/category2")
public class Category2Controller {
	
	/**
	 * 二级分类列表的uri地址
	 */
	private static final String CATEGORY2_LIST_URI = "sysmanage/category/category2/category2List";
	
	/**
	 * 前台页面提示信息的属性名称
	 */
	private static final String FRONT_TIPS_ATTR = "message";
	
	/**
	 * 新增二级分类成功的提示消息
	 */
	private static final String SAVE_CATEGORY2_SUCCESS = "新增二级分类成功";
	
	/**
	 * 新增二级分类失败的提示信息
	 */
	private static final String SAVE_CATEGORY2_FAILED = "新增二级分类失败";
	
	/**
	 * 删除二级分类成功的提示消息
	 */
	private static final String REMOVE_CATEGORY2_SUCCESS = "删除二级分类成功";
	
	/**
	 * 删除二级分类失败的提示消息
	 */
	private static final String REMOVE_CATEGORY2_FAILED = "删除二级分类失败";
	
	/**
	 * 删除二级分类成功的提示消息
	 */
	private static final String REMOVE_CATEGORY2_BATCH_SUCCESS = "批量删除二级分类成功";
	
	/**
	 * 删除二级分类失败的提示消息
	 */
	private static final String REMOVE_CATEGORY2_BATCH_FAILED = "批量删除二级分类失败";
	
	/**
	 * 修改二级分类成功的提示消息
	 */
	private static final String UPDATE_CATEGORY2_SUCCESS = "修改二级分类成功";
	
	/**
	 * 修改二级分类失败的提示消息
	 */
	private static final String UPDATE_CATEGORY2_FAILED = "修改二级分类失败";
	
	/**
	 * 二级分类的分页查询方法
	 */
	private static final String CATEGORY2_QUERY_METHOD_PAGE = "category2Mgr.listCategory2";
	
	@Autowired
	private Category2Service category2Service;
	
	@Autowired
	private Category1Service category1Service;
	
	/**
	 * 跳转到二级类目列表页面
	 * @return
	 */
	@RequestMapping(value="/gotoCategory2List")
	public String gotoCategory2List(HttpSession session) {
		// 在跳转到二级类目页面时加载所有的二级类目名称
		List<String> category2Names = this.category2Service.listAllCategory2Name();
		// 同时也加载所有的一级类目，便于查询
		List<Category1DTO> category1DTOList = this.category1Service.listCategory1DTO(null);
		
		session.setAttribute("category2Names", category2Names);
		session.setAttribute("category1List", category1DTOList);
		
		return CATEGORY2_LIST_URI;
	}
	
	/**
	 * 处理查询二级类目列表的请求
	 * @return
	 */
	@RequestMapping(value="/listCategory2")
	public @ResponseBody Map<String, Object> listCategory2(String category2Name,
		Long category1Id, Integer pageNo, Integer pageSize) {
		
		// 1.创建二级类目对象
		Category2 category2 = new Category2();
		if (category2Name.equals("所有二级类目")) {
			category2Name = null;
		}
		if (category1Id.equals(0L)) {
			category1Id = null;
		}
		
		category2.setCategory2Name(category2Name);
		category2.setCategory1Id(category1Id);
		// 2.构造分页对象
		PageParam pageParam = new PageParam(pageNo, pageSize);
		// 3.分页查询
		PageInfo<Category2DTO> pageInfo = category2Service.listCategory2Page(category2, pageParam);
		
		// 获取二级类目列表
		List<Category2DTO> category2List = pageInfo.getList();
		// 获取分页条
		String pageBar = PageUtils.pageStr(pageInfo, CATEGORY2_QUERY_METHOD_PAGE);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("category2List", category2List);
		map.put("pageBar", pageBar);
		map.put("listSize", pageInfo.getTotal());
		
		return map;
	}
	
	/**
	 * 处理显示或者隐藏二级类目的请求
	 * @return
	 */
	@RequestMapping(value="/showOrHideCategory2")
	public @ResponseBody Map<String, Object> showOrHideCategory2(Integer changeValue,
		Long category2Id) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("message", "failed");
		
		boolean flag = false;
		if (changeValue.equals(1)) { // 显示该二级类目
			flag = this.category2Service.showCategory2(category2Id);
			
		} else { // 隐藏该二级类目
			flag = this.category2Service.hideCategory2(category2Id);
		}
		if (flag) {
			resultMap.put(FRONT_TIPS_ATTR, "success");
		}
		
		return resultMap;
	}
	
	/**
	 * 处理根据二级类目的id查询出它的详细信息的请求
	 * @param category2Id
	 * @return
	 */
	@RequestMapping(value="/getCategory2ById")
	public @ResponseBody Map<String, Object> getCategory2ById(Long category2Id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Category2DTO category2 = this.category2Service.getCategory2ById(category2Id);
		
		resultMap.put("category2", category2);
		
		return resultMap;
	}
	
	/**
	 * 处理新增或者修改二级类目的请求
	 * @param category2
	 * @return 新增（修改）二级类目成功或者失败的提示信息
	 */
	@RequestMapping(value="/saveCategory2")
	public @ResponseBody Map<String, Object> saveCategory2(@RequestBody Category2 category2) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean flag = false;
		if (category2.getCategory2Id() == null) { // id为空说明是新增二级类目
			resultMap.put(FRONT_TIPS_ATTR, SAVE_CATEGORY2_FAILED);
			flag = this.category2Service.saveCategory2(category2);
			if (flag) {
				resultMap.put(FRONT_TIPS_ATTR, SAVE_CATEGORY2_SUCCESS);
			}
		} else { // id不为空说明是修改二级类目
			resultMap.put(FRONT_TIPS_ATTR, UPDATE_CATEGORY2_FAILED);
			flag = this.category2Service.updateCategory2(category2);
			if (flag) {
				resultMap.put(FRONT_TIPS_ATTR, UPDATE_CATEGORY2_SUCCESS);
			}
		}
		
		return resultMap;
	}
	
	/**
	 * 删除category2Id的二级类目
	 * @param category2Id 待删除的二级类目id
	 * @return 返回给前台的提示信息
	 */
	@RequestMapping(value="/removeCategory2")
	public @ResponseBody Map<String, Object> removeCategory2(Long category2Id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY2_FAILED);
		
		boolean flag = this.category2Service.removeCategory2(category2Id);
		if (flag) {
			resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY2_SUCCESS);
		}
		
		return resultMap;
	}
	
	/**
	 * 处理批量删除二级类目的请求
	 * @param category2Ids 待删除的二级类目id集合
	 * @return 删除成功或者失败的提示信息
	 */
	@RequestMapping(value="/removeCategory2Batch")
	public @ResponseBody Map<String, Object> removeCategory2Batch(@RequestBody Long[] category2Ids) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY2_BATCH_FAILED);
		
		if (category2Ids != null && category2Ids.length > 0) {
			boolean flag = this.category2Service.removeCategory2Batch(Arrays.asList(category2Ids));
			if (flag) {
				resultMap.put(FRONT_TIPS_ATTR, REMOVE_CATEGORY2_BATCH_SUCCESS);
			}
		}
		
		return resultMap;
	}
	
}
