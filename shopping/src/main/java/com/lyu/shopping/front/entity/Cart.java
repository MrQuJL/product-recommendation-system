package com.lyu.shopping.front.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类描述：购物车的操作类
 * 类名称：com.lyu.shopping.front.entity.Cart
 * @author 曲健磊
 * 2018年5月4日.下午7:49:42
 * @version V1.0
 */
public class Cart implements Serializable {

	private static final long serialVersionUID = -5850111371133050265L;
	
	/**
	 * 购物车的存放容器
	 * map中的key放的是pid，value放的是购物项CartItem
	 */
	private Map<Long, CartItem> map = new LinkedHashMap<Long, CartItem>();
	
	/**
	 * 购物总计
	 */
	private Double total;

	/**
	 * Cart对象中有一个CartItems属性
	 */
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	
	
	/**
	 * 向购物车添加CartItem
	 * @return
	 */
	public void addCart(CartItem cartItem) {
		Long pid = cartItem.getProduct().getProductId();
		// 判断购物车是否存在同类商品
		if (map.containsKey(pid)) {
			CartItem tempItem = map.get(pid);
			tempItem.setCount(cartItem.getCount() + tempItem.getCount());
		} else {
			map.put(pid, cartItem);
		}
		// 计算总价格
		total += cartItem.getSubtotal();
	}
	
	/**
	 * 向购物车中移除某个购物项
	 * @param pid 需要被移除的购物项的pid
	 */
	public void removeCart(Long pid) {
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}
	
	/**
	 * 清空购物车
	 */
	public void clearCart() {
		// 1.清空map
		map.clear();
		// 2.还原初始值
		total = 0.0;
	}
	
	public Map<Long, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<Long, CartItem> map) {
		this.map = map;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
