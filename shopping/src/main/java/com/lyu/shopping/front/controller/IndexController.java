package com.lyu.shopping.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
 * 类描述：用于处理前台商城页面的请求<br/>
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
		// TODO the most important part of the project !!!
		// TODO the most important part of the project !!!
		// TODO the most important part of the project !!!
		// TODO the most important part of the project !!!
		// TODO the most important part of the project !!!
		// TODO the most important part of the project !!!
		// TODO the most important part of the project !!!
		// TODO the most important part of the project !!!
		
		return "front/main/main";
	}

	/**
	 * 根据一级类目查找该一级类目下的所有商品,以及通过一对多关联查询所有的二级类目
	 * @param session 本次会话域
	 * @param request 本次请求域
	 * @param category1Id 要查询的一级类目的id
	 * @param pageNum 当前要查询的页数
	 * @param pageSize 每页的大小
	 * @return 显示指定一级类目下的商品列表的视图名称
	 */
	@RequestMapping("/findProductListByCategory1Id/{category1Id}/{pageNum}/{pageSize}")
	public String findProductListByCategory1Id(HttpSession session, HttpServletRequest request,
		@PathVariable("category1Id") Long category1Id, @PathVariable("pageNum") Integer pageNum,
		@PathVariable("pageSize") Integer pageSize) {

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
		PageParam pageParam = new PageParam(pageNum, pageSize);
		PageInfo<ProductDTO> productList = this.productService.listProductPage(product, pageParam);
		session.setAttribute("productList", productList.getList());
		
		// 3.放置分页条的相关信息
		setPageAttribute(request, category1Id, productList, "findProductListByCategory1Id");
		
		return "front/productList";
	}

	/**
	 * 根据二级类目查找该二级类目下的所有商品
	 * @param session 本次会话域
	 * @param request 本次请求域
	 * @param category2Id 要查询的二级类目的id
	 * @param pageNum 当前要查询的页数
	 * @param pageSize 每页的大小
	 * @return 显示指定二级类目下的商品列表的视图名称
	 */
	@RequestMapping("/findProductListByCategory2Id/{category2Id}/{pageNum}/{pageSize}")
	public String findProductListByCategory2Id(HttpSession session, HttpServletRequest request,
		@PathVariable("category2Id") Long category2Id, @PathVariable("pageNum") Integer pageNum,
		@PathVariable("pageSize") Integer pageSize) {

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
		PageParam pageParam = new PageParam(pageNum, pageSize);
		PageInfo<ProductDTO> productList = this.productService.listProductPage(product, pageParam);
		session.setAttribute("productList", productList.getList());
		
		// 3.放置分页条的相关信息
		setPageAttribute(request, category2Id, productList, "findProductListByCategory2Id");
		
		return "front/productList";
	}

	/**
	 * 处理前往商品详情页面的请求
	 * @param session 本次会话域
	 * @param request 本次请求域
	 * @param productId 商品的id
	 * @return 商品详情页面的视图名称
	 */
	@RequestMapping("/getProductDetail/{productId}")
	public String getProductDetail(HttpSession session, HttpServletRequest request,
		@PathVariable("productId") Long productId) {
		if (productId == null) {
			return "front/product";
		}

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
		
		Product product = this.productService.getProductByProductId(productId);
		request.setAttribute("product", product);
		return "front/product";
	}

	/**
	 * 设置前台分页的属性，例如上一页是第几页，下一页是第几页，首页是多少，尾页是多少，
	 * 当前是一级类目的分页还是二级类目的分页，当前是第几页，总共有多少页...
	 * @param request 当前的请求域
	 * @param categoryId 当前要进行分页的类目的id
	 * @param productList 要进行分页的商品列表
	 * @param pageType 分页的类型：对一级类目进行分页还是二级类目进行分页
	 */
	@SuppressWarnings("deprecation")
	public void setPageAttribute(HttpServletRequest request, Long categoryId, PageInfo<ProductDTO> productList, String pageType) {
		request.setAttribute("pageType", pageType); // 当前是一级类目的分页还是二级类目的分页
		request.setAttribute("currPage", productList.getPageNum()); // 当前是第几页
		request.setAttribute("totalPage", productList.getPages()); // 总共有多少页
		request.setAttribute("firstPage", productList.getFirstPage()); // 首页是第几页
		request.setAttribute("lastPage", productList.getLastPage()); // 尾页是第几页
		request.setAttribute("prePage", productList.getPrePage()); // 上一页是第几页
		request.setAttribute("nextPage", productList.getNextPage()); // 下一页是第几页
		request.setAttribute("categoryId", categoryId); // 当前类目的id
	}

}
