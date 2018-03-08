package com.lyu.shopping.sysmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 类描述：二级类目实体类
 * 类名称：com.lyu.shopping.sysmanage.entity.Category2
 * @author 曲健磊
 * 2018年3月8日.下午5:13:57
 * @version V1.0
 */
public class Category2 implements Serializable {
	
	private static final long serialVersionUID = -3429777822800745987L;

	private Long category2Id;

    private String category2Name;

    private String category2Record;
    
    private Long category1Id;
    
    private Date gmtCreate;

    private Date gmtModified;

    private Integer showFlag;

    private Integer delFlag;

	public Long getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(Long category2Id) {
		this.category2Id = category2Id;
	}

	public String getCategory2Name() {
		return category2Name;
	}

	public void setCategory2Name(String category2Name) {
		this.category2Name = category2Name;
	}

	public String getCategory2Record() {
		return category2Record;
	}

	public void setCategory2Record(String category2Record) {
		this.category2Record = category2Record;
	}

	public Long getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(Long category1Id) {
		this.category1Id = category1Id;
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
	
}