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
	 * 向用户行为表中添加一条用户的行为记录
	 * @param userActiveDTO 用户的行为数据
	 * @return true表示添加成功，false表示添加失败
	 */
	boolean saveUserActive(UserActiveDTO userActiveDTO);
	
}
