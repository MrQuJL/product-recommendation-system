package com.lyu.shopping.front.listener;

import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.lyu.shopping.sysmanage.dto.Category1DTO;
import com.lyu.shopping.sysmanage.entity.Category1;
import com.lyu.shopping.sysmanage.service.Category1Service;

/**
 * 类描述：在一个会话启动的时候，do something，例如：查询出所有的一二级类目列表
 * 类名称：com.lyu.shopping.front.listener.CategoryListener
 * @author 曲健磊
 * 2018年4月23日.下午9:19:01
 * @version V1.0
 */
@Service
@WebListener
public class CategoryListener implements HttpSessionListener, ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	/**
	 * session被创建的时候，将一二级类目列表加载到内存
	 */
    public void sessionCreated(HttpSessionEvent se)  { 
    	// 1.从IOC容器中获取一级类目服务类
    	Category1Service category1Service = (Category1Service) CategoryListener.applicationContext.getBean("category1Service");
    	// 2.设置一些查询条件
    	Category1 category1 = new Category1();
		category1.setShowFlag(1);
		// 3.获取满足条件的一二级类目列表
		List<Category1DTO> category1DTOList = category1Service.listCategory1DTO(category1);
		// 4.把满足条件的一二级类目列表放入session中
		HttpSession session = se.getSession();
		session.setAttribute("category1List", category1DTOList);
    }

	/**
	 * session被销毁的时候do something，例如：将缓存中的数据同步到硬盘
	 */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
}
