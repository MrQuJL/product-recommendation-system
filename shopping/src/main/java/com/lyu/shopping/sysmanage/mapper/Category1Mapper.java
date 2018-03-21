package com.lyu.shopping.sysmanage.mapper;

import java.util.List;

import com.lyu.shopping.sysmanage.dto.Category1DTO;
import com.lyu.shopping.sysmanage.entity.Category1;

/**
 * 类描述：一级类目mapper接口
 * 类名称：com.lyu.shopping.sysmanage.mapper.Category1Mapper
 * @author 曲健磊
 * 2018年3月4日.下午7:55:33
 * @version V1.0
 */
public interface Category1Mapper {
    
	/**
	 * 根据一级类目的id查询出它的详细信息
	 * @param category1Id 要查询的一级类目的id
	 * @return 查询到的一级类目
	 */
	Category1 getCategory1ById(Long category1Id);
	
	/**
	 * 统计数据库中存在于集合中一级类目的个数
	 * @param category1Ids 一级类目的id
	 * @return 数据库中存在于 category1Ids 中的一级类目的数量
	 */
	int countCategory1InList(List<Long> category1Ids);
	
	/**
	 * 查询出所有的一级类目的名称
	 * @return 查询到的所有的一级类目的名称
	 */
	List<String> listAllCategory1Name();
	
	/**
	 * 查询一级类目的详细列表
	 * @param category1 查询的条件
	 * @return 符合查询条件的一级类目列表
	 */
	List<Category1> listCategory1(Category1 category1);
	
	/**
	 * 查询一级类目列表，包括每个一级类目下的二级类目列表也要查询出来
	 * @param category1 封装了查询条件
	 * @return 满足条件的一级类目数据传输对象列表
	 */
	List<Category1DTO> listCategory1DTO(Category1 category1);
	
	/**
	 * 显示或者隐藏一级类目
	 * @param isShow 值为1就是显示，值为0就是隐藏
	 * @param category1Id 要修改的一级类目的id
	 * @return
	 */
	int updateShowFlag(Long category1Id, Integer isShow);
	
	/**
	 * 添加一级类目
	 * @param category1 要添加的一级类目
	 * @return 受影响的行数1表示添加成功，否则添加失败
	 */
	int saveCategory1(Category1 category1);
	
	/**
	 * 修改一级类目
	 * @param category1  要修改的一级类目
	 * @return 受影响的行数1表示修改成功，否则修改失败
	 */
	int updateCategory1(Category1 category1);
	
	/**
	 * 删除一级类目（逻辑删除）
	 * @param category1Id 待删除的一级类目的id
	 * @return 受影响的行数
	 */
	int removeCategory1(Long category1Id);
	
	/**
	 * 批量删除集合中的一级类目
	 * @param category1Ids 待删除的一级类目集合
	 * @return 删除成功的记录
	 */
	int removeCategory1Batch(List<Long> category1Ids);
	
}
