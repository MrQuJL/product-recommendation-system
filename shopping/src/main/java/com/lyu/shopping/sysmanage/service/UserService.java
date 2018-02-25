package com.lyu.shopping.sysmanage.service;

import com.lyu.shopping.sysmanage.entity.User;

/**
 * 类描述：访问用户数据的服务类
 * 类名称：com.lyu.shopping.sysmanage.service.UserService
 * @author 曲健磊
 * 2018年2月25日.下午1:45:04
 * @version V1.0
 */
public interface UserService {

	/**
	 * 验证用户是否存在，若存在，继续验证密码是否匹配
	 * @param loginName 用户登录名称
	 * @param password 密码
	 * @return
	 */
	User loginUser(String loginName, String password);
	
}
