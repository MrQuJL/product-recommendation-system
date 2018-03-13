package com.lyu.shopping.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.dto.ProductDTO;
import com.lyu.shopping.sysmanage.entity.Product;
import com.lyu.shopping.sysmanage.service.ProductService;

/**
 * 类描述：测试商品服务类的一些功能
 * 类名称：com.lyu.shopping.test.ProductServiceTest
 * @author 曲健磊
 * 2018年3月13日.上午10:45:34
 * @version V1.0
 */
public class ProductServiceTest {
	
	private ClassPathXmlApplicationContext application;
	
	@Before
	public void init() {
		application = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 测试查询一级类目列表
	 */
	@Test
	public void testListProduct() {
		ProductService productService = (ProductService) 
			this.application.getBean("productService");
		
		Product product = new Product();
		product.setProductId(1L);;
		
		PageInfo<ProductDTO> pageInfo = productService.listProductPage(product, null);
		
		for (ProductDTO tempProductDTO : pageInfo.getList()) {
			System.out.println(tempProductDTO);
		}
		
	}
	
}
