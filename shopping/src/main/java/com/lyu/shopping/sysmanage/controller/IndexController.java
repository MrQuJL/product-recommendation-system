package com.lyu.shopping.sysmanage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyu.shopping.sysmanage.entity.Category1;
import com.lyu.shopping.sysmanage.service.Category1Service;

/**
 * 类描述：用于处理前台商城页面的请求
 * 类名称：com.lyu.shopping.sysmanage.controller.IndexController
 * @author 曲健磊
 * 2018年3月20日.下午8:45:50
 * @version V1.0
 */
@Controller
public class IndexController {

	@Autowired
	private Category1Service category1Service;
	
	/**
	 * 处理前往商城首页的请求
	 * @return 商城首页的视图名称
	 */
	@RequestMapping("/index")
	public String gotoIndex(HttpSession session) {
		// 在前往商城首页的时候要加载出所有的一级类目
		Category1 category1 = new Category1();
		category1.setShowFlag(1);
		List<Category1> category1List = this.category1Service.listCategory1(category1);
		session.setAttribute("category1List", category1List);
		
		
		// 通过基于用户的协同过滤的推荐算法计算出，需要给用户展示出的商品
		// TODO the most important part of the project !!!
		
		
		
		return "front/main/main";
	}
	
	
}
