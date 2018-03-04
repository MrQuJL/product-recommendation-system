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
	 * 统计既存在于数据库中又存在于集合中的管理员数目
	 * @param adminIds 页面上传过来的管理员id集合
	 * @return
	 */
	int countAdminInList(List<Long> adminIds);
	
	/**
	 * 统计所有管理员的数目(未删除的)
	 * @return
	 */
	Long countAdmin();
	
	/**
	 * 通过管理员id获取管理员的详细信息
	 * @param adminId 管理员id
	 * @return
	 */
	Admin getAdminByAdminId(Long adminId);
	
	/**
	 * 根据admin来查询管理员列表
	 * @param admin 根据user中已有的信息查询管理员列表
	 * @return
	 */
	List<Admin> listAdmin(Admin admin);
	
	/**
	 * 新增管理员
	 * @param admin
	 * @return
	 */
	int saveAdmin(Admin admin);
	
	/**
	 * 根据管理员id删除（逻辑删除）管理员
	 * @param adminId 管理员id
	 * @return
	 */
	int removeAdmin(Long adminId);
	
	/**
	 * 批量删除管理员
	 * @param adminIds
	 * @return
	 */
	int removeAdminBatch(List<Long> adminIds);
	
	/**
	 * 修改管理员的信息（不包括密码）
	 * @param admin 要修改的管理员
	 * @return
	 */
	int updateAdmin(Admin admin);
	
	/**
	 * 更新管理员的密码
	 * @param adminId 管理员id
	 * @param newPassword 新密码
	 * @return
	 */
	int updatePassword(Long adminId, String newPassword);
	
}