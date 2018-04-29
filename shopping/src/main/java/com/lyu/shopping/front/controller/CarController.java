package com.lyu.shopping.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：用于处理对购物车的请求
 * 类名称：com.lyu.shopping.front.controller.CarController
 * @author 曲健磊
 * 2018年4月26日.下午11:13:05
 * @version V1.0
 */
@Controller
public class CarController {
	
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
	@RequestMapping(value="/gotoCar")
	public String addCar() {
		return "";
	}
	
	/**
	 * 向购物车添加商品
	 * @return 购物车页面的视图名称
	 */
	@RequestMapping(value="/gotoCar")
	public String removeCar() {
		return "";
	}
	
	/**
	 * 向购物车添加商品
	 * @return 购物车页面的视图名称
	 */
	@RequestMapping(value="/gotoCar")
	public String removeBatchCar() {
		return "";
	}
	
}
