package com.lyu.shopping.sysmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * 处理前往商品列表页面的请求
	 * @return
	 */
	@RequestMapping(value="/gotoProductList")
	public String gotoProductList() {
		return PRODUCT_LIST_URI;
	}
	
	/**
	 * 处理前往商品编辑页面的请求
	 * @return
	 */
	@RequestMapping(value="/gotoProductEdit")
	public String gotoProductEdit() {
		return PRODUCT_EDIT_URI;
	}
	
}
