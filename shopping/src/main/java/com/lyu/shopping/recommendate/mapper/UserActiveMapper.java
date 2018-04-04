package com.lyu.shopping.recommendate.mapper;

import java.util.List;

import com.lyu.shopping.recommendate.dto.UserActiveDTO;

/**
 * 类描述：操作数据库中用户的行为数据
 * 类名称：com.lyu.shopping.recommendate.mapper.UserActiveMapper
 * @author 曲健磊
 * 2018年3月26日.下午6:24:49
 * @version V1.0
 */
public interface UserActiveMapper {
	
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
	int getHitsByUserActiveInfo(UserActiveDTO userActiveDTO);
	
	/**
	 * 统计某个用户的行为记录的条数
	 * @param userActieveDTO 要查询的用户的行为记录的条件
	 * @return 1就说明存在这个用户的行为，0说明不存在
	 */
	int countUserActive(UserActiveDTO userActieveDTO);
	
	/**
	 * 向用户行为表中添加一条用户的行为记录
	 * @param userActive 用户的行为数据
	 * @return 受影响的行数，1表示插入成功，0表示插入失败
	 */
	int saveUserActive(UserActiveDTO userActive);
	
	/**
	 * 更新用户对某个二级类目的点击量
	 * @param userActive 用户的浏览行为数据
	 * @return 1表示更新成功，0表示更新失败
	 */
	int updateUserActive(UserActiveDTO userActive);
	
}
