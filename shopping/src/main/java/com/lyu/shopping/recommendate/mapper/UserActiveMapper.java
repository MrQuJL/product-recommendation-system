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
	 * 向用户行为表中添加一条用户的行为记录
	 * @param userActive 用户的行为数据
	 * @return 受影响的行数，1表示插入成功，0表示插入失败
	 */
	int saveUserActive(UserActiveDTO userActive);
	
}
