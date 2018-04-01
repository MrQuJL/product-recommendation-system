package com.lyu.shopping.recommendate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.shopping.recommendate.dto.UserSimilarityDTO;
import com.lyu.shopping.recommendate.mapper.UserSimilarityMapper;
import com.lyu.shopping.recommendate.service.UserSimilarityService;

/**
 * 类描述：对用户之间的相似度进行增删改查的服务实现类
 * 类名称：com.lyu.shopping.recommendate.service.impl.UserSimilarityServiceImpl
 * @author 曲健磊
 * 2018年3月28日.下午9:02:22
 * @version V1.0
 */
@Service("userSimilarityService")
public class UserSimilarityServiceImpl implements UserSimilarityService {

	@Autowired
	private UserSimilarityMapper userSimilarityMapper;

	@Override
	public boolean saveUserSimilarity(UserSimilarityDTO userSimilarityDTO) {
		boolean flag = false;
		
		int rows = this.userSimilarityMapper.saveUserSimilarity(userSimilarityDTO);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateUserSimilarity(UserSimilarityDTO userSimilarityDTO) {
		boolean flag = false;
		
		int rows = this.userSimilarityMapper.updateUserSimilarity(userSimilarityDTO);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean isExistsUserSimilarity(UserSimilarityDTO userSimilarityDTO) {
		int count = this.userSimilarityMapper.countUserSimilarity(userSimilarityDTO);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<UserSimilarityDTO> listUserSimilarityByUId(Long userId) {
		if (userId == null) {
			return null;
		}
		List<UserSimilarityDTO> userSimilarityList = this.userSimilarityMapper.listUserSimilarityByUId(userId);
		
		return userSimilarityList;
	}

}
