package com.hky.onlineshop.entity;

import java.util.Date;

public class LocalAccount {
	private Long localAccountId;
	private String username;
	private String password;
	private Date createTime;
	private Date lastEditTime;
	private UserInfo userInfo;
	
	public Long getLocalAccountId() {
		return localAccountId;
	}
	public void setLocalAccountId(Long localAccountId) {
		this.localAccountId = localAccountId;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	

}
