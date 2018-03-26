package com.lyu.shopping.recommendate.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.lyu.shopping.recommendate.dto.UserActiveDTO;
import com.lyu.shopping.sysmanage.entity.Product;

/**
 * 类描述：用于商品推荐的工具类
 * 类名称：com.lyu.shopping.recommendate.util.RecommendUtils
 * @author 曲健磊
 * 2018年3月25日.下午8:10:41
 * @version V1.0
 */
public class RecommendUtils {
	
	/**
	 * 更新用户的购买行为，最终插入数据库中
	 * @param userId 用户id
	 * @param itemId 商品id
	 * @return true则更新成功，false则更新失败
	 */
	public boolean updateBuyingBehavior(Long userId, Long itemId) {
		boolean flag = false;
		
		
		return flag;
	}
	
	/**
	 * 将用户的购买行为组装成一个map,key为userId，value也是一个map，这个map记录的是二级类目以及它对应的点击量
	 * @param userActiveList 用户的购买行为列表
	 * @return 组装好的用户的购买行为的map集合
	 */
	public ConcurrentHashMap<Long, ConcurrentHashMap<Long, Long>> assembleUserBehavior(List<UserActiveDTO> userActiveList) {
		ConcurrentHashMap<Long, ConcurrentHashMap<Long, Long>> activeMap = new ConcurrentHashMap<Long, ConcurrentHashMap<Long, Long>>();
		
		
		
		
		return activeMap;
	}
	
	/**
	 * 计算用户与用户之间的相似性，最终插入数据库中
	 * @param activeMap 用户对各个二级类目的购买行为的一个map集合
	 * @return 计算出的相似度对的个数
	 */
	public int calcSimilarityBetweenUsers(ConcurrentHashMap<Long, ConcurrentHashMap<Long, Long>> activeMap) {
		int rows = 0;
		
		return rows;
	}
	
	/**
	 * 获取某个用户与其他用户之间的相似度列表,只返回相似度最高的topN个
	 * @param userId 用户id
	 * @return userId与其他用户之间的相似度集合
	 */
	public List<Long> getSimilarityBetweenUsers(Long userId, Integer topN) {
		List<Long> similarityList = new ArrayList<Long>();
		
		
		
		return similarityList;
	}
	
	/**
	 * 从与userId相似的用户集合similarUserList中找出要推荐的商品
	 * @param userId 被推荐商品的用户id
	 * @param similarUserList 用userId相似的用户集合
	 * @return 可以推荐给userId的商品列表
	 */
	public List<Product> getRecommendateCategory2(Long userId, List<Long> similarUserList) {
		List<Product> recommeddateProductList = new ArrayList<Product>();
		
		
		
		return recommeddateProductList;
	}
	
	/**
	 * 找出当二级类目下点击量最高的前n个商品
	 * @param category2Id
	 * @return
	 */
	public List<Product> findTopNProducts(Long category2Id) {
		List<Product> recommeddateProductList = new ArrayList<Product>();
		
		
		return recommeddateProductList;
	}
	
	
}
