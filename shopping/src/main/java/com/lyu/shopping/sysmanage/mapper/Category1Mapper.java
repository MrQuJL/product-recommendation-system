package com.lyu.shopping.sysmanage.mapper;

import java.util.List;

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
	 * 查询一级类目的列表
	 * @return
	 */
	List<Category1> listCategory1(Category1 category1);
	
	/**
	 * 显示或者隐藏一级类目
	 * @param isShow 值为1就是显示，值为0就是隐藏
	 * @param category1Id 要修改的一级类目的id
	 * @return
	 */
	int updateShowFlag(Long category1Id, Integer isShow);
	
	/**
	 * 添加一级类目
	 * @param category1
	 * @return
	 */
	int saveCategory1(Category1 category1);
	
	/**
	 * 修改一级类目
	 * @param category1
	 * @return
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