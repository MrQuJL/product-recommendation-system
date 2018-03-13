package com.lyu.shopping.sysmanage.mapper;

import java.util.List;

import com.lyu.shopping.sysmanage.entity.Product;

/**
 * 类描述：商品的mapper接口
 * 类名称：com.lyu.shopping.sysmanage.mapper.ProductMapper
 * @author 曲健磊
 * 2018年3月13日.上午10:06:27
 * @version V1.0
 */
public interface ProductMapper {
	
	/**
	 * 查询符合条件的商品列表
	 * @param product 要查询的商品需满足的条件
	 * @return 满足条件的商品列表
	 */
	List<Product> listProduct(Product product);
	
}
