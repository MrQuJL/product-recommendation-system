package com.lyu.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lyu.shopping.sysmanage.entity.User;

/**
 * 类描述：用于后台管理员登录验证的拦截器
 * 类名称：com.lyu.shopping.interceptor.LoginAdminInterceptor
 * @author 曲健磊
 * 2018年2月25日.下午3:18:58
 * @version V1.0
 */
public class LoginAdminInterceptor implements HandlerInterceptor {

	/**
	 * 在handler方法执行之前，运行这个方法里面的代码
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		System.out.println("进入LoginInterceptor.preHandle()");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// user不为空表示已经登录过，放行
		if (user != null) {
			System.out.println("已经登录过了");
			return true;
		}
		
		System.out.println("没有登录过");
		request.getRequestDispatcher("/admin").forward(request, response);
		
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
