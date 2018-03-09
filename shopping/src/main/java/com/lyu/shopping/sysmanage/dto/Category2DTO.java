package com.lyu.shopping.sysmanage.dto;

import com.lyu.shopping.sysmanage.entity.Category2;

/**
 * 类描述：二级类目数据传输对象
 * 类名称：com.lyu.shopping.sysmanage.dto.Category2DTO
 * @author 曲健磊
 * 2018年3月9日.下午3:48:54
 * @version V1.0
 */
public class Category2DTO extends Category2 {

	private static final long serialVersionUID = 5369689908955797465L;

	private String category1Name;

	public String getCategory1Name() {
		return category1Name;
	}

	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}
	
}
