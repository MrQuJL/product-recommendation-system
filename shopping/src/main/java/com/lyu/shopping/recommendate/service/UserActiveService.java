package com.lyu.shopping.recommendate.service;

import java.util.List;

import com.lyu.shopping.recommendate.dto.UserActiveDTO;

/**
 * 类描述：操作数据库中用户的行为数据的服务类
 * 类名称：com.lyu.shopping.recommendate.service.UserActiveService
 * @author 曲健磊
 * 2018年3月26日.下午6:33:09
 * @version V1.0
 */
public interface UserActiveService {

	/**
	 * 查询出所有的用户行为
	 * @return 返回用户的行为数据
	 */
	List<UserActiveDTO> listAllUserActive();
	
	/**
	 * 保存用户的浏览记录，如果用户的浏览记录存在则更新，不存在则添加
	 * @param userActiveDTO 用户的行为数据
	 * @return true表示更新成功，false表示更新失败
	 */
	boolean saveUserActive(UserActiveDTO userActiveDTO);
	
}
