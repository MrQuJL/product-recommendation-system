package com.lyu.shopping.test;

import org.junit.Test;

/**
 * 类描述：用于测试余弦相似度的相关公式的计算结果
 * 类名称：com.lyu.shopping.test.TestCos
 * @author 曲健磊
 * 2018年3月25日.下午6:45:19
 * @version V1.0
 */
public class TestCos {

	/**
	 * 验证余弦公式
	 * (向量a * 向量b) / (向量a的模 * 向量b的模)
	 */
	@Test
	public void testCos() {
		System.out.println(349.0 / (Math.sqrt(349.0) * Math.sqrt(449.0)));
		// 相似度0.8816364618024314
	}
	
	
}
