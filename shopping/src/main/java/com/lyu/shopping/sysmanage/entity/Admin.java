package com.lyu.shopping.sysmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 类描述：管理员实体类
 * 类名称：com.lyu.shopping.sysmanage.entity.Admin
 * @author 曲健磊
 * 2018年2月25日.下午1:36:35
 * @version V1.0
 */
public class Admin implements Serializable {

	private static final long serialVersionUID = -8473741577132087469L;

	private Long id;

    private String loginName;

    private String adminName;

    private String password;

    private String email;

    private String mobile;

    private String sex;

    private Integer age;
    
    private String address;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer delFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", loginName=" + loginName + ", adminName=" + adminName + ", password=" + password
				+ ", email=" + email + ", mobile=" + mobile + ", sex=" + sex + ", age=" + age + ", address=" + address
				+ ", status=" + status + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", delFlag="
				+ delFlag + "]";
	}
	
}
