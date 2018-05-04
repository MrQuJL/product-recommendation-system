package com.lyu.shopping.front.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lyu.shopping.front.entity.Cart;
import com.lyu.shopping.front.entity.CartItem;
import com.lyu.shopping.sysmanage.entity.Product;
import com.lyu.shopping.sysmanage.service.ProductService;

/**
 * 类描述：用于处理对购物车的请求
 * 类名称：com.lyu.shopping.front.controller.CarController
 * @author 曲健磊
 * 2018年4月26日.下午11:13:05
 * @version V1.0
 */
@Controller
public class CarController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 处理前往购物车页面的请求
	 * @return 购物车页面的视图名称
	 */
	@RequestMapping(value="/gotoCar")
	public String gotoCar() {
		return "front/car/car";
	}
	
	/**
	 * 向购物车添加商品
	 * @return 购物车页面的视图名称
	 */
	@RequestMapping(value="/addCar", method = RequestMethod.POST)
	public String addCar(Long pid, Integer count, HttpSession session, Map<String, Object> map) {
		// 1.首先获得选中的商品
		Product product = productService.getProductByProductId(pid);
		
		// 2.创建一个购物项，并设置商品的数量，商品的数量，商品的单价
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setCount(count);
		// 注：如果以后要开通优惠券系统，则需要在这里加判断即可
		cartItem.setPrice(product.getSalePrice());
		
		// 3.将该商品的信息放入session中
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		// 4.将购物项添加进来
		cart.addCart(cartItem);
		
		return "front/car";
	}
	
	/**
	 * 向购物车删除商品
	 * @return 购物车页面的视图名称
	 */
	@RequestMapping(value="/removeCar")
	public String removeCar() {
		return "";
	}
	
	/**
	 * 清空购物车
	 * @return 购物车页面的视图名称
	 */
	@RequestMapping(value="/clearCar")
	public String clearCar() {
		return "";
	}
	
}
