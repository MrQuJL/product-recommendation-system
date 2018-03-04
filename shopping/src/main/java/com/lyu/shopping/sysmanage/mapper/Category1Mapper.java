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
	 * 查询一级类目的列表
	 * @return
	 */
	List<Category1> listCategory1(Category1 category1);
	
}