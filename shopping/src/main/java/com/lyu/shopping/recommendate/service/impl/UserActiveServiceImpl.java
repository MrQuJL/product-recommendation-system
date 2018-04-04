package com.lyu.shopping.recommendate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lyu.shopping.recommendate.dto.UserActiveDTO;
import com.lyu.shopping.recommendate.mapper.UserActiveMapper;
import com.lyu.shopping.recommendate.service.UserActiveService;

@Service("userActiveService")
public class UserActiveServiceImpl implements UserActiveService {

	@Autowired
	private UserActiveMapper userActiveMapper;

	@Override
	public List<UserActiveDTO> listAllUserActive() {
		return userActiveMapper.listAllUserActive();
	}
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public boolean saveUserActive(UserActiveDTO userActiveDTO) {
		boolean flag = false;
		// 1.先判断数据库中是否存在当前用户的浏览记录
		int rows = this.userActiveMapper.countUserActive(userActiveDTO);
		int saveRows = 0;
		int updateRows = 0;
		// 2.不存在就添加
		if (rows < 1) { // 不存在
			saveRows = this.userActiveMapper.saveUserActive(userActiveDTO);
		} else { // 已经存在
			// 3.存在则先把当前用户对当前二级类目的点击量取出来+1
			long hits = this.userActiveMapper.getHitsByUserActiveInfo(userActiveDTO);
			// 4.然后在更新用户的浏览记录
			hits++;
			userActiveDTO.setHits(hits);
			updateRows = this.userActiveMapper.updateUserActive(userActiveDTO);
		}
		if (saveRows > 0 || updateRows > 0) {
			flag = true;
		}
		return flag;
	}
}
