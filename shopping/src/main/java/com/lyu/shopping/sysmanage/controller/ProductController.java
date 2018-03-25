package com.lyu.shopping.sysmanage.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lyu.shopping.common.dto.PageParam;
import com.lyu.shopping.common.util.PageUtils;
import com.lyu.shopping.sysmanage.dto.Category1DTO;
import com.lyu.shopping.sysmanage.dto.Category2DTO;
import com.lyu.shopping.sysmanage.dto.ProductDTO;
import com.lyu.shopping.sysmanage.entity.Category2;
import com.lyu.shopping.sysmanage.entity.Product;
import com.lyu.shopping.sysmanage.service.Category1Service;
import com.lyu.shopping.sysmanage.service.Category2Service;
import com.lyu.shopping.sysmanage.service.ProductService;

/**
 * 类描述：用于处理对商品的一些请求
 * 类名称：com.lyu.shopping.sysmanage.controller.ProductController
 * @author 曲健磊
 * 2018年3月11日.下午4:15:59
 * @version V1.0
 */
@Controller
@RequestMapping(value="/sysmgr/product")
public class ProductController {
	
	/**
	 * 商品列表页面的URI
	 */
	private static final String PRODUCT_LIST_URI = "/sysmanage/product/productList";
	
	/**
	 * 商品编辑页面的URI
	 */
	private static final String PRODUCT_EDIT_URI = "/sysmanage/product/productEdit";
	
	/**
	 * 前台封装的分页查询商品的方法
	 */
	private static final String PRODUCT_QUERY_METHOD_PAGE = "productMgr.listProduct";
	
	/**
	 * 前台商品列表对象的属性名
	 */
	private static final String FRONT_PRODUCTLIST_ATTR = "productList";
	
	/**
	 * 进行二级联动的二级类目列表
	 */
	private static final String FRONT_CATEGORY2LIST_ATTR = "category2List";
	
	/**
	 * 前台分页条对象的属性名
	 */
	private static final String FRONT_LISTSIZE_ATTR = "listSize";
	
	/**
	 * 前台分页条对象的属性名
	 */
	private static final String FRONT_PAGEBAR_ATTR = "pageBar";
	
	/**
	 * 前台提示信息的属性名
	 */
	private static final String FRONT_MSG_ATTR = "message";
	
	/**
	 * 商品状态修改成功的提示信息
	 */
	private static final String FRONT_PRODUCT_STATUS_CHANGE_SUCCESS = "success";
	
	/**
	 * 商品状态修改失败的提示信息
	 */
	private static final String FRONT_PRODUCT_STATUS_CHANGE_FAILED = "failed";
	
	/**
	 * 商品删除成功的提示信息
	 */
	private static final String FRONT_PRODUCT_REMOVE_SUCCESS = "success";
	
	/**
	 * 商品删除失败的提示信息
	 */
	private static final String FRONT_PRODUCT_REMOVE_FAILED = "failed";
	
	
	/**
	 * 上传的图片所在的图片服务器的地址
	 */
	public static final String IMG_SERVER_PATH = "D:/file/product";
	
	@Autowired
	private Category1Service category1Service;
	
	@Autowired
	private Category2Service category2Service;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 处理前往商品列表页面的请求
	 * @return
	 */
	@RequestMapping(value="/gotoProductList")
	public String gotoProductList(HttpSession session) {
		// 在进入商品列表页面时加载所有的一级类目，二级类目，商品名称
		List<Category1DTO> category1List = category1Service.listCategory1DTO(null);
		List<Category2DTO> category2List = category2Service.listCategory2(null);
		List<String> productNames = productService.listAllProductName();
		
		session.setAttribute("category1List", category1List);
		session.setAttribute("category2List", category2List);
		session.setAttribute("productNames", productNames);
		
		return PRODUCT_LIST_URI;
	}

