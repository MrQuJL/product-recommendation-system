package com.lyu.shopping.sysmanage.service.impl;

import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.lyu.shopping.sysmanage.entity.User;
import com.lyu.shopping.sysmanage.mapper.UserMapper;
import com.lyu.shopping.sysmanage.service.UserService;
import com.lyu.shopping.util.EncryptUtils;

/**
 * 类描述：用户服务层接口的实现类
 * 类名称：com.lyu.shopping.sysmanage.service.impl.UserServiceImpl
 * @author 曲健磊
 * 2018年2月25日.下午1:46:04
 * @version V1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private static final int HASH_ITERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User loginUser(String loginName, String password) {
		if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
			return null;
		}
		User user = new User();
		user.setLoginName(loginName);
		
		// 调用mapper去查询符合条件的用户列表
		List<User> userList = this.userMapper.listUser(user);
		if (userList.isEmpty()) {
			return null;
		}
		
		// 用户列表不为空则验证密码是否正确，正确则返回该用户
		User plainUser = userList.get(0);
		String encryptedPassword = plainUser.getPassword();
		if (validatePsd(password, encryptedPassword) && plainUser.getIsAdmin().equals(1)) {
			return plainUser;
		}
		
		return null;
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
