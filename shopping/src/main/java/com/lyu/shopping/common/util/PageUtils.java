package com.lyu.shopping.common.util;

import com.github.pagehelper.PageInfo;

/**
 * 类描述：分页工具类
 * 类名称：com.lyu.shopping.common.util.PageUtils
 * @author 曲健磊
 * 2018年3月2日.下午7:19:47
 * @version V1.0
 */
public class PageUtils {

	/**
	 * 根据前台组件生成的分页条
	 * @param pageInfo 分页的信息
	 * @param queryMethod 前台的分页查询方法
	 * @return
	 */
	public static String pageStr (PageInfo<?> pageInfo, String queryMethod) {
		StringBuffer buffer = new StringBuffer("<ul class=\"pagination\">");
		// 判断当前页是不是首页
		if (pageInfo.isIsFirstPage() || pageInfo.getPrePage() ==  0) {
			buffer.append("<li class=\"disabled\"><a href=\"javascript:void(0);\" aria-label=\"Previous\">«</a></li>");
		} else {
			buffer.append("<li><a href=\"javascript:").append(queryMethod).append("(");
			buffer.append(pageInfo.getPrePage()).append(",");
			buffer.append(pageInfo.getPageSize());
			buffer.append(")\" aria-label=\"Previous\">«</a></li>");
		}
		
		// 拼接中间的数字部分
		for (int i = 0; i < pageInfo.getNavigatepageNums().length; i++) {
			int pageNum = pageInfo.getNavigatepageNums()[i];
			// pageNum为当前的页码
			if (pageInfo.getPageNum() == pageNum) {
				buffer.append("<li class=\"active\"><a href=\"javascript:\">");
				buffer.append(pageNum).append("</a></li>");
			} else {
				buffer.append("<li><a href=\"javascript:");
				buffer.append(queryMethod).append("(");
				buffer.append(pageNum).append(",");
				buffer.append(pageInfo.getPageSize()).append(");\">");
				buffer.append(pageNum).append("</a></li>");
			}
		}
		
		// 判断是不是尾页
		if (pageInfo.isIsLastPage() || pageInfo.getNextPage() == 0) {
			buffer.append("<li class=\"disabled\"><a href=\"javascript:void(0);\" aria-label=\"Next\">»</a></li>");
		} else {
			buffer.append("<li><a href=\"javascript:").append(queryMethod).append("(");
			buffer.append(pageInfo.getNextPage()).append(",");
			buffer.append(pageInfo.getPageSize()).append(");");
			buffer.append("\" aria-label=\"Next\">»</a></li>");
		}
		buffer.append("</ul>");
		
		return buffer.toString();
	}
	
}
