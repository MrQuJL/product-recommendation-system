package com.lyu.shopping.sysmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.dto.Category2DTO;
import com.lyu.shopping.sysmanage.dto.ProductDTO;
import com.lyu.shopping.sysmanage.entity.Product;
import com.lyu.shopping.sysmanage.mapper.ProductMapper;
import com.lyu.shopping.sysmanage.service.ProductService;

/**
 * 类描述：ProductService的一个实现类
 * 类名称：com.lyu.shopping.sysmanage.service.impl.ProductServiceImpl
 * @author 曲健磊
 * 2018年3月13日.上午10:39:45
 * @version V1.0
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public PageInfo<ProductDTO> listProductPage(Product product, PageParam pageParam) {
		if (product == null) {
			return null;
		}
		if (product.getProductName().equals("all")) {
			product.setProductName(null);
		}
		if (product.getCategory1Id().equals(0L)) {
			product.setCategory1Id(null);
		}
		if (product.getCategory2Id().equals(0L)) {
			product.setCategory2Id(null);
		}
		if (pageParam == null) {
			pageParam = new PageParam(1,5);
		}
		
		// 1.开启分页
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
		// 2.查询商品列表
		List<ProductDTO> productList = this.productMapper.listProduct(product);
		// 3.封装分页信息
		PageInfo<ProductDTO> productInfo = new PageInfo<ProductDTO>(productList);
		
		return productInfo;
	}

	@Override
	public List<String> listAllProductName() {
		List<String> productNames = this.productMapper.listAllProductName();
		
		return productNames;
	}

	@Override
	public boolean updateProductStatus(Long productId, Integer changeValue) {
		// 合法性判断
		if (productId == null || changeValue == null) {
			return false;
		}
		boolean flag = false;
		int rows = this.productMapper.updateProductStatus(productId, changeValue);
		if (rows > 0) {
			flag = true;
		}
		
		return flag;
	}

}
