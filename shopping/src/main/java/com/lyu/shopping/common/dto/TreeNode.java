package com.lyu.shopping.common.dto;

import java.io.Serializable;

/**
 * 类描述：用来传输树形结构的数据
 * 类名称：com.lyu.shopping.common.dto.TreeNode
 * @author 曲健磊
 * 2018年3月15日.下午5:01:16
 * @version V1.0
 */
public class TreeNode implements Serializable {

	private static final long serialVersionUID = 3036899179503300896L;

	private Long id;
	
	private Long pId;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
