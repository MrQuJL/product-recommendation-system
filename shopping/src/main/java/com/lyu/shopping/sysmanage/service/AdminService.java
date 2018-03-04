package com.lyu.shopping.sysmanage.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.entity.Admin;

/**
 * 类描述：访问用户数据的服务类
 * 类名称：com.lyu.shopping.sysmanage.service.AdminService
 * @author 曲健磊
 * 2018年2月25日.下午1:45:04
 * @version V1.0
 */
public interface AdminService {

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
	 * 验证用户是否存在，若存在，继续验证密码是否匹配
	 * @param loginName 用户登录名称
	 * @param password 密码
	 * @return
	 */
	Admin loginAdmin(String loginName, String password);
	
	/**
	 * 根据用户已知信息分页查询用户列表
	 * @param admin 用户信息
	 * @param pageParam 分页对象
	 * @return
	 */
	PageInfo<Admin> listAdmin(Admin admin, PageParam pageParam);
	
	/**
	 * 新增管理严
	 * @param user 待新增的管理员
	 * @return
	 */
	boolean saveAdmin(Admin admin);
	
	/**
	 * 根据管理员id删除（逻辑删除）管理员
	 * @param adminId 管理员id
	 * @return
	 */
	boolean removeAdmin(Long adminId);
	
	/**
	 * 批量删除管理员
	 * @param adminIds 管理员id集合
	 * @return
	 */
	boolean removeAdminBatch(List<Long> adminIds);
	
	/**
	 * 修改管理员信息（不包括密码）
	 * @param admin 要修改的管理员
	 * @return
	 */
	boolean updateAdmin(Admin admin);
	
	/**
	 * 修改管理员密码
	 * @param adminId 管理员id
	 * @param newPassword 新密码
	 * @return 修改是否成功
	 */
	boolean updatePassword(Long adminId, String oldPassword,
		String newPassword, String confirmPassword);
	
	/**
	 * 采用sha1加密算法将密码加密
	 * @param plainPsd 未经过加密的密码
	 * @return 加密后的面膜
	 */
	String encryptPsd(String plainPsd);
	
	/**
	 * 验证密码是否正确
	 * @param plainPsd 未加密的密码
	 * @param encryptedPsd 加密之后的密码
	 * @return 密码是否正确 true 正确 false 错误
	 */
	boolean validatePsd(String plainPsd, String encryptedPsd);
	
}
