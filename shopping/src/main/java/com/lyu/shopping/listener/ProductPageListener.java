package com.lyu.shopping.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 类描述：监听项目启动的时候设置初始的分页的每一页的大小
 * 类名称：com.lyu.shopping.listener.ProductPageListener
 * @author 曲健磊
 * 2018年3月25日.下午4:43:52
 * @version V1.0
 */
@WebListener
public class ProductPageListener implements ServletContextListener {

	/**
	 * 页面大小的属性
	 */
	private static final String PAGE_SIZE_ATTR = "pageSize";
	
	/**
	 * 对于项目中需要分页的条目的每一页的大小默认为8
	 */
	private static final Integer PAGE_SIZE = 8;
	
	/**
	 * 项目关闭的时候调用的方法
	 */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

	/**
	 * 项目初始化的时候调用的方法
	 */
    public void contextInitialized(ServletContextEvent sce)  { 
         sce.getServletContext().setAttribute(PAGE_SIZE_ATTR, PAGE_SIZE);
    }
	
}
