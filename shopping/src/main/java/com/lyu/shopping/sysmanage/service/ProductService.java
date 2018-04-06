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
	 * 根据商品id获取商品的详细信息
	 * @param productId 要获取的商品id
	 * @return 商品id为productId的商品的详细信息
	 */
	Product getProductByProductId(Long productId);
	
	/**
	 * 查找二级类目为category2Id的所有商品列表
	 * @param category2Id 二级类目id
	 * @return 该二级类目下的所有商品
	 */
	List<ProductDTO> listProductByCategory2Id(Long category2Id);
	
	/**
	 * 分页查询符合条件的商品列表
	 * @param product 要查询的商品需满足的条件
	 * @param pageParam 分页信息
	 * @return 封装有分页信息的商品DTO列表，包括商品的一级类目名称和商品的二级类目名称
	 */
	PageInfo<ProductDTO> listProductPage(Product product, PageParam pageParam);
	
	/**
	 * 查询出所有商品的名称
	 * @return 所有商品的名称
	 */
	List<String> listAllProductName();
	
	/**
	 * 更新商品的状态
	 * @param productId 要被更新状态的商品id
	 * @param changeValue 1上架，0下架
	 * @return 更新成功与否
	 */
	boolean updateProductStatus(Long productId, Integer changeValue);
	
	/**
	 * 添加商品
	 * @param product 要添加的商品
	 * @return 受影响的行数,返回1表示添加成功
	 */
	boolean saveProduct(Product product);
	
	/**
	 * 修改商品
	 * @param product 要修改的商品
	 * @return true表示修改成功，false表示修改失败
	 */
	boolean updateProduct(Product product);
	
	/**
	 * 通过商品的id更新商品的点击量
	 * @param productId 商品的id
	 * @return true表示更新成功，false表示更新失败
	 */
	boolean updateProductHitsByProductId(Long productId);
	
	/**
	 * 根据商品id删除商品(逻辑删除)
	 * @param productId 商品id
	 * @return true表示删除成功
	 */
	boolean removeProduct(Long productId);
	
	/**
	 * 批量删除商品（逻辑）
	 * @param productIds 要删除的商品的id数组
	 * @return 删除成功与否，只要有一个删除失败，全部进行回滚，全部成功才返回true
	 */
	boolean removeProductBatch(Long[] productIds);
	
}
