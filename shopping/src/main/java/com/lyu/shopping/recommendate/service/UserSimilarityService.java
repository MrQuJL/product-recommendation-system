package com.lyu.shopping.recommendate.service;

import java.util.List;

import com.lyu.shopping.recommendate.dto.UserSimilarityDTO;

/**
 * 类描述：对用户之间的相似度进行增删改查的服务接口
 * 类名称：com.lyu.shopping.recommendate.service.UserSimilarityService
 * @author 曲健磊
 * 2018年3月28日.下午9:01:06
 * @version V1.0
 */
public interface UserSimilarityService {

	/**
	 * 新增用户相似度数据
	 * @param userSimilarityDTO 用户相似度数据
	 * @return true则新增用户相似度成功，false则失败
	 */
	boolean saveUserSimilarity(UserSimilarityDTO userSimilarityDTO);
	
	/**
	 * 查询某个用户与其他用户之间的相似度列表
	 * @param userId 带查询的用户id
	 * @return 该用户与其他用户的相似度列表
	 */
	List<UserSimilarityDTO> listUserSimilarityByUId(Long userId);
	
}
