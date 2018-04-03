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
	 * 根据用户已有的行为信息获取它对某个二级类目的点击量
	 * @param userActieveDTO 用户的行为数据
	 * @return 某个用户对某个二级类目的点击量
	 */
	int getHitsByUserActiveInfo(UserActiveDTO userActieveDTO);
	
	/**
	 * 统计某个用户的行为记录的条数
	 * @param userActieveDTO 要查询的用户的行为记录的条件
	 * @return 1就说明存在这个用户的行为，0说明不存在
	 */
	int countUserActive(UserActiveDTO userActieveDTO);
	
	/**
	 * 向用户行为表中添加一条用户的行为记录
	 * @param userActiveDTO 用户的行为数据
	 * @return true表示添加成功，false表示添加失败
	 */
	boolean saveUserActive(UserActiveDTO userActiveDTO);
	
	/**
	 * 更新用户对某个二级类目的点击量
	 * @param userActive 用户的浏览行为数据
	 * @return true表示更新成功，false表示更新失败
	 */
	boolean updateUserActive(UserActiveDTO userActive);
	
}
