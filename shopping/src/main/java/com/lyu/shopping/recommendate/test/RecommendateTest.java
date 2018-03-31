package com.lyu.shopping.recommendate.test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.shopping.recommendate.dto.UserActiveDTO;
import com.lyu.shopping.recommendate.dto.UserSimilarityDTO;
import com.lyu.shopping.recommendate.service.UserActiveService;
import com.lyu.shopping.recommendate.service.impl.UserSimilarityServiceImpl;
import com.lyu.shopping.recommendate.util.RecommendUtils;

/**
 * 类描述：测试推荐模块中的一些功能
 * 类名称：com.lyu.shopping.recommendate.test.RecommendateTest
 * @author 曲健磊
 * 2018年3月26日.下午6:57:01
 * @version V1.0
 */
public class RecommendateTest {

    private ClassPathXmlApplicationContext application;
    
    @Before
    public void init() {
        application = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    /**
     * 测试列出所有用户的购买行为的方法
     */
    @Test
    public void testListAllUserActive() {
        UserActiveService userActiveService = (UserActiveService) application.getBean("userActiveService");
        
        List<UserActiveDTO> userActiveDTOList = userActiveService.listAllUserActive();
        
        for (UserActiveDTO userActiveDTO : userActiveDTOList) {
            System.out.println(userActiveDTO.getUserId() + "\t" + userActiveDTO.getCategory2Id() + "\t" + userActiveDTO.getHits());
        }
    }
    
    /**
     * 测试组装用户行为数据的方法
     */
    @Test
    public void testAssembleUserBehavior() {
        UserActiveService userActiveService = (UserActiveService) application.getBean("userActiveService");
        
        List<UserActiveDTO> userActiveDTOList = userActiveService.listAllUserActive();
        
        ConcurrentHashMap<Long, ConcurrentHashMap<Long, Long>> activeMap = RecommendUtils.assembleUserBehavior(userActiveDTOList);
        
        System.out.println(activeMap.size());
    }
    
    /**
     * 计算用户的相似度
     */
    @Test
    public void testCalcSimilarityBetweenUser() {
        UserActiveService userActiveService = (UserActiveService) application.getBean("userActiveService");
        UserSimilarityServiceImpl userSimilarityService = (UserSimilarityServiceImpl) application.getBean("userSimilarityService");
        // 查询出所有用户对不同二级类目的点击行为
        List<UserActiveDTO> userActiveDTOList = userActiveService.listAllUserActive();
        // 将每个用户对每个二级类目的点击行为封装成一个个map
        ConcurrentHashMap<Long, ConcurrentHashMap<Long, Long>> activeMap = RecommendUtils.assembleUserBehavior(userActiveDTOList);
        
        // System.out.println(activeMap.size());
        // 计算出这个map中用户与用户之间的相似度
        List<UserSimilarityDTO> similarityList = RecommendUtils.calcSimilarityBetweenUsers(activeMap);
        
        // System.out.println(similarityList.size());
        // 打印结果    -- 
        for (UserSimilarityDTO usim : similarityList) {
            System.out.println(usim.getUserId() + "\t" + usim.getUserRefId() + "\t" + usim.getSimilarity());
            boolean flag = userSimilarityService.saveUserSimilarity(usim);
            if (flag) {
            	System.out.println("插入数据成功");
            }
        }
    }
    
    /**
     * 测试查询用户相似度集合列表
     */
    @Test
    public void testListUserSimilarity() {
    	
    	UserSimilarityServiceImpl userSimilarityService = (UserSimilarityServiceImpl) application.getBean("userSimilarityService");
        
    	List<UserSimilarityDTO> userSimilarityList = userSimilarityService.listUserSimilarityByUId(2L);
    	
    	for (UserSimilarityDTO userSimilarityDTO : userSimilarityList) {
    		System.out.println(userSimilarityDTO.getUserId() + "\t" + userSimilarityDTO.getUserRefId() + "\t" + userSimilarityDTO.getSimilarity());
    	}
    	
    }
 
    /**
     * 测试取出与指定用户相似度最高的前N个用户
     */
    @Test
    public void testGetTopNUser() {
    	
    	UserSimilarityServiceImpl userSimilarityService = (UserSimilarityServiceImpl) application.getBean("userSimilarityService");
        
    	List<UserSimilarityDTO> userSimilarityList = userSimilarityService.listUserSimilarityByUId(2L);
    	
    	for (UserSimilarityDTO userSimilarityDTO : userSimilarityList) {
    		System.out.println(userSimilarityDTO.getUserId() + "\t" + userSimilarityDTO.getUserRefId() + "\t" + userSimilarityDTO.getSimilarity());
    	}
    	List<Long> userIds = RecommendUtils.getSimilarityBetweenUsers(2L, userSimilarityList, 2);
    	
    	System.out.println("与" + 2 + "号用户最相似的前2个用户为：");
    	
    	for (Long userRefId : userIds) {
    		System.out.println(userRefId);
    	}
    	
    }
    
    /**
     * 获取被推荐的类目id列表
     */
    @Test
    public void testGetRecommendateCategoy2() {
    	
    	UserSimilarityServiceImpl userSimilarityService = (UserSimilarityServiceImpl) application.getBean("userSimilarityService");
    	
    	UserActiveService userActiveService = (UserActiveService) application.getBean("userActiveService");
    	
    	List<UserSimilarityDTO> userSimilarityList = userSimilarityService.listUserSimilarityByUId(1L);
    	
    	List<UserActiveDTO> userActiveList = userActiveService.listAllUserActive();
    	
    	for (UserSimilarityDTO userSimilarityDTO : userSimilarityList) {
    		System.out.println(userSimilarityDTO.getUserId() + "\t" + userSimilarityDTO.getUserRefId() + "\t" + userSimilarityDTO.getSimilarity());
    	}
    	List<Long> userIds = RecommendUtils.getSimilarityBetweenUsers(1L, userSimilarityList, 2);
    	
    	System.out.println("与" + 1 + "号用户最相似的前3个用户为：");
    	
    	for (Long userRefId : userIds) {
    		System.out.println(userRefId);
    	}

    	List<Long> recommendateCategory2 = RecommendUtils.getRecommendateCategory2(1L, userIds, userActiveList);
    	
    	for (Long category2Id : recommendateCategory2) {
    		System.out.println("被推荐的二级类目：" + category2Id);
    	}
    	
    }
}
