package com.lyu.shopping.sysmanage.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.dto.ProductDTO;
import com.lyu.shopping.sysmanage.entity.Product;

/**
 * 类描述：商品服务类接口
 * 类名称：com.lyu.shopping.sysmanage.service.ProductService
 * @author 曲健磊
 * 2018年3月13日.上午10:38:24
 * @version V1.0
 */
public interface ProductService {
	
	/**
	 * 分页查询符合条件的商品列表
	 * @param product 要查询的商品需满足的条件
	 * @param pageParam 分页信息
	 * @return 封装有分页信息的商品DTO列表，包括商品的一级类目名称和商品的二级类目名称
	 */
	PageInfo<ProductDTO> listProductPage(Product product, PageParam pageParam);
	
	/**
	 * 查询出所有商品的名称
	 * @return
	 */
	List<String> listAllProductName();
	
}
