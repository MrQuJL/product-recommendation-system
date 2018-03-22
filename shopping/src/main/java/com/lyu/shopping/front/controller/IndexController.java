package com.lyu.shopping.front.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.dto.Category1DTO;
import com.lyu.shopping.sysmanage.dto.ProductDTO;
import com.lyu.shopping.sysmanage.entity.Category1;
import com.lyu.shopping.sysmanage.entity.Product;
import com.lyu.shopping.sysmanage.service.Category1Service;
import com.lyu.shopping.sysmanage.service.ProductService;

/**
 * 类描述：用于处理前台商城页面的请求
 * 类名称：com.lyu.shopping.front.controller.IndexController
 * @author 曲健磊
 * 2018年3月21日.下午4:11:35
 * @version V1.0
 */
@Controller
public class IndexController {

	@Autowired
	private Category1Service category1Service;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 处理前往商城首页的请求
	 * @return 商城首页的视图名称
	 */
	@RequestMapping("/index")
	public String gotoIndex (HttpSession session) {
		// 在前往商城首页的时候要加载出所有的一级类目以及每个一级类目下的二级类目
		Category1 category1 = new Category1();
		category1.setShowFlag(1);
		List<Category1DTO> category1DTOList = this.category1Service.listCategory1DTO(category1);
		session.setAttribute("category1List", category1DTOList);
		
		// 通过基于用户的协同过滤的推荐算法计算出需要给用户推荐出的商品
		// TODO the most important part of the project !!!
		
		return "front/main/main";
	}
	
	/**
	 * 根据一级类目查找该一级类目下的所有商品,以及通过一对多关联查询所有的二级类目
	 * @param session 本次会话域
	 * @param category1Id 要查询的一级类目的id
	 * @return 显示指定一级类目下的商品列表的视图名称
	 */
	@RequestMapping("/findProductListByCategory1Id/{category1Id}")
	public String findProductListByCategory1Id(HttpSession session, 
		@PathVariable("category1Id") Long category1Id) {
		
		// 1.查询出所有的一级类目以及一级类目下的二级类目列表，用Category1DTO来接收
		// 如果缓存为空说明还没有加载过一级类目列表，或者一级类目列表被修改过了，此时需要重新加载一级类目列表
		@SuppressWarnings("unchecked")
		List<Category1DTO> category1DTOList = (List<Category1DTO>) session.getAttribute("category1List");
		if (category1DTOList == null) {
			Category1 category1 = new Category1();
			category1.setShowFlag(1);
			category1DTOList = this.category1Service.listCategory1DTO(category1);
			session.setAttribute("category1List", category1DTOList);
		}
		
		// 2.查询出该一级类目下的所有商品
		Product product = new Product();
		product.setCategory1Id(category1Id);
		PageParam pageParam = new PageParam(1, 8);
		PageInfo<ProductDTO> productList = this.productService.listProductPage(product, pageParam);
		
		session.setAttribute("productList", productList.getList());
		
		return "front/productList";
	}
	
	/**
	 * 根据二级类目查找该二级类目下的所有商品
	 * @param session 本次会话域
	 * @param category2Id 要查询的二级类目的id
	 * @return 显示指定二级类目下的商品列表的视图名称
	 */
	@RequestMapping("/findProductListByCategory2Id/{category2Id}")
	public String findProductListByCategory2Id(HttpSession session, 
		@PathVariable("category2Id") Long category2Id) {
		
		// 1.查询出所有的一级类目以及一级类目下的二级类目列表，用Category1DTO来接收
		// 如果缓存为空说明还没有加载过一级类目列表，或者一级类目列表被修改过了，此时需要重新加载一级类目列表
		@SuppressWarnings("unchecked")
		List<Category1DTO> category1DTOList = (List<Category1DTO>) session.getAttribute("category1List");
		if (category1DTOList == null) {
			Category1 category1 = new Category1();
			category1.setShowFlag(1);
			category1DTOList = this.category1Service.listCategory1DTO(category1);
			session.setAttribute("category1List", category1DTOList);
		}
		
		// 2.查询出该二级类目下的所有商品
		Product product = new Product();
		product.setCategory2Id(category2Id);
		PageParam pageParam = new PageParam(1, 8);
		PageInfo<ProductDTO> productList = this.productService.listProductPage(product, pageParam);
		
		session.setAttribute("productList", productList.getList());
		
		return "front/productList";
	}
	
}
