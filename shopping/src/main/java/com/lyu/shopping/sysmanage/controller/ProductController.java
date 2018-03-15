package com.lyu.shopping.sysmanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.common.util.PageUtils;
import com.lyu.shopping.sysmanage.dto.Category2DTO;
import com.lyu.shopping.sysmanage.dto.ProductDTO;
import com.lyu.shopping.sysmanage.entity.Category1;
import com.lyu.shopping.sysmanage.entity.Product;
import com.lyu.shopping.sysmanage.service.Category1Service;
import com.lyu.shopping.sysmanage.service.Category2Service;
import com.lyu.shopping.sysmanage.service.ProductService;

/**
 * 类描述：用于处理对商品的一些请求
 * 类名称：com.lyu.shopping.sysmanage.controller.ProductController
 * @author 曲健磊
 * 2018年3月11日.下午4:15:59
 * @version V1.0
 */
@Controller
@RequestMapping(value="/sysmgr/product")
public class ProductController {
	
	/**
	 * 商品列表页面的URI
	 */
	private static final String PRODUCT_LIST_URI = "/sysmanage/product/productList";
	
	/**
	 * 商品编辑页面的URI
	 */
	private static final String PRODUCT_EDIT_URI = "/sysmanage/product/productEdit";
	
	/**
	 * 前台封装的分页查询商品的方法
	 */
	private static final String PRODUCT_QUERY_METHOD_PAGE = "productMgr.listProduct";
	
	/**
	 * 前台商品列表对象的属性名
	 */
	private static final String FRONT_PRODUCTLIST_ATTR = "productList";
	
	/**
	 * 前台分页条对象的属性名
	 */
	private static final String FRONT_PAGEBAR_ATTR = "pageBar";
	
	@Autowired
	private Category1Service category1Service;
	
	@Autowired
	private Category2Service category2Service;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 处理前往商品列表页面的请求
	 * @return
	 */
	@RequestMapping(value="/gotoProductList")
	public String gotoProductList(HttpSession session) {
		// 在进入商品列表页面时加载所有的一级类目，二级类目，商品名称
		List<Category1> category1List = category1Service.listCategory1(null);
		List<Category2DTO> category2List = category2Service.listCategory2(null);
		List<String> productNames = productService.listAllProductName();
		
		session.setAttribute("category1List", category1List);
		session.setAttribute("category2List", category2List);
		session.setAttribute("productNames", productNames);
		
		return PRODUCT_LIST_URI;
	}

	/**
	 * 处理前往商品编辑页面的请求
	 * 进入商品编辑列表时根据修改或者新增标识来对页面进行初始化
	 * @return
	 */
	@RequestMapping(value="/gotoProductEdit")
	public String gotoProductEdit() {
		
		
		
		
		return PRODUCT_EDIT_URI;
	}
	
	/**
	 * 处理查询商品的请求
	 * @param product 封装了要查询的商品需要满足的条件
	 * @param pageNum 第几页
	 * @param pageSize 每页多少条
	 * @return 封装有商品列表以及分页信息的map集合
	 */
	@RequestMapping(value="/listProduct/{pageNum}/{pageSize}")
	public @ResponseBody Map<String, Object> listProduct(@RequestBody Product product,
		@PathVariable(value="pageNum") Integer pageNum, @PathVariable(value="pageSize") Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		PageParam pageParam = new PageParam(pageNum, pageSize);
		if (pageNum == null || pageSize == null) {
			pageParam = null;
		}
		
		PageInfo<ProductDTO> productInfo = this.productService.listProductPage(product, pageParam);
		// 1.获取商品列表
		List<ProductDTO> productList = productInfo.getList();
		// 2.获取分页条
		String pageBar = PageUtils.pageStr(productInfo, PRODUCT_QUERY_METHOD_PAGE);
		
		map.put(FRONT_PRODUCTLIST_ATTR, productList);
		map.put(FRONT_PAGEBAR_ATTR, pageBar);
		
		return map;
	}
	
}
