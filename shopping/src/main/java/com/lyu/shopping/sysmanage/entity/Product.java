package com.lyu.shopping.sysmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 类描述：商品类
 * 类名称：com.lyu.shopping.sysmanage.entity.Product
 * @author 曲健磊
 * 2018年3月13日.上午9:17:22
 * @version V1.0
 */
public class Product implements Serializable {

	private static final long serialVersionUID = -9050786795231425743L;

	private Long productId;

	private String productName;

	private Long category1Id;

	private Long category2Id;

	private Double purchasePrice;

	private Double salePrice;

	private Integer inventory;

	// 商品的点击量
	private Long hits;

	private String imgSrc;

	private String description;

	private Date gmtCreate;

	private Date gmtModified;

	private Integer showFlag;

	private Integer delFlag;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(Long category1Id) {
		this.category1Id = category1Id;
	}

	public Long getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(Long category2Id) {
		this.category2Id = category2Id;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Product [productId=" + productId + ", productName=" + productName + ", category1Id=" + category1Id
				+ ", category2Id=" + category2Id + ", purchasePrice=" + purchasePrice + ", salePrice=" + salePrice
				+ ", inventory=" + inventory + ", hits=" + hits + ", imgSrc=" + imgSrc + ", description=" + description
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", showFlag=" + showFlag + ", delFlag="
				+ delFlag + "]";
	}

}
