package com.lyu.shopping.sysmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 类描述：用户实体类
 * 类名称：com.lyu.shopping.sysmanage.entity.User
 * @author 曲健磊
 * 2018年2月25日.下午1:36:35
 * @version V1.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = -8473741577132087469L;

	private Long id;

    private String loginName;

    private String username;

    private String password;

    private String email;

    private String mobile;

    private String sex;

    private Integer age;
    
    private String address;

    private Integer status;

    private Integer isAdmin;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDeleted;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
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

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", mobile=" + mobile + ", sex=" + sex + ", age=" + age + ", address=" + address
				+ ", status=" + status + ", isAdmin=" + isAdmin + ", gmtCreate=" + gmtCreate + ", gmtModified="
				+ gmtModified + ", isDeleted=" + isDeleted + "]";
	}

}
