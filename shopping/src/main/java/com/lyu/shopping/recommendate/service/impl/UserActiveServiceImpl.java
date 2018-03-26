package com.lyu.shopping.recommendate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
