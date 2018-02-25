package com.lyu.shopping.sysmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.lyu.shopping.sysmanage.entity.User;
import com.lyu.shopping.sysmanage.mapper.UserMapper;
import com.lyu.shopping.sysmanage.service.UserService;

/**
 * 类描述：用户服务层接口的实现类
 * 类名称：com.lyu.shopping.sysmanage.service.impl.UserServiceImpl
 * @author 曲健磊
 * 2018年2月25日.下午1:46:04
 * @version V1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

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
		String encryptedPassword = userList.get(0).getPassword();
		if (encryptedPassword.equals(password)) {
			return userList.get(0);
		}
		
		return null;
	}

}
