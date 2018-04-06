package com.lyu.shopping.sysmanage.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.sysmanage.controller.ProductController;
import com.lyu.shopping.sysmanage.dto.ProductDTO;
import com.lyu.shopping.sysmanage.entity.Category2;
import com.lyu.shopping.sysmanage.entity.Product;
import com.lyu.shopping.sysmanage.mapper.Category2Mapper;
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
    
    @Autowired
    private Category2Mapper category2Mapper;
    
    @Override
    public Product getProductByProductId(Long productId) {
        // 如果id为空则为空指针
        if (productId == null) {
            return null;
        }
        
        return this.productMapper.getProductByProductId(productId);
        
    }
    
	@Override
	public List<ProductDTO> listProductByCategory2Id(Long category2Id) {
		
		Product product = new Product();
		product.setCategory2Id(category2Id);
		List<ProductDTO> productList = this.productMapper.listProduct(product);
		
		return productList;
	}
    
    @Override
    public PageInfo<ProductDTO> listProductPage(Product product, PageParam pageParam) {
        if (product == null) {
            return null;
        }
        if ("all".equals(product.getProductName())) {
            product.setProductName(null);
        }
        if (product.getCategory1Id() != null && product.getCategory1Id().equals(0L)) {
            product.setCategory1Id(null);
        }
        if (product.getCategory2Id() != null && product.getCategory2Id().equals(0L)) {
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

    @Override
    public boolean saveProduct(Product product) {
        if (product == null || product.getCategory2Id() == null) {
            return false;
        }
        
        // 根据二级类目的id找到所属的一级类目
        Category2 category2 = this.category2Mapper.getCategory2ById(product.getCategory2Id());
        product.setCategory1Id(category2.getCategory1Id());
        // 设置商品的点击量
        product.setHits(0L);
        // 设置商品的创建时间
        product.setGmtCreate(new Date());
        // 设置商品的修改时间
        product.setGmtModified(new Date());
        // 设置商品的修改标识
        product.setDelFlag(0);
        
        boolean flag = false;
        int rows = this.productMapper.saveProduct(product);
        if (rows > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateProduct(Product product) {
        if (product == null) {
            return false;
        }
        // 查找二级类目所属的一级类目
        if (product.getCategory2Id() == null) {
            return false;
        }
        Category2 category2 = this.category2Mapper.getCategory2ById(product.getCategory2Id());
        product.setCategory1Id(category2.getCategory1Id());
        // 设置商品的图片地址
        if (product.getImgSrc() == "") {
            product.setImgSrc(null);
        }
        // 刷新修改时间
        product.setGmtModified(new Date());
        
        boolean flag = false;
        int rows = this.productMapper.updateProduct(product);
        if (rows > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public boolean updateProductHitsByProductId(Long productId) {
		// 1.获取当前商品的点击量
    	long hits = this.productMapper.getProductHitsByPId(productId);
    	// 2.点击量+1再存进去
    	Product product = new Product();
    	product.setProductId(productId);
    	product.setHits(++hits);
    	int rows = this.productMapper.updateProduct(product);
    	
		return rows > 0 ? true : false;
	}
    
    @Override
    public boolean removeProduct(Long productId) {
        if (productId == null) {
            return false;
        }
        boolean flag = false;
        // 先获取商品的详细信息
        Product product = this.productMapper.getProductByProductId(productId);
        // 删除商品
        int rows = this.productMapper.removeProduct(productId);
        if (rows > 0) {
            flag = true;
            // 删除图片
            String absolutePath = product.getImgSrc().replaceAll("/images/product", ProductController.IMG_SERVER_PATH);
            File originPic = new File(absolutePath);
            if (originPic.exists()) {
                originPic.delete();
            }
        }
        return flag;
    }

    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
    public boolean removeProductBatch(Long[] productIds) {
        if (productIds == null || productIds.length == 0) {
            return false;
        }
        
        for (Long productId : productIds) {
            boolean flag = removeProduct(productId);
            if (!flag) { // 有一个没有删除成功就返回false，事务进行回滚
                return false;
            }
        }
        
        return true;
    }

}
