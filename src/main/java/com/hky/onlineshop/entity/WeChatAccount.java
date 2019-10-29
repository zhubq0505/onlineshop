package com.hky.onlineshop.entity;

import java.util.Date;

public class WeChatAccount {
	private Long wechatAccountId;
	private String openId;
	private Date createTime;
	private UserInfo userInfo;
	
	public Long getWechatAccountId() {
		return wechatAccountId;
	}
	public void setWechatAccountId(Long wechatAccountId) {
		this.wechatAccountId = wechatAccountId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
