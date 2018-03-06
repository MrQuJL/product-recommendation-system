package com.lyu.shopping.sysmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 类描述：一级类目实体类
 * 类名称：com.lyu.shopping.sysmanage.entity.Category1
 * @author 曲健磊
 * 2018年3月3日.下午5:46:07
 * @version V1.0
 */
public class Category1 implements Serializable {
	
	private static final long serialVersionUID = -3429777822800745987L;

	private Long category1Id;

    private String category1Name;

    private String category1Record;
    
    private Date gmtCreate;

    private Date gmtModified;

    private Integer showFlag;

    private Integer delFlag;

	public Long getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(Long category1Id) {
		this.category1Id = category1Id;
	}

	public String getCategory1Name() {
		return category1Name;
	}

	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}

	public String getCategory1Record() {
		return category1Record;
	}

	public void setCategory1Record(String category1Record) {
		this.category1Record = category1Record;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Integer getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(Integer showFlag) {
		this.showFlag = showFlag;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "Category1 [category1Id=" + category1Id + ", category1Name=" + category1Name + ", category1Record="
				+ category1Record + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", showFlag="
				+ showFlag + ", delFlag=" + delFlag + "]";
	}
	
}