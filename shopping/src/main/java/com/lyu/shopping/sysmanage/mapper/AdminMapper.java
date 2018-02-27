package com.lyu.shopping.sysmanage.mapper;

import java.util.List;

import com.lyu.shopping.sysmanage.entity.Admin;

/**
 * 类描述：管理员mapper接口
 * 类名称：com.lyu.shopping.sysmanage.mapper.AdminMapper
 * @author 曲健磊
 * 2018年2月25日.下午1:47:53
 * @version V1.0
 */
public interface AdminMapper {
    
	/**
	 * 根据admin来查询管理员列表
	 * @param user 根据user中已有的信息查询管理员列表
	 * @return
	 */
	List<Admin> listAdmin(Admin admin);
	
	/**
	 * 新增管理员
	 * @param admin
	 * @return
	 */
	int saveAdmin(Admin admin);
	
}