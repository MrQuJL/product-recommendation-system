package com.lyu.shopping.front.entity;

import java.io.Serializable;

import com.lyu.shopping.sysmanage.entity.Product;

/**
 * 类描述：购物项实体类
 * 类名称：com.lyu.shopping.front.entity.CartItem
 * @author 曲健磊
 * 2018年5月4日.下午7:44:41
 * @version V1.0
 */
public class CartItem implements Serializable {

	private static final long serialVersionUID = -423498868525620891L;
	
	/**
	 * 购物车中的商品信息
	 */
	private Product product;
	
	/**
	 * 购物车中商品的单价
	 */
	private Double price = 1.0;
	
	/**
	 * 商品的数量
	 */
	private Integer count;
	
	/**
	 * 价格小记
	 */
	private Double subtotal;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return count * getPrice();
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

}
