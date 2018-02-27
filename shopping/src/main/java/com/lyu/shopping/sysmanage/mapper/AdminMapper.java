package com.lyu.shopping.sysmanage.mapper;

import java.util.List;

import com.lyu.shopping.sysmanage.entity.User;

/**
 * 类描述：管理员mapper接口
 * 类名称：com.lyu.shopping.sysmanage.mapper.AdminMapper
 * @author 曲健磊
 * 2018年2月25日.下午1:47:53
 * @version V1.0
 */
public interface AdminMapper {
    
	/**
	 * 根据user来查询管理员列表
	 * @param user 根据user中已有的信息查询管理员列表
	 * @return
	 */
	List<User> listAdmin(User admin);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int saveAdmin(User admin);
	
}