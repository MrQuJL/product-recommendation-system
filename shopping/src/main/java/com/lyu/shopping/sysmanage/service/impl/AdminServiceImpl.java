package com.lyu.shopping.sysmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.lyu.shopping.sysmanage.entity.Admin;
import com.lyu.shopping.sysmanage.mapper.AdminMapper;
import com.lyu.shopping.sysmanage.service.AdminService;
import com.lyu.shopping.util.EncryptUtils;

/**
 * 类描述：用户服务层接口的实现类
 * 类名称：com.lyu.shopping.sysmanage.service.impl.AdminServiceImpl
 * @author 曲健磊
 * 2018年2月25日.下午1:46:04
 * @version V1.0
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

	private static final int HASH_ITERATIONS = 1024;
	
	private static final int SALT_SIZE = 8;
	
	private static final String DEFAULT_PASSWORD = "123";
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin getAdminByAdminId(Long adminId) {
		Admin admin = this.adminMapper.getAdminByAdminId(adminId);
		return admin;
	}
	
	@Override
	public Admin loginAdmin(String loginName, String password) {
		if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
			return null;
		}
		Admin admin = new Admin();
		admin.setLoginName(loginName);
		
		// 调用mapper去查询符合条件的用户列表
		List<Admin> userList = this.adminMapper.listAdmin(admin);
		if (userList.isEmpty()) {
			return null;
		}
		
		// 用户列表不为空则验证密码是否正确，正确则返回该用户
		Admin plainUser = userList.get(0);
		String encryptedPassword = plainUser.getPassword();
		if (validatePsd(password, encryptedPassword)) {
			return plainUser;
		}
		
		return null;
	}

	@Override
	public List<Admin> listAdmin(Admin admin) {
		List<Admin> adminList = this.adminMapper.listAdmin(admin);
		return adminList;
	}
	
	@Override
	public boolean saveAdmin(Admin user) {
		if (user == null) return false;
		user.setPassword(this.encryptPsd(DEFAULT_PASSWORD));
		user.setStatus(0);
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());
		user.setIsDeleted(0);
		
		int rows = this.adminMapper.saveAdmin(user);
		if (rows > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean removeAdmin(Long adminId) {
		int rows = this.adminMapper.removeAdmin(adminId);
		if (rows > 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean updateAdmin(Admin admin) {
		if (admin == null) return false;
		if (admin.getAge() == null || admin.getAge() > 999 || admin.getAge() < 1) {
			return false;
		}
		if (admin.getMobile() == "" || !admin.getMobile().matches("1[0-9]{10}") ||
			admin.getMobile().length() > 11) {
			return false;
		}
		
		// 设置管理员的修改时间
		admin.setGmtModified(new Date());
		int rows = this.adminMapper.updateAdmin(admin);
		if (rows > 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String encryptPsd(String plainPsd) {
		// 1.获取随机数
		byte[] salt = EncryptUtils.generateSalt(SALT_SIZE);
		// 2.对随机数用Hex编码
		String encodedSalt = EncryptUtils.encodeHex(salt);
		// 3.将随机数和盐通过sha1算法加密
		byte[] sha1Psd = EncryptUtils.sha1(plainPsd.getBytes(), salt, HASH_ITERATIONS);
		// 4.将上一步得到的值通过Hex来编码
		String hexSha1 = new String(Hex.encodeHex(sha1Psd));
		// 5.将第二步和第四步的值拼凑
		String encryptedPsd = encodedSalt + hexSha1;
		
		return encryptedPsd;
	}

	@Override
	public boolean validatePsd(String plainPsd, String encryptedPsd) {
		boolean flag = false;
		try {
			// 1.获取密文中的盐
			byte[] salt = Hex.decodeHex(encryptedPsd.substring(0, SALT_SIZE * 2).toCharArray());
			// 2.将盐和plainPsd加密HASH_ITERATIONS次
			byte[] sha1Psd = EncryptUtils.sha1(plainPsd.getBytes(), salt, HASH_ITERATIONS);
			// 3.用Hex来编码
			String sha1Hex = new String(Hex.encodeHex(sha1Psd));
			// 4.拼凑第三步得到的值和密文中的盐
			String psd = encryptedPsd.substring(0, SALT_SIZE * 2) + sha1Hex;
			if (psd.equals(encryptedPsd)) {
				flag = true;
			}
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}
