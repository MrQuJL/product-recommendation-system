package com.lyu.shopping.sysmanage.service;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.entity.Category1;

/**
 * 类描述：一级类目服务类
 * 类名称：com.lyu.shopping.sysmanage.service.Category1Service
 * @author 曲健磊
 * 2018年3月4日.下午8:55:11
 * @version V1.0
 */
public interface Category1Service {
	
	/**
	 * 查询一级类目的列表
	 * @return
	 */
	PageInfo<Category1> listCategory1(Category1 category1, PageParam pageParam);
	
}