	/**
	 * 处理前往商品编辑页面的请求
	 * 进入商品编辑列表时根据修改或者新增标识(productId)来对页面进行初始化
	 * @return
	 */
	@RequestMapping(value="/gotoProductEdit/{productId}")
	public String gotoProductEdit(@PathVariable(value="productId") Long productId, HttpSession session,
		HttpServletRequest request) {
		if (session.getAttribute("category2List") == null) { // 如果没有加载二级类目列表就加载
			List<Category2DTO> category2List = category2Service.listCategory2(null);
			session.setAttribute("category2List", category2List);
		}
		if (productId != -1) { // 为修改商品的请求
			System.out.println("要修改的商品id：" + productId);
			// 根据id获取该商品的详细信息
			Product product = this.productService.getProductByProductId(productId);
			request.setAttribute("product", product);
		} else {
			System.out.println("这是新增商品的请求");
			
		}
		
		return PRODUCT_EDIT_URI;
	}
	
	/**
	 * 当所选择某个一级类目的时候对相应的二级类目进行联动
	 * @param category1Id 选中的一级类目
	 * @return 该一级类目下的二级类目列表
	 */
	@RequestMapping("/changeCategory2")
	public @ResponseBody Map<String, Object> changeCategory2(Long category1Id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Category2 category2 = new Category2();
		if (category1Id.equals(0L)) { // 前台传过来的0表示是全部的一级类目，则此时查询的二级类目也是全部的二级类目
			category2.setCategory1Id(null);
		} else {
			category2.setCategory1Id(category1Id);
		}
		
		List<Category2DTO> category2List = this.category2Service.listCategory2(category2);
		resultMap.put(FRONT_CATEGORY2LIST_ATTR, category2List);
		
		return resultMap;
	}
	
	/**
	 * 处理查询商品的请求
	 * @param product 封装了要查询的商品需要满足的条件
	 * @param pageNum 第几页
	 * @param pageSize 每页多少条
	 * @return 封装有商品列表以及分页信息的map集合
	 */
	@RequestMapping(value="/listProduct/{pageNum}/{pageSize}")
	public @ResponseBody Map<String, Object> listProduct(@RequestBody Product product,
		@PathVariable(value="pageNum") Integer pageNum, @PathVariable(value="pageSize") Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		PageParam pageParam = new PageParam(pageNum, pageSize);
		if (pageNum == null || pageSize == null) {
			pageParam = null;
		}
		
		PageInfo<ProductDTO> productInfo = this.productService.listProductPage(product, pageParam);
		// 1.获取商品列表
		List<ProductDTO> productList = productInfo.getList();
		// 2.获取分页条
		String pageBar = PageUtils.pageStr(productInfo, PRODUCT_QUERY_METHOD_PAGE);
		// 3.统计公有多少条记录
		Long listSize = productInfo.getTotal();
		
		map.put(FRONT_PRODUCTLIST_ATTR, productList);
		map.put(FRONT_LISTSIZE_ATTR, listSize);
		map.put(FRONT_PAGEBAR_ATTR, pageBar);
		
		return map;
	}
	
	/**
	 * 上架或者下架商品
	 * @param changeValue 上架下架的标志，0表示下架，1表示上架
	 * @param productId 要上架/下架的商品id
	 * @return 上架/下架商品成功/失败的提示消息
	 */
	@RequestMapping(value="/showOrHideProduct/{changeValue}/{productId}")
	public @ResponseBody Map<String, Object> showOrHideProduct(@PathVariable(value="changeValue") Integer changeValue,
		@PathVariable(value="productId") Long productId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (changeValue.equals(1)) { // 上架商品
			map.put(FRONT_MSG_ATTR, FRONT_PRODUCT_STATUS_CHANGE_FAILED);
			boolean flag = this.productService.updateProductStatus(productId, changeValue);
			if (flag) {
				map.put(FRONT_MSG_ATTR, FRONT_PRODUCT_STATUS_CHANGE_SUCCESS);
			}
			// TODO 为后期业务扩展预留修改的空间
			
			
		} else { // 下架商品
			map.put(FRONT_MSG_ATTR, FRONT_PRODUCT_STATUS_CHANGE_FAILED);
			boolean flag = this.productService.updateProductStatus(productId, changeValue);
			if (flag) {
				map.put(FRONT_MSG_ATTR, FRONT_PRODUCT_STATUS_CHANGE_SUCCESS);
			}
			// TODO 为后期业务扩展预留修改的空间
			
			
		}
		
		return map;
	}
	
