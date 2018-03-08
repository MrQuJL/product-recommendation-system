package com.lyu.shopping.sysmanage.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.entity.Category1;

/**
 * 类描述：二级类目服务类
 * 类名称：com.lyu.shopping.sysmanage.service.Category2Service
 * @author 曲健磊
 * 2018年3月8日.下午5:27:09
 * @version V1.0
 */
public interface Category2Service {
	
	/**
	 * 根据一级类目的id查询出它的详细信息
	 * @param category1Id 要查询的一级类目的id
	 * @return 查询到的一级类目
	 */
	Category1 getCategory1ById(Long category1Id);
	
	/**
	 * 查询出所有的一级类目的名称
	 * @return 查询到的所有的一级类目的名称
	 */
	List<String> listAllCategory1Name();
	
	/**
	 * 查询一级类目的列表
	 * @return 封装有一级类目列表的 PageInfo
	 */
	PageInfo<Category1> listCategory1(Category1 category1, PageParam pageParam);
	
	/**
	 * 显示当前一级类目的，is_show属性设置为1
	 * @param category1Id
	 * @return true 则修改成功，false 则修改失败
	 */
	boolean showCategory1(Long category1Id);
	
	/**
	 * 隐藏当前一级类目的，is_show属性设置为0
	 * @param category1Id
	 * @return true 则修改成功，false 则修改失败
	 */
	boolean hideCategory1(Long category1Id);
	
	/**
	 * 添加一级类目
	 * @param category1 要添加的一级类目
	 * @return true 表示添加成功，false 表示添加失败
	 */
	boolean saveCategory1(Category1 category1);
	
	/**
	 * 修改一级类目
	 * @param category1 要修改的一级类目
	 * @return 成功则返回 true ，失败则返回 false
	 */
	boolean updateCategory1(Category1 category1);
	
	/**
	 * 根据id删除一级类目
	 * @param category1Id 待删除的一级类目id
	 * @return 删除成功则返回true，失败则返回false
	 */
	boolean removeCategory1(Long category1Id);
	
	/**
	 * 批量删除一级类目
	 * @param category1Ids 要删除的一级类目集合
	 * @return true表示批量删除成功，false表示失败
	 */
	boolean removeCategory1Batch(List<Long> category1Ids);
	
}
