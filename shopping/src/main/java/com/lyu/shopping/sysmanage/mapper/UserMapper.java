package com.lyu.shopping.sysmanage.mapper;

import java.util.List;

import com.lyu.shopping.sysmanage.entity.User;

/**
 * 类描述：用户mapper接口
 * 类名称：com.lyu.shopping.sysmanage.mapper.UserMapper
 * @author 曲健磊
 * 2018年2月25日.下午1:47:53
 * @version V1.0
 */
public interface UserMapper {
    
	/**
	 * 根据user来查询用户列表
	 * @param user 根据user中已有的信息查询用户列表
	 * @return
	 */
	List<User> getUserList(User user);
	
	
}