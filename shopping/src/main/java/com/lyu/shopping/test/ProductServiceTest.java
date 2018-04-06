package com.lyu.shopping.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
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
	 * 测试查询商品列表
	 */
	@Test
	public void testListProduct() {
		ProductService productService = (ProductService) this.application.getBean("productService");
		Product product = new Product();
		product.setProductId(1L);;
		PageInfo<ProductDTO> pageInfo = productService.listProductPage(product, null);
		for (ProductDTO tempProductDTO : pageInfo.getList()) {
			System.out.println(tempProductDTO);
		}
	}
	
	/**
	 * 测试更新商品状态
	 */
	@Test
	public void testUpdateProductStatus() {
		ProductService productService = (ProductService) this.application.getBean("productService");
		boolean flag = productService.updateProductStatus(1L, 1);
		if (flag) {
			System.out.println("隐藏商品1L成功");
		} else {
			System.out.println("隐藏商品1L失败");
		}
	}
	
	/**
	 * 测试更新商品状态
	 */
	@Test
	public void testSaveProduct() {
		ProductService productService = (ProductService) this.application.getBean("productService");
		Product product = new Product();
		product.setProductName("测试商品");
		product.setCategory2Id(15L);
		product.setPurchasePrice(100.0);
		product.setSalePrice(230.0);
		product.setInventory(200);
		product.setImgSrc("/www");
		product.setDescription("测试描述");
		product.setShowFlag(1);
		boolean flag = productService.saveProduct(product);
		if (flag) {
			System.out.println("添加商品成功");
		}else {
			System.out.println("添加商品成功");
		}
	}
	
	/**
	 * 测试根据商品id获取商品的详细信息
	 */
	@Test
	public void testGetProductByProductId() {
		ProductService productService = (ProductService) this.application.getBean("productService");
		Product product = productService.getProductByProductId(1L);
		System.out.println(product);
	}
	
	/**
	 * 测试逻辑删除商品
	 */
	@Test
	public void testRemoveProductByProductId() {
		ProductService productService = (ProductService) this.application.getBean("productService");
		boolean flag = productService.removeProduct(57L);
		System.out.println(flag);
	}
	
	/**
	 * 测试根据二级类目的id查询商品
	 */
	@Test
    public void testGetProductByCategory2Id() {
		ProductService productService = (ProductService) this.application.getBean("productService");
		List<ProductDTO> productList = productService.listProductByCategory2Id(23L);
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO.getProductName());
		}
    }
	
	/**
	 * 测试更新商品的点击量
	 */
	@Test
	public void testUpdateProductHits() {
		ProductService productService = (ProductService) this.application.getBean("productService");
		Product product = new Product();
		product.setProductId(1L);
		boolean flag = productService.updateProductHitsByProductId(product.getProductId());
		if (flag) {
			System.out.println("更新商品点击量成功!");
		} else {
			System.out.println("更新商品点击量失败!");
		}
	}
	
}
