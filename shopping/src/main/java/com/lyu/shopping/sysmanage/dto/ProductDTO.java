package com.lyu.shopping.sysmanage.dto;

import com.lyu.shopping.sysmanage.entity.Product;

/**
 * 类描述：商品数据传输对象
 * 类名称：com.lyu.shopping.sysmanage.dto.ProductDTO
 * @author 曲健磊
 * 2018年3月13日.上午10:20:21
 * @version V1.0
 */
public class ProductDTO extends Product {

	private static final long serialVersionUID = -2025824389940578630L;

	private String category1Name;
	
	private String category2Name;

	public String getCategory1Name() {
		return category1Name;
	}

	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}

	public String getCategory2Name() {
		return category2Name;
	}

	public void setCategory2Name(String category2Name) {
		this.category2Name = category2Name;
	}

	@Override
	public String toString() {
		return super.toString() + 
			"ProductDTO [category1Name=" + category1Name + ", category2Name=" + category2Name + "]";
	}
	
}
