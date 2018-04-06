package com.lyu.shopping.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.shopping.sysmanage.mapper.ProductMapper;

/**
 * 类描述：用于对ProductMapper进行测试
 * 类名称：com.lyu.shopping.test.ProductMapperTest
 * @author 曲健磊
 * 2018年4月6日.上午9:57:56
 * @version V1.0
 */
public class ProductMapperTest {

	private ClassPathXmlApplicationContext application;
	
	@Before
	public void init() {
		application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 测试获取商品的点击量
	 */
	@Test
	public void testGetProductHitsByPId() {
		ProductMapper productMapper = (ProductMapper) application.getBean("productMapper");
		Long productId = 6L;
		int hits = productMapper.getProductHitsByPId(productId);
		System.out.println("商品id为：" + productId + "的商品的点击量为：" + hits);
	}
	
}