	/**
	 * 处理添加或修改商品的请求
	 * @param product 要被添加或者修改的商品
	 * @return
	 */
	@RequestMapping("/saveProduct")
	public String saveProduct(MultipartFile uploadFile, HttpServletRequest request,
		Product product) {
		// 有图片就上传图片
		if(uploadFile != null && uploadFile.getOriginalFilename() != null &&
			uploadFile.getOriginalFilename() != ""){
			//获取上传文件的名称
			String fileName = uploadFile.getOriginalFilename();
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			//为了保险起见,给上传的图片重新指定一个名称
			String tempFileName = UUID.randomUUID().toString()+suffix;
			File fileTemp = new File(IMG_SERVER_PATH);
			if(!fileTemp.exists()){
				fileTemp.mkdirs();
			}
			
			File file = new File(IMG_SERVER_PATH  + "/" +  tempFileName);
			try {
				//讲上传的文件写入指定路径
				uploadFile.transferTo(file);
			} catch (IllegalStateException e) {
 				e.printStackTrace();
			} catch (IOException e) {
 				e.printStackTrace();
			}
			
			// 先把原来在服务器的图片删掉，再为商品赋新的图片的url
			System.out.println(product.getImgSrc());
			// 获取原服务器上图片的存储位置
			String absolutePath = product.getImgSrc().replaceAll("/images/product", IMG_SERVER_PATH);
			File originPic = new File(absolutePath);
			if (originPic.exists()) {
				originPic.delete();
			}
			
			product.setImgSrc("/images/product/" + tempFileName);
			
		}
		
		if (product.getProductId() == null) { // 添加商品
			
			boolean flag = this.productService.saveProduct(product);
			
			if (flag) {
				System.out.println("添加商品成功");
			} else {
				System.out.println("添加商品失败");
			}
			
		} else { // 修改商品
			
			System.out.println("进入修改商品的请求");
			
			boolean flag = this.productService.updateProduct(product);
			
			if (flag) {
				System.out.println("修改商品成功");
			} else {
				System.out.println("修改商品失败");
			}
		}
		
		return "redirect:/sysmgr/product/gotoProductEdit/-1";
	}
	
	/**
	 * 处理商品的删除请求
	 * @param productId 待删除的商品id
	 * @return 删除商品成功与否的信息
	 */
	@RequestMapping("/removeProduct")
	public @ResponseBody Map<String, Object> removeProduct(Long productId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean flag = this.productService.removeProduct(productId);
		
		if (flag) {
			resultMap.put(FRONT_MSG_ATTR, FRONT_PRODUCT_REMOVE_SUCCESS);
		} else {
			resultMap.put(FRONT_MSG_ATTR, FRONT_PRODUCT_REMOVE_FAILED);
		}
		
		return resultMap;
	}
	
	/**
	 * 处理批量删除商品请求
	 * @param productIds 待删除的商品id数组
	 * @return 删除商品成功与否的信息
	 */
	@RequestMapping("/removeProductBatch")
	public @ResponseBody Map<String, Object> removeProductBatch(@RequestBody Long[] productIds) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put(FRONT_MSG_ATTR, FRONT_PRODUCT_REMOVE_FAILED);
		boolean flag = this.productService.removeProductBatch(productIds);
		if (flag) {
			resultMap.put(FRONT_MSG_ATTR, FRONT_PRODUCT_REMOVE_SUCCESS);
		}
		return resultMap;
	}
	
}
