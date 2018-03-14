package com.lyu.shopping.sysmanage.mapper;

import java.util.List;

import com.lyu.shopping.sysmanage.dto.Category2DTO;
import com.lyu.shopping.sysmanage.entity.Category2;

/**
 * 类描述：二级类目mapper接口
 * 类名称：com.lyu.shopping.sysmanage.mapper.Category2Mapper
 * @author 曲健磊
 * 2018年3月8日.下午5:22:13
 * @version V1.0
 */
public interface Category2Mapper {
    
	/**
	 * 根据二级类目的id查询出它的详细信息
	 * @param category2Id 要查询的二级类目的id
	 * @return 查询到的二级类目
	 */
	Category2DTO getCategory2ById(Long category2Id);
	
	/**
	 * 统计数据库中存在于集合中二级类目的个数
	 * @param category2Ids 二级类目的id
	 * @return 数据库中存在于category2Ids中的二级类目的数量
	 */
	int countCategory2InList(List<Long> category2Ids);
	
	/**
	 * 测试所属一级类目为category1Id的二级类目的数量
	 * @return 所属一级类目为category1Id的二级类目的数量
	 */
	int countCategory2UnderCategory1(Long category1Id);
	
	/**
	 * TODO 待完成
	 * 查询出所有的二级类目的名称
	 * @return 查询到的所有的二级类目的名称
	 */
	List<String> listAllCategory2Name();
	
	/**
	 * 查询二级类目的详细列表
	 * @param category2 查询的条件
	 * @return 符合查询条件的二级类目的dto列表
	 */
	List<Category2DTO> listCategory2(Category2 category2);
	
	/**
	 * 显示或者隐藏二级类目
	 * @param category2Id 要修改的二级类目的id
	 * @param isShow 值为1就是显示，值为0就是隐藏
	 * @return
	 */
	int updateShowFlag(Long category2Id, Integer isShow);
	
	/**
	 * 添加二级类目
	 * @param category2 要添加的二级类目
	 * @return 受影响的行数1表示添加成功，否则添加失败
	 */
	int saveCategory2(Category2 category2);
	
	/**
	 * 修改二级类目
	 * @param category2  要修改的二级类目
	 * @return 受影响的行数1表示修改成功，否则修改失败
	 */
	int updateCategory2(Category2 category2);
	
	/**
	 * 删除二级类目（逻辑删除）
	 * @param category2Id 待删除的二级类目的id
	 * @return 受影响的行数
	 */
	int removeCategory2(Long category2Id);
	
	/**
	 * 批量删除集合中的二级类目
	 * @param category2Ids 待删除的二级类目集合
	 * @return 删除成功的记录
	 */
	int removeCategory2Batch(List<Long> category2Ids);
	
}
