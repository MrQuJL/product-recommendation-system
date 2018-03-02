package com.lyu.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lyu.shopping.sysmanage.controller.LoginAdminController;
import com.lyu.shopping.sysmanage.entity.Admin;

/**
 * 类描述：用于后台管理员登录验证的拦截器
 * 类名称：com.lyu.shopping.interceptor.LoginAdminInterceptor
 * @author 曲健磊
 * 2018年2月25日.下午3:18:58
 * @version V1.0
 */
public class LoginAdminInterceptor implements HandlerInterceptor {

	/**
	 * 打印日志
	 */
	Logger logger = Logger.getLogger(LoginAdminInterceptor.class);
	
	/**
	 * 跳转到管理系统登录页面的uri
	 */
	private static final String LOGIN_ADMIN_REQUEST_URI = "/gotoLoginAdmin";
	
	/**
	 * 在handler方法执行之前，运行这个方法里面的代码
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute(LoginAdminController.SESSION_ADMIN_ATTR);
		// user不为空表示已经登录过，放行
		if (admin != null) {
			return true;
		}
		
		request.getRequestDispatcher(LOGIN_ADMIN_REQUEST_URI).forward(request, response);
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
		// TODO Auto-generated method stub

	}
}
