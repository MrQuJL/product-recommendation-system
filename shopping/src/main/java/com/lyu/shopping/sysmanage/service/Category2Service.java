package com.lyu.shopping.sysmanage.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.dto.Category2DTO;
import com.lyu.shopping.sysmanage.entity.Category2;

/**
 * 类描述：二级类目服务接口
 * 类名称：com.lyu.shopping.sysmanage.service.Category2Service
 * @author 曲健磊
 * 2018年3月9日.上午9:34:24
 * @version V1.0
 */
public interface Category2Service {
	
	/**
	 * 根据二级类目的id查询出它的详细信息
	 * @param category2Id 要查询的二级类目的id
	 * @return 查询到的二级类目
	 */
	Category2DTO getCategory2ById(Long category2Id);
	
	/**
	 * 查询出所有的二级类目的名称
	 * @return 查询到的所有的二级类目的名称
	 */
	List<String> listAllCategory2Name();
	
	/**
	 * 查询满足条件的二级类目列表
	 * @param category2 封装的查询条件
	 * @return 满足查询条件的二级类目列表
	 */
	List<Category2DTO> listCategory2(Category2 category2);
	
	/**
	 * 查询二级类目的列表
	 * @return 封装有二级类目列表的 PageInfo
	 */
	PageInfo<Category2DTO> listCategory2Page(Category2 category2, PageParam pageParam);
	
	/**
	 * 显示当前二级类目的，is_show属性设置为1
	 * @param category2Id
	 * @return true 则修改成功，false 则修改失败
	 */
	boolean showCategory2(Long category2Id);
	
	/**
	 * 隐藏当前二级类目的，is_show属性设置为0
	 * @param category2Id
	 * @return true 则修改成功，false 则修改失败
	 */
	boolean hideCategory2(Long category2Id);
	
	/**
	 * 添加二级类目
	 * @param category2 要添加的二级类目
	 * @return true 表示添加成功，false 表示添加失败
	 */
	boolean saveCategory2(Category2 category2);
	
	/**
	 * 修改二级类目
	 * @param category2 要修改的二级类目
	 * @return 成功则返回 true ，失败则返回 false
	 */
	boolean updateCategory2(Category2 category2);
	
	/**
	 * 根据id删除二级类目
	 * @param category2Id 待删除的二级类目id
	 * @return 删除成功则返回true，失败则返回false
	 */
	boolean removeCategory2(Long category2Id);
	
	/**
	 * 批量删除二级类目
	 * @param category2Ids 要删除的二级类目集合
	 * @return true表示批量删除成功，false表示失败
	 */
	boolean removeCategory2Batch(List<Long> category2Ids);
	
}
